package com.study.springboot_swagger2_01.crontab;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.study.springboot_swagger2_01.pojo.delConfig.SystemDelConfig;
import com.study.springboot_swagger2_01.pojo.delConfig.TableConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * 根据配置文件，定期删除历史数据
 *
 * @Description:
 * @Author: lilong
 */
@Component
@Slf4j
public class DelExpiredData {
    public static final String YEAR = "year";
    public static final String MONTH = "month";
    public static final String DAY = "day";
    public static final String HOUR = "hour";
    public static final String MINUTE = "minute";
    public static final String VARCHAR = "varchar";
    public static final String TIMESTAMP = "timestamp";
    private static final String CONFIGPATH = "config/delete_expired_conf.json";

    private JdbcTemplate jdbcTemplate;

    private List<SystemDelConfig> systemDelConfigs;


    /**
     * 每小时清理一次过期数据
     */
    @Scheduled(cron = "1 * * * 1 ?")
//    @Scheduled(cron = "*/10 * * * * *")
    public void delExpiredData() {
        log.info("delExpiredData() start ");
        this.init();
        this.handler();
        log.info("delExpiredData() success");
    }


    private void handler() {
        for (SystemDelConfig systemDelConfig : systemDelConfigs) {
            for (TableConfig tableConfig : systemDelConfig.getTableConfigs()) {
                this.handleOneTable(tableConfig);
            }
        }
    }

    private void handleOneTable(TableConfig tableConfig) {
        String tableName = tableConfig.getTableName();

        DateTime lastTime = getLastTime(tableConfig.getRemainTime(), tableConfig.getRemianTimeUnit());
        String formatColumn = formatColumn(tableConfig.getTimeColName(), tableConfig.getTimeColType());
        log.info("tableName:{},remainTime:{},remainTimeUnit:{},formatColumn:{},lastTime:{}", tableName, tableConfig.getRemainTime(), tableConfig.getRemianTimeUnit(), formatColumn, lastTime.toString());

        delTableData(tableName, formatColumn, lastTime.getTime() / 1000);
    }

    private String formatColumn(String timeColName, String timeColType) {
        if (StrUtil.equals(timeColType, VARCHAR)) {
            return String.format("UNIX_TIMESTAMP(%s)", timeColName);
        }
        if (StrUtil.equals(timeColType, TIMESTAMP)) {
            return timeColName;
        }
        return String.format("UNIX_TIMESTAMP(%s)", timeColName);
    }

    private DateTime getLastTime(int remainTime, String remianTimeUnit) {
        DateTime date = DateUtil.date();
        if (StrUtil.equals(remianTimeUnit, MINUTE)) {
            return DateUtil.offsetMinute(date, -remainTime);
        }
        if (StrUtil.equals(remianTimeUnit, HOUR)) {
            return DateUtil.offsetHour(date, -remainTime);
        }
        if (StrUtil.equals(remianTimeUnit, DAY)) {
            return DateUtil.offsetDay(date, -remainTime);
        }
        if (StrUtil.equals(remianTimeUnit, MONTH)) {
            return DateUtil.offsetMonth(date, -remainTime);
        }
        if (StrUtil.equals(remianTimeUnit, YEAR)) {
            return DateUtil.offset(date, DateField.YEAR, -remainTime);
        }
        return DateUtil.offsetMonth(date, -remainTime);
    }

    //删除最终时间lastTime(当前时间-数据保留时间remainTime)以前的所有数据
    private void delTableData(String tableName, String timeColName, long lastTime) {
        String delSql = "delete from {} where {} < {}";
        String exceSql = StrUtil.format(delSql, tableName, timeColName, lastTime);
        log.info("delTableDataSql:{}", exceSql);
        jdbcTemplate.execute(exceSql);
    }

    private void init() {
        String configStr = ResourceUtil.readUtf8Str(CONFIGPATH);
        this.systemDelConfigs = JSONUtil.toList(configStr, SystemDelConfig.class);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

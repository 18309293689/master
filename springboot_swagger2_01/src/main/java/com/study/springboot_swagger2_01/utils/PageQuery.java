package com.study.springboot_swagger2_01.utils;


import com.study.springboot_swagger2_01.message.ErrorCodeAndMsg;
import com.study.springboot_swagger2_01.message.SystemException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Lhw
 * @since 2020/8/10
 */
@Data
@ApiModel("分页")
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页",example = "1")
    private Integer pageNo;

    @ApiModelProperty(value = "每页显示数",example = "1")
    private Integer pageSize;

    public static void pageParamCheck(Integer pageNo, Integer pageSize) {
        if (Objects.isNull(pageNo)) {
            throw new SystemException(ErrorCodeAndMsg.PAGE_NO_IS_NOT_NULL);
        }
        if (Objects.isNull(pageSize)) {
            throw new SystemException(ErrorCodeAndMsg.PAGE_SIZE_IS_NOT_NULL);
        }
        if (pageNo <= 0) {
            throw new SystemException(ErrorCodeAndMsg.PAGE_NO_LESS_ZERO);
        }
        if (pageSize <= 0) {
            throw new SystemException(ErrorCodeAndMsg.PAGE_SIZE_LESS_ZERO);
        }
    }
}

package com.study.springboot_swagger2_01.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 分页结果集
 * </p>
 *
 * @package: com.xkcoding.codegen.common
 * @description: 分页结果集
 * @author: yangkai.shen
 * @date: Created in 2019-03-22 11:24
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@AllArgsConstructor
public class PageResult<T> {
    /**
     * 总条数
     */
    private Long total;

    /**
     * 页码
     */
    private Integer pageNumber;

    /**
     * 每页结果数
     */
    private Integer pageSize;

    /**
     * 结果集
     */
    private List<T> list;
}

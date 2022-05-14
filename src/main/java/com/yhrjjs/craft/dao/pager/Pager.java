package com.yhrjjs.craft.dao.pager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pager {
    /**
     * 第几页，从1开始
     */
    private int pageNumber;
    /**
     * 每页显示记录数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int pageCount;
    /**
     * 总记录数
     */
    private int recordCount;
}

package it.pkg.basic.common.utils.result;

import lombok.Data;

import java.util.List;

/**
 * @author cjunl
 */

@Data
public class Pagination<T> extends ToString {
    private static final long serialVersionUID = 650211301510648822L;

    private List<T> list;
    private long total = 0L;
    private long pageNum = 1L;
    private long pageSize = 10L;
}
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.utils.request;

import lombok.Data;

/**
 * 分页列表请求级别信息
 *
 * @author cjunl
 */
@Data
public class PageBaseReq extends BaseReq {
    private int pageSize = 1000;
    private int pageStart = 1;
}

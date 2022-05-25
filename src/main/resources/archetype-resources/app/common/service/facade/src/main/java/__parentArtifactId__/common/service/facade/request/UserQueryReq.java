#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.service.facade.request;

import ${package}.${parentArtifactId}.common.service.facade.dto.user.UserQueryDTO;
import ${package}.${parentArtifactId}.common.utils.request.PageBaseReq;
import ${package}.${parentArtifactId}.common.service.facade.enums.SortEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;

/**
 * @author cjunl
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryReq extends PageBaseReq {

    @Valid
    private UserQueryDTO query;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序方式
     *
     * @see SortEnum
     */
    private String orderDir;
}
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.service.facade.response;

import ${package}.${parentArtifactId}.common.service.facade.dto.user.UserDTO;
import ${package}.${parentArtifactId}.common.utils.result.Pagination;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cjunl
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQueryResp extends Pagination<UserDTO> {
}

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.service.facade.api;

import ${package}.${parentArtifactId}.common.service.facade.request.UserQueryReq;
import ${package}.${parentArtifactId}.common.service.facade.response.UserQueryResp;
import ${package}.${parentArtifactId}.common.utils.result.Result;

/**
 * @author cjunl
 */
public interface UserFacade {

    Result<UserQueryResp> queryUserList(UserQueryReq req);
}

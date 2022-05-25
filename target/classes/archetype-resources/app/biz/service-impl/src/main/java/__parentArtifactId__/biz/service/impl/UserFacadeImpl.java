#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.biz.service.impl;

import ${package}.${parentArtifactId}.biz.manage.UserManage;
import ${package}.${parentArtifactId}.biz.service.impl.common.AbstractExecuteCallback;
import ${package}.${parentArtifactId}.biz.service.impl.common.ExecuteTemplate;
import ${package}.${parentArtifactId}.common.service.facade.api.UserFacade;
import ${package}.${parentArtifactId}.common.service.facade.request.UserQueryReq;
import ${package}.${parentArtifactId}.common.service.facade.response.UserQueryResp;
import ${package}.${parentArtifactId}.common.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cjunl
 */
@Service
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserManage userManage;

    @Override
    public Result<UserQueryResp> queryUserList(UserQueryReq userQueryReq) {
        return ExecuteTemplate.execute(new AbstractExecuteCallback<UserQueryResp>() {
            @Override
            public void check() {
            }

            @Override
            public UserQueryResp execute() {
                return userManage.queryUserList(userQueryReq);
            }
        });
    }
}

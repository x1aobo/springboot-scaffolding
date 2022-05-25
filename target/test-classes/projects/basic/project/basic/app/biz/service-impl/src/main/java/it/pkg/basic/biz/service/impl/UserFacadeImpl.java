package it.pkg.basic.biz.service.impl;

import it.pkg.basic.biz.manage.UserManage;
import it.pkg.basic.biz.service.impl.common.AbstractExecuteCallback;
import it.pkg.basic.biz.service.impl.common.ExecuteTemplate;
import it.pkg.basic.common.service.facade.api.UserFacade;
import it.pkg.basic.common.service.facade.request.UserQueryReq;
import it.pkg.basic.common.service.facade.response.UserQueryResp;
import it.pkg.basic.common.utils.result.Result;
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

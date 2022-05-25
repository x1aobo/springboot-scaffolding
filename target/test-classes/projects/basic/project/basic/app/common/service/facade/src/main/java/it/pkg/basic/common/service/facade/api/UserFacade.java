package it.pkg.basic.common.service.facade.api;

import it.pkg.basic.common.service.facade.request.UserQueryReq;
import it.pkg.basic.common.service.facade.response.UserQueryResp;
import it.pkg.basic.common.utils.result.Result;

/**
 * @author cjunl
 */
public interface UserFacade {

    Result<UserQueryResp> queryUserList(UserQueryReq req);
}

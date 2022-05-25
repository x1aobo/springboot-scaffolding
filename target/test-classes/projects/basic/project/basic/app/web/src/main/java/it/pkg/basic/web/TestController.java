package it.pkg.basic.web;

import it.pkg.basic.common.service.facade.api.UserFacade;
import it.pkg.basic.common.service.facade.request.UserQueryReq;
import it.pkg.basic.common.service.facade.response.UserQueryResp;
import it.pkg.basic.common.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 测试
 *
 * @author cjunl
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserFacade userFacade;

    @GetMapping("/queryUserList")
    public Result<UserQueryResp> queryUserList(@Valid @RequestBody UserQueryReq userQueryReq) {
        return userFacade.queryUserList(userQueryReq);
    }
}

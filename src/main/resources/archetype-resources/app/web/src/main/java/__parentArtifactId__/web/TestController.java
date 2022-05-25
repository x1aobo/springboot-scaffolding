#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.web;

import ${package}.${parentArtifactId}.common.service.facade.api.UserFacade;
import ${package}.${parentArtifactId}.common.service.facade.request.UserQueryReq;
import ${package}.${parentArtifactId}.common.service.facade.response.UserQueryResp;
import ${package}.${parentArtifactId}.common.utils.result.Result;
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

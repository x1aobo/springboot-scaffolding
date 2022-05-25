#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.biz.manage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package}.${parentArtifactId}.common.service.facade.request.UserQueryReq;
import ${package}.${parentArtifactId}.common.service.facade.response.UserQueryResp;
import ${package}.${parentArtifactId}.core.convert.user.UserConvert;
import ${package}.${parentArtifactId}.core.model.user.UserModel;
import ${package}.${parentArtifactId}.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cjunl
 */
@Service
public class UserManage {
    @Autowired
    private UserService userService;

    public UserQueryResp queryUserList(UserQueryReq userQueryReq) {
        UserModel userModel = UserConvert.INSTANCE.userQueryDTO2Model(userQueryReq.getQuery());
        Page<UserModel> userDTOPage = userService.queryUserList(
                userModel,
                userQueryReq.getPageStart(),
                userQueryReq.getPageSize(),
                userQueryReq.getSortField(),
                userQueryReq.getOrderDir()
        );
        UserQueryResp userQueryResp = new UserQueryResp();
        userQueryResp.setTotal(userDTOPage.getTotal());
        userQueryResp.setPageSize(userDTOPage.getSize());
        userQueryResp.setPageNum(userDTOPage.getCurrent());
        userQueryResp.setList(UserConvert.INSTANCE.batchUserModel2DTO(userDTOPage.getRecords()));
        return userQueryResp;
    }
}

package it.pkg.basic.biz.manage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import it.pkg.basic.common.service.facade.request.UserQueryReq;
import it.pkg.basic.common.service.facade.response.UserQueryResp;
import it.pkg.basic.core.convert.user.UserConvert;
import it.pkg.basic.core.model.user.UserModel;
import it.pkg.basic.core.service.UserService;
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

package it.pkg.basic.core.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import it.pkg.basic.common.dal.entity.UserDO;
import it.pkg.basic.core.model.user.UserModel;

/**
 * @author cjunl
 */
public interface UserService extends IService<UserDO> {


    Page<UserModel> queryUserList(UserModel userModel, int pageStart, int pageSize, String sortField, String orderDir);
}

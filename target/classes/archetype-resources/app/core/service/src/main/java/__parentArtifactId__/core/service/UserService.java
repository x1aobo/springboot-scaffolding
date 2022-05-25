#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.core.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import ${package}.${parentArtifactId}.common.dal.entity.UserDO;
import ${package}.${parentArtifactId}.core.model.user.UserModel;

/**
 * @author cjunl
 */
public interface UserService extends IService<UserDO> {


    Page<UserModel> queryUserList(UserModel userModel, int pageStart, int pageSize, String sortField, String orderDir);
}

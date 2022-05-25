package it.pkg.basic.core.convert.user;

import it.pkg.basic.common.dal.entity.UserDO;
import it.pkg.basic.common.service.facade.dto.user.UserDTO;
import it.pkg.basic.common.service.facade.dto.user.UserQueryDTO;
import it.pkg.basic.core.model.user.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: cjunl
 * @Date: 2022/2/15 16:22
 */
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserModel userQueryDTO2Model(UserQueryDTO userQueryDTO);

    List<UserDTO> batchUserModel2DTO(List<UserModel> userModelList);

    UserModel userDo2Model(UserDO userDO);
}

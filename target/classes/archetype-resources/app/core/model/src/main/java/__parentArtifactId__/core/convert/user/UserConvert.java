#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.core.convert.user;

import ${package}.${parentArtifactId}.common.dal.entity.UserDO;
import ${package}.${parentArtifactId}.common.service.facade.dto.user.UserDTO;
import ${package}.${parentArtifactId}.common.service.facade.dto.user.UserQueryDTO;
import ${package}.${parentArtifactId}.core.model.user.UserModel;
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

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${package}.${parentArtifactId}.common.dal.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表 Mapper 接口
 *
 * @author cjunl
 */
@Mapper
public interface UserDao extends BaseMapper<UserDO> {
}

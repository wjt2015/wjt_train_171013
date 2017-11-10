package javaweb.mapper;

import javaweb.entity.RoleAuthorityEntity;

public interface RoleAuthorityEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleAuthorityEntity record);

    int insertSelective(RoleAuthorityEntity record);

    RoleAuthorityEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleAuthorityEntity record);

    int updateByPrimaryKey(RoleAuthorityEntity record);
}
package javaweb.mapper;

import javaweb.entity.RoleAuthorityEntity;

public interface RoleAuthorityMapper {
    int delete(Integer id);

    int save(RoleAuthorityEntity record);

    int save(RoleAuthorityEntity record);

    RoleAuthorityEntity query(Integer id);

    int update(RoleAuthorityEntity record);

    int update(RoleAuthorityEntity record);
}
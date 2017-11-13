package javaweb.mapper;

import javaweb.entity.RoleEntity;

public interface RoleMapper {
    int delete(Integer id);

    int save(RoleEntity record);

    int save(RoleEntity record);

    RoleEntity query(Integer id);

    int update(RoleEntity record);

    int update(RoleEntity record);
}
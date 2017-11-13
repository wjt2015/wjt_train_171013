package javaweb.mapper;

import javaweb.entity.AuthorityEntity;

public interface AuthorityMapper {
    int delete(Integer id);

    int save(AuthorityEntity record);

    int save(AuthorityEntity record);

    AuthorityEntity query(Integer id);

    int update(AuthorityEntity record);

    int update(AuthorityEntity record);
}
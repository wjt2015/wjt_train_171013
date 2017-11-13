package javaweb.mapper;

import javaweb.entity.AuthorityEntity;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthorityEntity record);

    int insertSelective(AuthorityEntity record);

    AuthorityEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthorityEntity record);

    int updateByPrimaryKey(AuthorityEntity record);
}
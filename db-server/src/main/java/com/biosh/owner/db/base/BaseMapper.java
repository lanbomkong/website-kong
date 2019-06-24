package com.biosh.owner.db.base;

/**
 * @description
 * @date 2019/6/20
 */
public interface BaseMapper<T extends BaseModel> {

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}

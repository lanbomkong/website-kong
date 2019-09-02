package com.biosh.owner.db.mapper;

import com.biosh.owner.db.base.BaseMapper;
import com.biosh.owner.db.model.BizMessage;

public interface BizMessageMapper extends BaseMapper<BizMessage> {
    int deleteByPrimaryKey(Integer id);

    int insert(BizMessage record);

    int insertSelective(BizMessage record);

    BizMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BizMessage record);

    int updateByPrimaryKey(BizMessage record);
}
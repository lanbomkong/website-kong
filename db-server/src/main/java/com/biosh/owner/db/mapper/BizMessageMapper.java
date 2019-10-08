package com.biosh.owner.db.mapper;

import com.biosh.owner.db.base.BaseMapper;
import com.biosh.owner.db.model.BizMessage;
import com.biosh.owner.db.util.Condition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizMessageMapper extends BaseMapper<BizMessage> {

    List<BizMessage> getRetryMessage();

    List<BizMessage> getByConditions(@Param("conditions") List<Condition> conditions);
}
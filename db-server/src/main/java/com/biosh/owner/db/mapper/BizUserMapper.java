package com.biosh.owner.db.mapper;


import com.biosh.owner.db.base.BaseMapper;
import com.biosh.owner.db.model.BizUser;
import com.biosh.owner.db.util.Condition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizUserMapper extends BaseMapper<BizUser> {

    List<BizUser> getByConditionList(@Param("conditions") List<Condition> conditions);
}
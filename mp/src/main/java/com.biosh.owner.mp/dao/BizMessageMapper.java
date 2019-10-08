package com.biosh.owner.mp.dao;

import com.biosh.owner.mp.model.BizMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author longlingbiao
 * @since 2019-07-16
 */
public interface BizMessageMapper extends BaseMapper<BizMessage> {

    int getCount();
}

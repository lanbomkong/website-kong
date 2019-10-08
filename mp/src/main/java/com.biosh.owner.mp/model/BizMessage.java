package com.biosh.owner.mp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author longlingbiao
 * @since 2019-07-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class BizMessage extends Model<BizMessage> {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private static final long serialVersionUID=1L;

    private String content;

    private Integer status;

    private Integer retryCount;

    private LocalDateTime retryTime;

    private LocalDateTime created;

    private LocalDateTime updated;

    private Integer deleted;


}

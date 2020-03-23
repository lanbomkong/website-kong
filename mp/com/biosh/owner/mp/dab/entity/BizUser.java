package com.biosh.owner.mp.dab.entity;

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
 * @since 2019-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class BizUser extends Model {

    private static final long serialVersionUID=1L;

    private String username;

    private String password;

    private String address;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer deleted;


}

package com.biosh.owner.mp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.util.Date;
import lombok.Data;

/**
 * @description
 * @date 2019/7/15
 */
@Data
public class BizUser {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * username
     */
    private String username;
    
    /**
     * email
     */
    private String email;
    
    /**
     * password
     */
    private String password;
    
    /**
     * address
     */
    private String address;

    private Date createAt;

    private Date updateAt;

    /**
     *  逻辑删除
     */
    @TableLogic
    private Byte deleted;
    

}

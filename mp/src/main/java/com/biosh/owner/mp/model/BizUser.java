package com.biosh.owner.mp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class BizUser {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String username;

  private String password;

  private String email;

  private String address;

  private Date createAt;

  private Date updateAt;

  private Byte deleted;
}

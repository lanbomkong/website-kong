package com.biosh.owner.web.dto.input;

import javax.validation.constraints.NotBlank;

/**
 * @description
 * @date 2019/6/20
 */
public class UserForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

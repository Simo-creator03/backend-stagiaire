package com.skysoft.easyschool.dto;

import java.util.List;

public class    AuthorityUserDTO {
    private String loginUser;
    private List<String> authorityOfUser;
    private List<String> authorityNotUser;

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public List<String> getAuthorityOfUser() {
        return authorityOfUser;
    }

    public void setAuthorityOfUser(List<String> authorityOfUser) {
        this.authorityOfUser = authorityOfUser;
    }

    public List<String> getAuthorityNotUser() {
        return authorityNotUser;
    }

    public void setAuthorityNotUser(List<String> authorityNotUser) {
        this.authorityNotUser = authorityNotUser;
    }
}

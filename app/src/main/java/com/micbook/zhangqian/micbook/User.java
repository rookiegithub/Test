package com.micbook.zhangqian.micbook;

import cn.bmob.v3.BmobObject;

public class User extends BmobObject {

    private String userName;
    //private String address;
    private String userPwd;

    public String getName() {
        return userName;
    }
    public void setName(String name) {
        this.userName = name;
    }
//    public String getAddress() {
//        return address;
//    }
//    public void setAddress(String address) {
//        this.address = address;
//    }
    public String getPassword() {
        return userPwd;
    }
    public void setPassword(String password) {
        this.userPwd = password;
    }
}

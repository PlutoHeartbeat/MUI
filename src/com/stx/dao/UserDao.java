package com.stx.dao;

import com.stx.pojo.UserTable;

public interface UserDao {
    UserTable selectBuUkeyAndPwd(String ukey,String pwd);

}

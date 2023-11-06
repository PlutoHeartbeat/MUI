package com.stx.service.impl;

import com.stx.dao.impl.UserDaoImpl;
import com.stx.pojo.UserTable;
import com.stx.service.UserService;

public class UserServiceImol implements UserService {
    @Override
    public UserTable login(String ukey, String pwd) {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.selectBuUkeyAndPwd(ukey,pwd);
    }
}

package com.stx.tst;
import com.stx.dao.impl.UserDaoImpl;
import com.stx.pojo.UserTable;
import com.stx.service.impl.UserServiceImol;
public class TestUser {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        UserTable userTable = userDao.selectBuUkeyAndPwd("xk", "123");
        UserServiceImol userService = new UserServiceImol();
        UserTable user = userService.login("xk","123");
        System.out.println(user);
    }
}

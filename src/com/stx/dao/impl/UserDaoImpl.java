package com.stx.dao.impl;
import com.stx.dao.UserDao;
import com.stx.pojo.UserTable;
import com.stx.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public UserTable selectBuUkeyAndPwd(String ukey, String pwd) {
        Connection connection = null;
        PreparedStatement ps = null;
        UserTable userTable = null;
        connection = JDBCUtils.getConnection();
        String sql = "select * from user_table where ukey=? and pwd=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,ukey);
            ps.setString(2,pwd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                userTable = new UserTable();
                userTable.setUserId(rs.getInt(1));
                userTable.setUkey(rs.getString(2));
                userTable.setPwd(rs.getString(3));
                userTable.setRealname(rs.getString(4));
                userTable.setUserType(rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null){
                    ps.close();
                }
                if(connection != null){
                    JDBCUtils.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userTable;
    }
}

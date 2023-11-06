package com.stx.util;

import java.sql.*;
public class JDBCUtils {
    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@Magicbook-14.mshome.net:1521:orcl", "scott", "tiger");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("找不到类");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("sql 异常");
        }
    }

    /**
     * 关闭资源
     * @param connection
     * @param statement
     * @param rs
     */
    public static void close(Connection connection, Statement statement, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行 新增，删除， 修改
     * @param sql
     * @return
     */
    public static int excuteUpdate(String sql) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            int rowNo = statement.executeUpdate(sql);
            return rowNo;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("sql 异常");
        } finally {
            close(connection, statement, null);
        }
    }
    public static void close() {
    }
}

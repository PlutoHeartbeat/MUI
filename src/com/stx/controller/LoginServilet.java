package com.stx.controller;

import com.stx.pojo.UserTable;
import com.stx.service.impl.UserServiceImol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServilet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();

        //1、接收参数
        String ukey = req.getParameter("username");
        String pwd = req.getParameter("password");
        String code = req.getParameter("code");

        //2、调用业务层
        //获取真正的验证码
        String realCode = (String) session.getAttribute("randStr");
        //判断验证码是否正确 正确，查询数据库 不正确，不查询数据库
        //验证码正确
        if (realCode.equals(code)) {
            UserServiceImol userService = new UserServiceImol();
            System.out.println(ukey+pwd+userService);
            UserTable user = userService.login(ukey, pwd);
            //账号密码正确
            if (user != null) {
                session.setAttribute("user", user);
                writer.print("success");
            }
            //账号密码不正确
            else {
                writer.print("error88888");
            }
        }
        //验证码不正确
        else {
            writer.print("error");
        }
    }
}

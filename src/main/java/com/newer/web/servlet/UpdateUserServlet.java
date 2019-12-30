package com.newer.web.servlet;

import com.google.gson.Gson;
import com.newer.domain.User;
import com.newer.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        UserService service = new UserService();

        String uname = request.getParameter("uname");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String s1 = request.getParameter("s1");
        String s2 = request.getParameter("s2");
        String s3 = request.getParameter("s3");
        String area = s1+s2+s3; //所在区域
        String address = request.getParameter("address"); //详细街道
        String coding = request.getParameter("coding"); //邮政编码
        String identity = request.getParameter("identity");  //身份证
        String phone = request.getParameter("phone");


        User user = new User();
        user.setUname(uname);
        user.setName(name);
        user.setSex(sex);
        user.setArea(area);
        user.setAddress(address);
        user.setCoding(coding);
        user.setIdentity(identity);
        user.setPhone(phone);

        System.out.println(user);

        int cont =  service.updateUser(user);

        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        out.print(cont);
        out.close();
    }
}

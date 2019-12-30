package com.newer.web.servlet;

import com.google.gson.Gson;
import com.newer.domain.User;
import com.newer.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        UserService service = new UserService();

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        int count = 0;
        if(password1.equals(password2)){
           count = service.updatePassword(user.getUname(),password1);
           out.print(count);
        }else{
            out.print("两次密码不一致");
        }
        out.close();
    }
}

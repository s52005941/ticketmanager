package com.newer.web.servlet;

import com.newer.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 进行邮箱激活
 */
@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取激活码
        String code = request.getParameter("code");
        if(code!=null){
            //2.调用Service完成激活
            UserService service = new UserService();
            boolean flag = service.active(code);

            //3.判断标记
            String msg  = null;
            if(flag){
                //激活成功
                request.getRequestDispatcher("denglu.html").forward(request,response);
            }else{
                //激活失败
                msg = "激活失败，请联系管理员！";
            }
            response.setContentType("text/html;charset=utf-8");
            if(msg!=null){
                response.getWriter().write(msg);
            }

        }
    }
}

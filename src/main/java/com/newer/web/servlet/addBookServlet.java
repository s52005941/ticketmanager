package com.newer.web.servlet;

import com.newer.domain.User;
import com.newer.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addBookServlet")
public class addBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        int tid =Integer.parseInt(request.getParameter("tid")) ;
        int num =Integer.parseInt(request.getParameter("num")) ;
        int total =Integer.parseInt(request.getParameter("total")) ;
        int cid =Integer.parseInt(request.getParameter("cid")) ;
        User user = (User)request.getSession().getAttribute("user");
        BookService service=new BookService();

        int i = service.addBook(tid, num, total, cid, user.getUid());
        System.out.println("i="+i);
        PrintWriter out = response.getWriter();
        out.print(i);
        out.close();


    }
}

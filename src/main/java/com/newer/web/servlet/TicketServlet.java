package com.newer.web.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newer.domain.Ticket;
import com.newer.service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    TicketService ticketService = new TicketService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("findTicketBycId".equals(action)){
            findTicketBycId(request, response);
        }if("findTicketBytId".equals(action)){
            findTicketBytId(request, response);
        }
    }

    private void findTicketBytId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int tid = Integer.parseInt(request.getParameter("tid"));
        System.out.println(tid);
        Ticket t = ticketService.findTicketBytId(tid);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(t));
        out.close();
    }

    private void findTicketBycId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Ticket> list = ticketService.findTicketByCid(cid);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(list));
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

package com.newer.web.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newer.domain.Concert;
import com.newer.service.ConcertService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/concerts")
public class ConcertServlet extends HttpServlet {
    ConcertService concertService = new ConcertService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("findConcertAll".equals(action)){
            findConcertAll(resp);
        }else if("findConcertBycId".equals(action)){
            findConcertBycId(req, resp);
        }
    }

    private void findConcertBycId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int cid = Integer.parseInt(req.getParameter("cid"));
        Concert concert = concertService.findConcertById(cid);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(concert));
        out.close();
    }

    private void findConcertAll(HttpServletResponse resp) throws IOException {
        List<Concert> list = concertService.findConcertAll();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(list));
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

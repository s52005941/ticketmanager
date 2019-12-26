package com.newer.web.servlet;

import com.google.gson.Gson;
import com.newer.domain.ResultInfo;
import com.newer.domain.User;
import com.newer.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registUserServlet")
public class RegistUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用service注册
        UserService service = new UserService();
        boolean flag =  service.regist(user);
        ResultInfo info = new ResultInfo();
        //4.响应结果
        if(flag){
            //成功
            info.setFlag(true);
        }else{
            //失败
            info.setFlag(false);
            info.setErrorMsg("注册失败!");
        }
        //将info序列化为json 写回客户端
        response.setContentType("application/json;charset=utf-8");
        Gson gson =  new Gson();
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(info));
        out.close();

    }
}

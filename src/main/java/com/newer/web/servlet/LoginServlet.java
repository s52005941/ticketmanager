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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 登录  进行判断是否激活
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        UserService service = new UserService();
        //1.获取用户名和密码
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
        //3.调用查询
        User u = service.login(user);
        ResultInfo info = new ResultInfo();
        HttpSession session = request.getSession();
        session.setAttribute("user",u);
        System.out.println("login:"+u);
        //4.判断用户对象是否为null
        if(u == null){
            //用户名或密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        //5.判断用户是否激活
        if(u != null && !"Y".equals(u.getStatus())){
            //用户未激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请登录邮箱进行激活");
        }
        //6.判断登陆成功
        if(u !=null && "Y".equals(u.getStatus())){
            info.setFlag(true);
        }

         //响应数据
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(info));
        out.close();

    }
}

package com.newer.web.servlet;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newer.util.SecurityCode;
import com.newer.util.SecurityImage;

@WebServlet("/codeimages")
public class ImageServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//生成随机验证码
		String code=SecurityCode.getSecurityCode();
		HttpSession session=req.getSession();
		//将验证码保存在服务端
		session.setAttribute("code", code);
		//设置响应对象属性
		resp.setContentType("image/jpeg");
		//设置浏览器不缓存图片数据
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		//设置响应内容立即失效
		resp.setDateHeader("Expires", 0);
		//使用服务器输出流输出生成的图片二进制流
		ImageIO.write(SecurityImage.getImage(code), "jpeg", resp.getOutputStream());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}

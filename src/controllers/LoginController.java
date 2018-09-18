package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.MockDao;

@WebServlet("/login.do")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pass =req.getParameter("pass");
		Map<String, String> m = new HashMap<>();
		m.put("id", id);
		m.put("pass",pass);
	
		MockDao mdao = new MockDao();
		int re = mdao.getlogin(m);
		
		
	}
	
	
}

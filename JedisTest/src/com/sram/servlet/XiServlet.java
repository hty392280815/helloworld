package com.sram.servlet;

import com.sram.beans.Xi;
import com.sram.dao.UserDao;
import com.sram.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/XiServlet")
public class XiServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDaoImpl();

        List<Xi> xis = userDao.getAllXi();

        request.setAttribute("xis",xis);
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/index03.jsp").forward(request,response);

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

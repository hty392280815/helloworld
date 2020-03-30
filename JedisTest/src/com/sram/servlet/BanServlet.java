package com.sram.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sram.beans.Ban;
import com.sram.dao.UserDao;
import com.sram.dao.impl.UserDaoImpl;
import com.sram.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/BanServlet")
public class BanServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xid = request.getParameter("xid");
        UserDao userDao = new UserDaoImpl();

        //先判断redis缓存中是否存在数据
        Jedis jedis = JedisPoolUtils.getJedis();//先通过工具类获取连接
        //通过jedis获取数据
        String bs = jedis.get("bans"+Integer.parseInt(xid));

        if(bs == null || bs.length() == 0){
            //说明缓存中没有，需要查询数据库
            System.out.println("说明缓存中没有，需要查询数据库");
            List<Ban> bans1 = userDao.getAllBansByXid(Integer.parseInt(xid));
            ObjectMapper mapper = new ObjectMapper();
            bs = mapper.writeValueAsString(bans1);

            //需要往缓存中存数据    bans1   bans2  bans3
            jedis.set("bans"+Integer.parseInt(xid),bs);
            jedis.close();

        }else{
            //缓存中有，直接获取
            System.out.println("缓存中有，直接获取");
        }

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(bs);
        out.flush();
        out.close();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

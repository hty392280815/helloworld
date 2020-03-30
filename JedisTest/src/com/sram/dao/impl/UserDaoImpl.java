package com.sram.dao.impl;

import com.sram.beans.Ban;
import com.sram.beans.Student;
import com.sram.beans.Xi;
import com.sram.dao.UserDao;
import com.sram.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<Xi> getAllXi() {
        String sql = "select * from t_xi";
        List<Xi> xis = new ArrayList<Xi>();
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet set = ps.executeQuery();
            while(set.next()){
                int xid = set.getInt("xid");
                String xname = set.getString("xname");
                Xi xi = new Xi(xid, xname);
                xis.add(xi);
            }
            return xis;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
        return null;
    }

    @Override
    public List<Ban> getAllBansByXid(int xid) {
        String sql = "select * from t_ban where xi_id = ?";

        List<Ban> bans = new ArrayList<Ban>();
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, xid);
            System.out.println(sql);
            ResultSet set = ps.executeQuery();
            while(set.next()){
                int bid = set.getInt("bid");
                String bname = set.getString("bname");
                Ban ban = new Ban(bid, bname);
                bans.add(ban);
            }
            return bans;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
        return null;
    }

    @Override
    public List<Student> getAllStusByBid(int bid) {
        String sql = "select * from t_student where ban_id = ?";
        List<Student> stus = new ArrayList<Student>();
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bid);
            System.out.println(sql);
            ResultSet set = ps.executeQuery();
            while(set.next()){
                int sid = set.getInt("sid");
                String sname = set.getString("sname");
                Student student = new Student(sid, sname);
                stus.add(student);
            }
            return stus;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
        return null;
    }
}

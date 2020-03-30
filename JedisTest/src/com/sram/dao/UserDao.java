package com.sram.dao;

import com.sram.beans.Ban;
import com.sram.beans.Student;
import com.sram.beans.Xi;

import java.util.List;

public interface UserDao {
    public abstract List<Xi> getAllXi();

    public abstract List<Ban> getAllBansByXid(int xid);

    public abstract List<Student> getAllStusByBid(int bid);

}

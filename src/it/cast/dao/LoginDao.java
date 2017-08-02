package it.cast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.cast.domain.User;
import it.cast.jdbcUtils.jdbcUtils;

public class LoginDao {

    public User login(User user) {
        String sql = "select * from login where name=? and pass=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

            con = jdbcUtils.getConnect();
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getPass());

            rs = pst.executeQuery();
            if (rs.next()) {// 说明用户名密码都对
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPass(rs.getString("pass"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                jdbcUtils.closeRs(rs);
                jdbcUtils.closeSt(pst);
                jdbcUtils.closeCon(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

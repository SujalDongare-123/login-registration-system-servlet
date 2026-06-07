package in.soft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.soft.entity.User;
import in.soft.factory.ConnectionFactory;

public class UserDaoImpl
        implements UserDao {

    Connection con =
            ConnectionFactory.getConnection();

    @Override
    public String register(User u) {

        String status = "fail";

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "INSERT INTO users VALUES(?,?,?,?)");

            ps.setInt(1, u.getId());
            ps.setString(2, u.getName());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());

            int count = ps.executeUpdate();

            if(count > 0) {
                status = "success";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public User login(
            String email,
            String password) {

        User u = null;

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "SELECT * FROM users WHERE email=? AND password=?");

            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                u = new User();

                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

    @Override
    public List<User> viewUsers() {

        List<User> list =
                new ArrayList<>();

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "SELECT * FROM users");

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                User u = new User();

                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));

                list.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public String updateUser(User u) {

        String status = "fail";

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "UPDATE users SET name=?,email=?,password=? WHERE id=?");

            ps.setString(1,u.getName());
            ps.setString(2,u.getEmail());
            ps.setString(3,u.getPassword());
            ps.setInt(4,u.getId());

            int count =
                    ps.executeUpdate();

            if(count > 0) {
                status = "success";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public String deleteUser(int id) {

        String status = "fail";

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "DELETE FROM users WHERE id=?");

            ps.setInt(1,id);

            int count =
                    ps.executeUpdate();

            if(count > 0) {
                status = "success";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
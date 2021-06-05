package com.example.lab10_JSP.model.user;

import com.example.lab10_JSP.DB;
import java.sql.*;

public class UserRepository implements IUserRepository{
    private Connection db;

    @Override
    public boolean exists(String login, String password) {
        Boolean res = null;
        try {
            Statement st = db.createStatement();

            ResultSet rs = st.executeQuery("use java10JDBC\n" +
                    "select * from UserLog where _username = '" + login +"' and _password = '" + password +"'");

            res = rs.next();
            st.close();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return res != null ? res.booleanValue() : false;
    }

    @Override
    public void addNew(String login, String password) {
        Boolean isExist = exists(login, password);

        try {
            Statement st = db.createStatement();
            //проверка наличия такого же пользователя
            if (!isExist)
                st.execute(
                "use java10JDBC\n" +
                     "insert into UserLog(_username, _password) values('" + login + "', '" + password + "')");
            st.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public UserRepository() {
        this.db = DB.getConnection();
    }
}

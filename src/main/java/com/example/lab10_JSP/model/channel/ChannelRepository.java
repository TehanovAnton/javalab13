package com.example.lab10_JSP.model.channel;

import com.example.lab10_JSP.DB;

import java.sql.*;

public class ChannelRepository implements IChannelRepository {
    private Connection db;

    @Override
    public boolean exists(String channel, String owner) {
        Boolean res = null;
        try {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(
                    "use java10JDBC\n" +
                         "select * from Channel where _channel = '" + channel +"' and _owner = '" + owner +"'");

            res = rs.next();
            st.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return res != null ? res.booleanValue() : false;
    }

    @Override
    public void addNew(String channel, String owner) {
        Boolean res = !exists(channel, owner);
        try {
            Statement st = db.createStatement();
            //проверка наличия такого же пользователя
            if (res) {
                st.execute("use java10JDBC\n" +
                        "insert into Channel(_channel, _owner) values('" + channel + "', '" + owner + "')");
            }
            st.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ChannelRepository() {
        this.db = DB.getConnection();
    }
}

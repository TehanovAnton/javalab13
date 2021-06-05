package com.example.lab10_JSP;

import com.example.lab10_JSP.model.channel.Channel;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class DB {
    public static String MS_DB_URL = "jdbc:sqlserver://localhost:1433";
    public static String MS_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String MS_PASSWORD = "ewqqwe";
    public static String MS_USER_NAME = "Anton";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DB.MS_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB.MS_DB_URL, DB.MS_USER_NAME, DB.MS_PASSWORD);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

    public static ArrayList<Channel> getChannels(PrintWriter pw){
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<Channel> channels = new ArrayList<Channel>();

        try {
            Class.forName(DB.MS_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB.MS_DB_URL, DB.MS_USER_NAME, DB.MS_PASSWORD);
            Statement st = conn.createStatement();

            rs = st.executeQuery("use java10JDBC\n" +
                    "select * from Channel");

            while (rs.next()){
                channels.add(
                        new Channel(rs.getString("_channel"), rs.getString("_owner")));
            }

            st.close();
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return channels;
    }
}

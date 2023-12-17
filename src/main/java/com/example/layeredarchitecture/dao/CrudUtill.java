package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtill {
    public PreparedStatement getPreparedStatement (String sql, Object...args) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i+1 , args[i]);
        }
        return pstm;
    }

    public boolean executeUpdate (String sql, Object...args) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = getPreparedStatement(sql, args);
        return pstm.executeUpdate()>0;
    }

    public ResultSet executeQuarry (String sql, Object...args) throws SQLException, ClassNotFoundException{
        PreparedStatement pstm = getPreparedStatement(sql, args);
        return pstm.executeQuery();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hiệu Bùi
 */
public class ViewDAO {
    public int getView() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        int count = 0;
        try {
            String query = "SELECT * FROM [View]";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
    public int updateView() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        int count = 0;
        try {
            String query = "UPDATE [View]\n"
                    + " SET number = number + 1";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            return count;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
    public int getGalleryView(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        int count = 0;
        try {
            String query = "SELECT [view_number] FROM [Gallery]\n"
                    + " WHERE [gallery_id]=?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
    public void updateGalleryView(int id) throws Exception {
         Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        try {
            String query = "UPDATE [Gallery]\n"
                    + " SET view_number = view_number + 1\n"
                    + " WHERE [gallery_id]=?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
     }
}

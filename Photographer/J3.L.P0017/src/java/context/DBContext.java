package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DBContext {

    private InitialContext initial;
    private Context context;
    private String dbname, serverName, portNumber, image, username, password,
            homePagingSize, galleryPagingSize;

    public DBContext() throws Exception {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            serverName = context.lookup("serverName").toString();
            dbname = context.lookup("dbName").toString();
            portNumber = context.lookup("portNumber").toString();
            image = context.lookup("image").toString();
            username = context.lookup("username").toString();
            password = context.lookup("password").toString();
            homePagingSize = context.lookup("homePagingSize").toString();
            galleryPagingSize = context.lookup("galleryPagingSize").toString();
        } catch (NamingException e) {
            throw e;
        }

    }
    

//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname +";integratedSecurity=true";
//        Connection conn = DriverManager.getConnection(url);
//        
//        return conn;
//    }
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://"
                + serverName + ":" + portNumber + ";databaseName=" + dbname + ";username=" + username + ";password=" + password);
        return conn;
    }

    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public String getImagePath() throws Exception {
        return image;
    }

    public int getGalleryPagingSize() throws Exception{
        int homeSize = 0;
        try {
            homeSize = Integer.parseInt(homePagingSize);
        } catch (NumberFormatException e) {
            throw e;
        }
        return homeSize;
    }

    public int getImagePagingSize() throws Exception{
        int gallerySize = 0;
        try {
            gallerySize = Integer.parseInt(galleryPagingSize);
        } catch (NumberFormatException e) {
            throw e;
        }
        return gallerySize;
    }

}

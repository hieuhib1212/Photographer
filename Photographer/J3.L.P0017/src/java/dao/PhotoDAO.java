/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Contact;
import entity.Gallery;
import entity.Images;
import entity.Share;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hiệu Bùi
 */
public class PhotoDAO {

    public PhotoDAO() {
    }

    //get 3 gallery
    public ArrayList<Gallery> getTop3Gallery() throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PhotoDAO dao = new PhotoDAO();
        ArrayList<Gallery> listGallery = new ArrayList<>();
        try {
            String query = "SELECT top(3) [gallery_id]\n"
                    + "      ,[title]\n"
                    + "      ,[description]\n"
                    + "  FROM [Gallery]";
            connection = db.getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setId(rs.getInt("gallery_id"));
                gallery.setTitle(rs.getString("title"));
                gallery.setDescription(rs.getString("description"));
                gallery.setImage(dao.getImageUrlByID(gallery.getId()));
                listGallery.add(gallery);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
        return listGallery;
    }

    //get Gallery bi GalleryID
    public Gallery getGalleryByID(int id) throws Exception {

        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PhotoDAO dao = new PhotoDAO();

        try {
            String query = "SELECT [gallery_id]\n"
                    + "      ,[title]\n"
                    + "      ,[description]\n"
                    + "      ,[view_number]\n"
                    + "  FROM [Gallery]\n"
                    + "  WHERE [gallery_id] =?";
            connection = db.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Gallery gallery = new Gallery();
            if (rs.next()) {
                gallery.setId(rs.getInt("gallery_id"));
                gallery.setTitle(rs.getString("title"));
                gallery.setDescription(rs.getString("description"));
                gallery.setImage(dao.getImageUrlByID(gallery.getId()));
                gallery.setView(rs.getInt("view_number"));
            }
            return gallery;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
    }

    public ArrayList<Share> getSharePanel() throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Share> shareList = new ArrayList<>();
        try {
            String query = "SELECT * FROM [ShareContent]";
             connection = db.getConnection();
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            
            while (rs.next()) {
            Share share = new Share();
                share.setTitle(rs.getString("title"));
                share.setIcon_source(rs.getString("icon"));
                share.setLink(rs.getString("link"));
                shareList.add(share);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
        return shareList;
    }
    //get Contact
    public Contact getContact() throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT [address]\n"
                    + "      ,[city]\n"
                    + "      ,[country]\n"
                    + "      ,[telephone]\n"
                    + "      ,[email]\n"
                    + "      ,[map]\n"
                    + "      ,[about]\n"
                    + "      ,[main_image]\n"
                    + "      ,[short_description]\n"
                    + "  FROM [Contact]";
            connection = db.getConnection();
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            Contact contact = new Contact();
            if (rs.next()) {
                contact.setAbout(rs.getString("about"));
                contact.setAddress(rs.getString("address"));
                contact.setCity(rs.getString("city"));
                contact.setCountry(rs.getString("country"));
                contact.setEmail(rs.getString("email"));
                contact.setMain_image(rs.getString("main_image"));
                contact.setMap_url(rs.getString("map"));
                contact.setTelephone(rs.getString("telephone"));
                contact.setShort_description(rs.getString("short_description"));
                return contact;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
        return null;
    }


    //get first imageURl to load on homepage
    public String getImageUrlByID(int id) throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT TOP (1) [id]\n"
                    + "      ,[gallery_id]\n"
                    + "      ,[image_url]\n"
                    + "  FROM [Images]\n"
                    + "  WHERE [gallery_id]=? ";

            connection = db.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("image_url");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, connection);

        }
        return null;

    }

    //get Image by imageID and GalleryID to load on Gallery Page
    public Images getImageByImageIDGalleryID(int id, int gid) throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[gallery_id]\n"
                    + "      ,[image_url]\n"
                    + "  FROM [Images]\n"
                    + "  WHERE [id]=? and [gallery_id]=?";

            connection = db.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, gid);
            rs = ps.executeQuery();
            Images img = new Images();
            if (rs.next()) {
                int imgId = Integer.parseInt(rs.getString("id"));
                img.setImg_id(imgId);
                img.setImg_url(rs.getString("image_url"));
                int gID = Integer.parseInt(rs.getString("gallery_id"));
                img.setGallery_id(gID);
            }
            return img;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
    }

    //get first id of image by galleryid 
    public int getTop1ImageIDByGalleryID(int id) throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT top (1) [id]\n"
                    + "      ,[gallery_id]\n"
                    + "      ,[image_url]\n"
                    + "  FROM [Images]\n"
                    + "  WHERE [gallery_id]=?";

            connection = db.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int iID = rs.getInt("id");
                return iID;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
        return 0;
    }

    //count number Gallery
    public int countGallery() throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) as numberGallery FROM Gallery";
            connection = db.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("numberGallery");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
        return count;
    }
    //Count number images by gallerID
    public int countImages(int gid) throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) as numberImages FROM [Images] WHERE [gallery_id]= ?";
            connection = db.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, gid);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("numberImages");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
        return count;
    }

    //get Gallery with paging to load on HomePage
    public ArrayList<Gallery> getGalleryWithPaging(int index) throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PhotoDAO dao = new PhotoDAO();
        ArrayList<Gallery> listGallery = new ArrayList<>();
        int galleryTo = index * db.getGalleryPagingSize();
        int galleryFrom = galleryTo - db.getGalleryPagingSize() + 1;
        try {
            String sql = "SELECT * FROM\n"
                    + "(SELECT ROW_NUMBER() OVER (ORDER BY [gallery_id] ASC) as rn,* from Gallery) AS rnNumber\n"
                    + "WHERE rn between ? and ?";
            connection = db.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, galleryFrom);
            ps.setInt(2, galleryTo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setId(rs.getInt("gallery_id"));
                gallery.setTitle(rs.getString("title"));
                gallery.setDescription(rs.getString("description"));
                gallery.setImage(rs.getString("main_image"));
                gallery.setView(rs.getInt("view_number"));
                listGallery.add(gallery);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
        return listGallery;
    }

    //get Image with paging to load on Gallery Page
    public ArrayList<Images> getImagesWithPaging(int gid, int index) throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Images> listImages = new ArrayList<>();

        int imageTo = index * db.getImagePagingSize();
        int imageFrom = imageTo - db.getImagePagingSize() + 1;
        try {
            String sql = "SELECT * FROM\n"
                    + "(SELECT ROW_NUMBER() OVER (ORDER BY [id] ASC) as rn,* from [Images]\n"
                    + "WHERE [gallery_id]= ?) AS rnNumber\n"
                    + "WHERE  rn between ? and ?";
            connection = db.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, gid);
            ps.setInt(2, imageFrom);
            ps.setInt(3, imageTo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Images img = new Images();
                int imgId = Integer.parseInt(rs.getString("id"));
                img.setImg_id(imgId);
                img.setImg_url(rs.getString("image_url"));
                int gID = Integer.parseInt(rs.getString("gallery_id"));
                img.setGallery_id(gID);
                listImages.add(img);
            }

        } catch (ClassNotFoundException | NumberFormatException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
        return listImages;
    }

    //get maxGalleryID of Gallery --> compare to catch error
    public int getMaxGalleryID() throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String sql = "SELECT Max([gallery_id]) AS maxGalleryID\n"
                    + "  FROM [Gallery]";
            connection = db.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("maxGalleryID");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
        return count;
    }

    //get maxImageID of Image with GalleryID --> compare to catch error
    public int getMaxImageID(int gid) throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String sql = "SELECT Max([id]) AS maxImageID\n"
                    + "  FROM [Images]\n"
                    + "  WHERE [gallery_id]=?";
            connection = db.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, gid);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("maxImageID");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, connection);
        }
        return count;
    }

}

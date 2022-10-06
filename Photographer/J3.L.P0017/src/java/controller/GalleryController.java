/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import context.DBContext;
import dao.PhotoDAO;
import dao.ViewDAO;
import entity.Contact;
import entity.Gallery;
import entity.Images;
import entity.Share;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hiệu Bùi
 */
public class GalleryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PhotoDAO dao = new PhotoDAO();
            DBContext db = new DBContext();

            //get imagePath
            String imagePath = db.getImagePath();
            request.setAttribute("imagePath", imagePath);

            //get GalleryID 
            String gid = request.getParameter("gid");
            int galleryID = 0;
            try {
                galleryID = Integer.parseInt(gid);
                //check range of galleyID 
                if (galleryID < 1 || galleryID > dao.getMaxGalleryID()) {
                    request.setAttribute("error1", "Cann't found gallery because this galleryID is out of range of galleryID");
                }
            } catch (Exception e) {
                request.setAttribute("error1", "Invalid gallery id");
            }
            request.setAttribute("gid", galleryID);
            
            //get imageID
            String iID = request.getParameter("imageID");
            int imgID = 0;
            //initially load first image by galleryID
            if (iID == null) {
                imgID = dao.getTop1ImageIDByGalleryID(galleryID);
            } else {
                try {
                    imgID = Integer.parseInt(iID);
                    //check range of imageID 
                    if (imgID < 1 || imgID > dao.getMaxImageID(galleryID)) {
                        request.setAttribute("error", "Cann't found image with this imageID");
                    }
                } catch (Exception e) {
                    request.setAttribute("error", "Invalid image id");
                }
            }
            //get image by imageID and galleryID
            Images image = dao.getImageByImageIDGalleryID(imgID, galleryID);
            request.setAttribute("image", image);

            //get contact
            Contact contact = dao.getContact();
            request.setAttribute("contact", contact);
            
            //get share panel
            ArrayList<Share> sharePanel = dao.getSharePanel();
            request.setAttribute("share", sharePanel);
            //get top3 Gallery to display on navbar
            ArrayList<Gallery> top3Gallery = dao.getTop3Gallery();
            request.setAttribute("top3", top3Gallery);

            //count total number image by galleryID
            int count = dao.countImages(galleryID);
            if (count <= 0) {
                request.setAttribute("error", "Can't found Images in this Gallery");
            }
            //get pageSize of GalleryPage
            int pageSize = db.getImagePagingSize();
            int endPage = count / pageSize;
            if (count % pageSize != 0) {
                endPage++;
            }
            request.setAttribute("endPage", endPage);

            //get index from Gallery.jsp
            String indexx = request.getParameter("index");
            int index = 0;
            if (indexx == null) {
                index = 1;
            } else {
                try {
                    index = Integer.parseInt(indexx);
                    //check range of index in [1;endPage] or not
                    if (index > endPage || index < 1) {
                        request.setAttribute("error", "Invalid range of index on paging");
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "Invalid index");
                }
            }

            request.setAttribute("index", index);

            //get and update view 
            ViewDAO vDao = new ViewDAO();
            HttpSession session = request.getSession();
            
            if (session.getAttribute("gallery" + gid) == null) {
                vDao.updateGalleryView(galleryID);
            }
            if (session.isNew()) {
                vDao.updateView();
            }
            session.setAttribute("gallery" + gid, gid);
            //getGallery by galleryID --> get Name of Gallery
            Gallery gallery = dao.getGalleryByID(galleryID);
            request.setAttribute("gallery", gallery);
            //set view format to jsp
            int view = vDao.getView();
            request.setAttribute("galleryView", view);
            String formatted = String.format("%06d", view);
            ArrayList<String> number = new ArrayList<>();
            Collections.addAll(number, formatted.split(""));
            Collections.reverse(number);
            session.setAttribute("view", number);
            //get list image with paging
            ArrayList<Images> lstImage = dao.getImagesWithPaging(galleryID, index);
            request.setAttribute("lstImage", lstImage);
            
            //set value for active
            request.setAttribute("active", galleryID);
            
            request.getRequestDispatcher("Gallery.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

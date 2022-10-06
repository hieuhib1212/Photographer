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
public class HomeController extends HttpServlet {

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

            //get top3 Gallery
            ArrayList<Gallery> top3Gallery = dao.getTop3Gallery();
            request.setAttribute("top3", top3Gallery);

            //get share panel
            ArrayList<Share> sharePanel = dao.getSharePanel();
            request.setAttribute("share", sharePanel);
            //get Contact
            Contact contact = dao.getContact();
            request.setAttribute("contact", contact);

            //count total number Gallery 
            int count = dao.countGallery();
            if (count <= 0) {
                request.setAttribute("error", "Can't found Gallery");
            }
            //getPageSize of HomePage
            int pageSize = db.getGalleryPagingSize();

            //count total Page
            int endPage = count / pageSize;
            if (count % pageSize != 0) {
                endPage++;
            }
            request.setAttribute("endPage", endPage);

            //get index from HomePage.jsp
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

            //get list Gallery by paging
            ArrayList<Gallery> listGallery = dao.getGalleryWithPaging(index);
            request.setAttribute("listGallery", listGallery);
            //get view 
            ViewDAO vDao = new ViewDAO();
            HttpSession session = request.getSession();
            if (session.isNew()) {
                vDao.updateView();
            }

            int view = vDao.getView();
            String formatted = String.format("%06d", view);
            ArrayList<String> number = new ArrayList<>();
            Collections.addAll(number, formatted.split(""));
            Collections.reverse(number);
            session.setAttribute("view", number);
            //set default value for active to display on nav bar
            request.setAttribute("active", "0");
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
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

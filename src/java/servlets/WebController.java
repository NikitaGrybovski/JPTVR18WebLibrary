/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacade;
import session.HistoryFacade;
import session.ReaderFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "WebController", urlPatterns = {
    "/createBook",
    "/showbook",
    "/createReader",
    "/showReader",
    "/giveBook",
})
public class WebController extends HttpServlet {
    @EJB private BookFacade bookFacade;
    @EJB private ReaderFacade readerFacade;
    @EJB private HistoryFacade historyFacade;
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
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
            case "/createBook":
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                String publishedYear = request.getParameter("publishedYear");
                String isbn = request.getParameter("isbn");
                
                if(name != null && author != null && publishedYear != null && isbn != null){
                    Book book = new Book (name, author, Integer.parseInt(publishedYear), isbn);
                    bookFacade.create(book);
                    
                    
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                
                
                break;
            case "/showbook":
                List<Book> listBooks = bookFacade.findAll();
                request.setAttribute("listbooks", listBooks);
                request.getRequestDispatcher("/showbook.jsp").forward(request, response);
                break;
            case "/createReader":
                String nameofReader = request.getParameter("nameofReader");
                String surname = request.getParameter("surname");
                String day = request.getParameter("day");
                String month = request.getParameter("month");
                String year = request.getParameter("year");
                String phone = request.getParameter("phone");
                
                if(nameofReader != null && surname != null && day != null && month != null && year != null && phone != null){
                    Reader reader = new Reader (nameofReader, surname, Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year),phone);
                    
                    readerFacade.create(reader);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    
                    
                
                }
                break;
            case "/showReader":
                List<Reader> listReaders = readerFacade.findAll();
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/showReader.jsp").forward(request, response);
                break;
            
            case "/giveBook":
                List<Reader> listR = readerFacade.findAll();
                List<Book> listB = bookFacade.findAll();
                request.setAttribute("listBook", listB);
                request.setAttribute("listReader", listR);
                request.getRequestDispatcher("/giveBook.jsp").forward(request, response);
                Book book = new Book();
                Reader reader = new Reader();
                
                History history = new History (new Date(), null, book, reader);
                request.getRequestDispatcher("/giveBook.jsp").forward(request, response);
                
                break;
               
                
                
            
            
            
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

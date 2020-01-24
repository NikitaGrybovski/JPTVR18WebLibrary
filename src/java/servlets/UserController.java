/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.BookFacade;
import session.HistoryFacade;
import session.ReaderFacade;
import session.UserFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "UserController", urlPatterns = {
    "/createBook",
    "/showbook",
    
    "/showReader",
    "/showGiveBook",
    "/createHistory",
    "/returnBookShow",
    "/createReturnBook",
})
public class UserController extends HttpServlet {
    @EJB private BookFacade bookFacade;
    @EJB private ReaderFacade readerFacade;
    @EJB private HistoryFacade historyFacade;
    @EJB private UserFacade userFacade;
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
        HttpSession session = request.getSession(false);
        if(session == null){
            
        }
        User user = null;
        user = (User) session.getAttribute("user");
        if( user == null){
            request.setAttribute("info", "У вас нету прав, авторизуйтесь");
            request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
        
        }
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
            
            case "/showReader":
                List<Reader> listReaders = readerFacade.findAll();
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/showReader.jsp").forward(request, response);
                break;
            
            case "/showGiveBook":
                List<Book> books = bookFacade.findAll();
                List<Reader> readers = readerFacade.findAll();
                request.setAttribute("listBooks", books);
                request.setAttribute("listReaders", readers);
                request.getRequestDispatcher("/showGiveBook.jsp").forward(request, response);
              
                
                
                
                
                break;
            case "/createHistory":
                String chooseBook = request.getParameter("chooseBook");
                String chooseReader = request.getParameter("chooseReader");
        
                Book bookid = bookFacade.find(Long.parseLong(chooseBook));
                Reader readerid = readerFacade.find(Long.parseLong(chooseReader));
                History history = new History(new Date(),null,bookid,readerid);
                historyFacade.create(history);
                
                
                request.setAttribute("info","Выдана книга " + history.toString());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
                
                
                
                
                
                break;
                
            case "/returnBookShow":
                List<History> listHistory = historyFacade.findAll();
                
                
                request.setAttribute("listHistory", listHistory);
                
                
                
                
                request.getRequestDispatcher("/returnBookShow.jsp").forward(request, response);
                break;
            case "/createReturnBook":
                String chooseHistory = request.getParameter("chooseHistory");
                
                History historyid = historyFacade.find(Long.parseLong(chooseHistory));
                historyid.setReturnOfDate(new Date());
                historyFacade.edit(historyid);
                request.setAttribute("info","Книгу вернули ");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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

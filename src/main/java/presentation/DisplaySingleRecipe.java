/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.RecipesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.Recipe;

/**
 *
 * @author jonab
 */
@WebServlet(name = "DisplaySingleRecipe", urlPatterns = {"/DisplaySingleRecipe"})
public class DisplaySingleRecipe extends HttpServlet {
    RecipesDAO hej;
    Recipe recipe;
    public DisplaySingleRecipe(){
//        this.hej = new RecipesDAO();
//        this.recipe = hej.displaySingleRecipe1();
    }
    
    

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
            throws ServletException, IOException{
        this.hej = new RecipesDAO();
        this.recipe = hej.displaySingleRecipe1();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplaySingleRecipe</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + recipe.getRecipeName() + "</h1>");
            out.println("<h1>" + recipe.getInstructions() + "</h1>");
            out.println("<h1>" + recipe.getRating() + "</h1>");
            for (int i = 0; i < recipe.getIngredients().size(); i++) {
                out.println("<h1>" + recipe.getIngredients().get(i) + "</h1>");
            }
            out.println("<img src=" + recipe.getImgURL() + ">");
            

            out.println("</body>");
            out.println("</html>");
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

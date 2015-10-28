package controlador;

import modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorValida extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String user = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        
        ArrayList errores = new ArrayList();
        if (user.isEmpty()){
            errores.add("falta ingresar el usuario");
        }
        if (pass.isEmpty()){
            errores.add("falta ingresar la contraseña");
        }
        if (errores.isEmpty()){
            Usuario objeto = new Usuario(user, pass);
         Usuario objeto2 =(Usuario) getServletContext().getAttribute("user");
         if(objeto.getUser().equals(objeto2.getUser()) && objeto.getPass().equals(objeto2.getPass())){
              RequestDispatcher vistas = request.getRequestDispatcher("reclamos.view");
            vistas.forward(request, response);
         }else{
             errores.add("el usuario no valido");
                     
         }
            
        }
            request.setAttribute("errores", errores);
            RequestDispatcher vistas = request.getRequestDispatcher("validar.view");
            vistas.forward(request, response);
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

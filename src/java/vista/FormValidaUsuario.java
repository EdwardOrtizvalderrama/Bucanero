package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormValidaUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           ArrayList errores= (ArrayList) request.getAttribute("errores");
           
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormValidarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<form action='controladorvalida.do' method='post'>");
            out.println("<table>");
            out.println("<tr><td colspan='2' align='center'>Usuario</td></tr>");
            
            /*Configurar Usuario*/
            out.println("<tr>");
            out.println("<td>Usuario</td>");
            out.println("<td><input type='text' name='usuario'/></td>");
            out.println("</tr>");
            
            /*Digita Contraseña*/
            out.println("<tr>");
            out.println("<td>Contraseña</td>");
            out.println("<td><input type='password' name='pass'/></td>");
            out.println("</tr>");
            
            /*Construye el boton Entrar*/
            out.println("<tr>");
            out.println("<td colspan='2' align='right'><input type='submit' name='bt' value='entrar'/></td> ");
            out.println("</tr>");
            
            out.println("</table>");
            out.println("</form>");
            if(errores != null){
                for (int i=0; i<errores.size(); i++){
                    out.println(errores.get(i)+"<br>");
                }
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
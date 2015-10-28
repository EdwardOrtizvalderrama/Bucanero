package vista;

import modelo.Reclamo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LDS
 */
public class VerReclamos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
           try{
               ArrayList listaReclamos = (ArrayList) getServletContext().getAttribute("listaReclamos");
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerReclamos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
           
           out.println("<table border='1' width='500'>");
           out.println("<tr>");
             out.println("<td colspan='4' align='center'>PEDIDOS</td");
             
             out.println("</tr>");
           out.println("<tr>");
               out.println("<td>NOMBRE</td>");
                 out.println("<td>TELEFONO</td>");
                 out.println("<td>TIPO</td>");
                 out.println("<td>PEDIDO</td>");
                 out.println("</tr>");
                 
                 for(int i = 0; i< listaReclamos.size();i++){
                     Reclamo r = (Reclamo)listaReclamos.get(i);
                     
             out.println("</tr>");
               out.println("<td>"+r.getNombre()+"</td>");
                 out.println("<td>"+r.getTelefono()+"</td>");
                 out.println("<td>"+r.getTipo()+"</td>");
                 out.println("<td>"+r.getTexto()+"</td>");
                 out.println("</tr>");
                 }
                 
                 
                 
               out.println("</table>");
               out.println("</center>");
               out.println("</body>");
            out.println("</html>");
        }finally{
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

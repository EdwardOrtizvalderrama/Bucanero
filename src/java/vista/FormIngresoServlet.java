package vista;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Reclamo;

public class FormIngresoServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try  {
     
            ArrayList errores = (ArrayList) request.getAttribute("errores");
            Reclamo rec = (Reclamo) request.getAttribute("objetoReclamo");
            
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Servlet FormIngresoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
             
            out.println("<center>");
            out.println("<form action='controladoringreso.do' method='post'>");
            out.println("<table>");
            
            /*Titulo */
            out.println("<tr><td colspan='2' align='center'>Ingreso</td></tr>");

             /*Fila para el nombre */
            out.println("<tr>");
            out.println("<td>Nombre</td>");
            out.println("<td><input type='text' name='nombre'/></td>");
            out.println("</tr>"); 
            
             /*Telefono */
            out.println("<tr>");
            out.println("<td>Telefono o Celular</td>");
            out.println("<td><input type='text' name='telefono'/></td>");
            out.println("</tr>");
            
            /*Tipo de Reclamo */
            out.println("<tr>");
            out.println("<td>Tipo</td>");
            out.println("<td><select name='tipo'>");
            out.println("<option value='0'> elija tipo"); 
            out.println("<option> atencion cliente"); 
            out.println("</select>");
            out.println("</td></tr");
            
            /** area de texto para escribir el reclamo*/
            out.println("<tr>");
            out.println("<td>Dijite Tu Pedido</td>");
            out.println("<td><textarea name='texto'></textarea></td>");
            out.println("</tr>"); 
            
            /*Boton de enviar los elementos*/
            out.println("<tr>");
            out.println("<td colspan='2' align='>right'><input type='submit' name='bt' value='enviar'></td> ");
            out.println("</tr>"); 
            
            
            out.println("</table>");
            out.println("</form>");
            //escribir los mensajes de ok o error
            if (errores != null){
                for(int i=0; i < errores.size(); i++){
                    out.println(errores.get(i) +"<br>");
                }
            }
           if (rec != null){
             out.println("Sr(a) "+rec.getNombre()+" su pedido fue ingresado Correctamente.");
            
            
           }
            out.println("</Center>");
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

package controlador;


import modelo.Reclamo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorIngreso extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       String nombre = request.getParameter("nombre");
       String stelefono = request.getParameter("telefono");
       String tipo = request.getParameter("tipo");
       String texto = request.getParameter("texto");
       
       ArrayList errores = new ArrayList();
       
       if (nombre.isEmpty()){
           errores.add("Falta Ingresar el nombre");
       }
       if (tipo.equals("0")){
           errores.add("Falta selecional el tipo de Pedido");
       }
           if (texto.isEmpty()){
           errores.add("Falta escribir el Pedido");
           
           }
           int telefono = 0  ;
           try{
               telefono = Integer.parseInt(stelefono);
               if (stelefono.length() !=8 ){
               
                   errores.add("El telefono debe ser de 8 digitos");
              
               }
       }catch(NumberFormatException ex){
           errores.add("El telefono debe ser numerico");
       
       }
       
       if(errores.isEmpty()){
           //no hay errores
           Reclamo objetoReclamo = new Reclamo(nombre, telefono, tipo, texto);
           request.setAttribute("objetoReclamo", objetoReclamo);
           //ambito de contexto
           ArrayList listaReclamos= (ArrayList) getServletContext().getAttribute("listaReclamos");
           listaReclamos.add(objetoReclamo);
           getServletContext().setAttribute("listaReclamos", listaReclamos);
           //Redireccion 
           RequestDispatcher vista = request.getRequestDispatcher("ingresar.view");
    vista.forward(request, response);
       }else{
           //hay errores
           request.setAttribute("errores", errores);
           //redireccion
            RequestDispatcher vista = request.getRequestDispatcher("ingresar.view");
    vista.forward(request, response);
    
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

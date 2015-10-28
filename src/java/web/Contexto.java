package web;

import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import modelo.Usuario;
import javax.servlet.ServletContext;
public class Contexto implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce) {
      ArrayList listaReclamos = new ArrayList();
      Usuario user= new Usuario("admin","adminadmin");
      
      ServletContext contex = sce.getServletContext();
      contex.setAttribute("listaReclamos", listaReclamos);
        contex.setAttribute("user", user);
        
    }


    public void contextDestroyed(ServletContextEvent sce) {
     
    }
}

package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cabeceros")
public class Cabecero extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //obtenemos el metodo que esta realizando la peticion
        String metodoHTTP= req.getMethod();
        //Obtenemos la Uri contextPath+ServletPath
        String RequestUri= req.getRequestURI();
        //obtenemos la URL completa
        String requestURL = req.getRequestURL().toString();
        //obtenemos el nombre del proyecto
        String contextPath = req.getContextPath();
        //obtenemos el path de servlet
        String servletPath = req.getServletPath();
        // actividad
        //obtener el puerto por donde esta ejecutando al aplicacion
        int localPort = req.getLocalPort();
        //Obtener la Ip de donde se esta ejecutando la app
        String ip = req.getRemoteAddr();
        //Obtener el esquema
        String scheme = req.getScheme();
        //url 1
        String url1 = scheme+"://"+localPort+contextPath+servletPath;
        //url2 irl2 = Schema+ip+port+contextPath+servletPath
        String url2 = scheme + "://" + ip + ":" + localPort + contextPath + servletPath;
        //server name
        String host =req.getServerName();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>CABECEROS</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Peticiones HTTP REQUEST</h1>");
        out.println("<ul>");
        out.println("<li>   Metodo: "+metodoHTTP+"</li>");
        out.println("<li>   Uri: "+RequestUri+"</li>");
        out.println("<li>   URL: "+requestURL+"</li>");
        out.println("<li>   contextPath: "+contextPath+"</li>");
        out.println("<li>   servletPath: "+servletPath+"</li>");
        // actividad

        out.println("<li>   localPort: "+localPort+"</li>");
        out.println("<li>   ip: "+ip+"</li>");
        out.println("<li>   scheme: "+scheme+"</li>");
        out.println("<li>   Url1: "+url1+"</li>");
        out.println("<li>   url2: "+url2+"</li>");
        out.println("<li>   getServerName: "+host+"</li>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}

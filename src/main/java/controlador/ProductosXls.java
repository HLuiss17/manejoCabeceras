package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Producto;
import modelo.ProductoServiceImplement;
import services.ProductoService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls", "/productos.json", "/productohtml"})
public class ProductosXls extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        ProductoService service = new ProductoServiceImplement();
        List<Producto> productos = service.listar();

        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        boolean esJson = servletPath.endsWith(".json");

        if (esXls) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment; filename=productos.xls");
        } else if (esJson) {
            resp.setContentType("application/json;charset=UTF-8");
            resp.setHeader("Content-Disposition", "attachment; filename=productos.json");
        }

        try (PrintWriter out = resp.getWriter()) {
            if (esJson) {
                // Generación del JSON
                StringBuilder json = new StringBuilder();
                json.append("["); // Inicia el arreglo JSON

                for (int i = 0; i < productos.size(); i++) {
                    Producto p = productos.get(i);
                    json.append("{");
                    json.append("\"idProducto\":").append(p.getIdProducto()).append(",");
                    json.append("\"nombreProducto\":\"").append(p.getNombreProducto()).append("\",");
                    json.append("\"categoriaProducto\":\"").append(p.getCategoriaProducto()).append("\",");
                    json.append("\"precioProducto\":").append(p.getPrecioProducto());
                    json.append("}\n");

                    if (i < productos.size() - 1) {
                        json.append(",");
                    }
                }
                json.append("]");
                // Enviar el JSON como respuesta
                out.println(json.toString());
            } else if (!esXls) {
                // Generación de la tabla HTML
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Listado de Productos</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Listado Productos</h1>");
                out.println("<p><a href=\"" + req.getContextPath() + "/productos.xls" + "\">Descargar xls</a></p>");
                out.println("<p><a href=\"" + req.getContextPath() + "/productos.json" + "\">Descargar JSON</a></p>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>ID PRODUCTO</th>");
                out.println("<th>NOMBRE</th>");
                out.println("<th>CATEGORIA</th>");
                out.println("<th>PRECIO</th>");
                out.println("</tr>");

                productos.forEach(p -> {
                    out.println("<tr>");
                    out.println("<td>" + p.getIdProducto() + "</td>");
                    out.println("<td>" + p.getNombreProducto() + "</td>");
                    out.println("<td>" + p.getCategoriaProducto() + "</td>");
                    out.println("<td>" + p.getPrecioProducto() + "</td>");
                    out.println("</tr>");
                });
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}

package services;

import modelo.Producto;

import java.util.List;

public interface ProductoService {
    // la interfaz genera una plantilla o implentar metodos por fuera de esta clase
    //implentamos un metodo para listar los productos
    List<Producto> listar();
}

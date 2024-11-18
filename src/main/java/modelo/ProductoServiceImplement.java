package modelo;

import services.ProductoService;


import java.util.List;
import java.util.Arrays;

public class ProductoServiceImplement implements ProductoService {
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L,"TECLADO","TECNOLOGIA",12),
                new Producto(2L,"COCINA","HOGAR",12),
                new Producto(3L,"LLANTAS","VEHICULOS",12)
                );

    }
}

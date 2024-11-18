package modelo;

public class Producto {
    //declaramos las variables de los productos
    private long idProducto;
    private String NombreProducto;
    private String categoriaProducto;
    private double precioProducto;
    //implemtamos los contrctores

    public Producto() {
    }

    public Producto(long idProducto, String NombreProducto, String categoriaProducto, double precioProducto) {
        this.idProducto = idProducto;
        this.NombreProducto = NombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.precioProducto = precioProducto;
    }

    //implentamos los metodos get implemtar y set (Modificar)

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}

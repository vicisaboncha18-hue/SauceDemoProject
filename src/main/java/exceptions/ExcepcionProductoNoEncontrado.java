package exceptions;

public class ExcepcionProductoNoEncontrado extends AssertionError {
    public ExcepcionProductoNoEncontrado(String nombreProducto) {
        super("ERROR: No se encontró el producto: "+nombreProducto);
    }
}

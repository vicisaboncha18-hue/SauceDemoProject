package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {
    private String nombreProducto;

    public ProductsPage(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public static Target getProducto(String nombreProducto){
        return Target.the("Label con el nombre del producto seleccionado")
                .locatedBy("//div[contains(text(),'"+nombreProducto+"')]");
    }
    public static Target BUTTON_ADDTOCART =Target.the("Boton para agregar el producto al carrito")
            .locatedBy("//button[@name='add-to-cart']");
    public static Target BUTTON_BACKTOPRODUCTS =Target.the("Boton para regresar a la pagina de productos")
            .locatedBy("//button[@id='back-to-products']");
    public static Target BUTTON_CARRITO=Target.the("Boton que lleva a la pagina del carrito")
            .locatedBy("//a[@class='shopping_cart_link']");
    public static Target BUTTON_CONTINUESHOPING=Target.the("Boton para continuar comprando")
            .locatedBy("//button[@id='continue-shopping']");
    public static Target BUTTON_REMOVE=Target.the("Boton para eliminar el producto del carrito")
            .locatedBy("//button[@name='remove']");
}

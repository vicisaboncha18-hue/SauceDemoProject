package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.ProductsPage;

public class RespuestaValidacionDelCarrito implements Question<Boolean> {
    private final String nombreProducto;
    private Boolean AgregadoAlCarrito;

    public RespuestaValidacionDelCarrito(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public static RespuestaValidacionDelCarrito delProducto(String nombreProducto){
        return new RespuestaValidacionDelCarrito(nombreProducto);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.BUTTON_CARRITO.resolveFor(actor))
        );
        AgregadoAlCarrito=nombreProducto.equals(ProductsPage.getProducto(nombreProducto).resolveFor(actor).getText());
        actor.attemptsTo(
                Click.on(ProductsPage.BUTTON_CONTINUESHOPING.resolveFor(actor))
        );
        return AgregadoAlCarrito;
    }
}

package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterface.CheckoutPage;

public class RespuestaConfirmacionCeckout implements Question<Boolean> {
    private final String mensaje;

    public RespuestaConfirmacionCeckout(String mensaje) {
        this.mensaje = mensaje;
    }
    public static Question<Boolean> ConMensaje(String mensaje){
        return new RespuestaConfirmacionCeckout(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return mensaje.equals(CheckoutPage.LABEL_CONFIRMACIONCOMPRA.resolveFor(actor).getText());
    }
}

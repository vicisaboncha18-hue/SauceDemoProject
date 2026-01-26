package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterface.LoginPage;

public class RespuestaConfirmacionLogin implements Question<Boolean> {
    private final String mensaje;
    public RespuestaConfirmacionLogin(String mensaje) {
        this.mensaje=mensaje;
    }

    public static Question<Boolean> delMensaje(String mensaje){
        return new RespuestaConfirmacionLogin(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
            return mensaje.equals(LoginPage.LABEL_PRODUCTS.resolveFor(actor).getText());
    }
}

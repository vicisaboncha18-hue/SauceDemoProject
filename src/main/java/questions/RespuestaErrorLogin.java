package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterface.LoginPage;

public class RespuestaErrorLogin implements Question<Boolean> {
    private String mensajeError;

    public RespuestaErrorLogin(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    public static Question<Boolean> delMensaje(String mensajeError){
        return new RespuestaErrorLogin(mensajeError);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return mensajeError.equals(LoginPage.ERROR_LOGIN.resolveFor(actor).getText());
    }
}

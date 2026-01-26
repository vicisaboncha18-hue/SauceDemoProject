package userinterface;


import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    private LoginPage() {
    }
    public static final Target INPUT_USERNAME = Target.the("Input para ingresar el username")
            .locatedBy("//input[@id='user-name']");
    public static final Target INPUT_PASSWORD = Target.the("Input para ingresar la contraseña")
            .locatedBy("//input[@id='password']");
    public static final Target LOGIN_BTN =Target.the("Boton para iniciar Sesion")
            .locatedBy("//input[@id='login-button']");
    public static final Target LABEL_PRODUCTS= Target.the("Label para identificar productos")
            .locatedBy("//span[@class='title']");
    public static final Target ERROR_LOGIN= Target.the("Mensaje de error al iniciar sesion")
            .locatedBy("//h3[contains(text(), 'Epic sadface')]");
}

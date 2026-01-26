package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {
    public CheckoutPage(){

    }
    public static Target BUTTON_GOTOCHECKOUT =Target.the("Boton para ir al checkout")
            .locatedBy("//button[@id='checkout']");
    public static Target LABEL_FIRSTNAME = Target.the("Label para ingresar primer nombre")
            .locatedBy("//input[@id='first-name']");
    public static Target LABEL_LASTNAME =Target.the("Label para ingresar Apellidos")
            .locatedBy("//input[@id='last-name']");
    public static Target LABEL_POSTALCODE=Target.the("Label para ingresar el Codigo postal")
            .locatedBy("//input[@id='postal-code']");
    public static Target BUTTON_CONTINUE =Target.the("Boton para continuar a la descripcion de la compra")
            .locatedBy("//input[@id='continue']");
    public static Target BUTTON_FINISH =Target.the("Boton para finalizar la compra de los productos")
            .locatedBy("//button[@id='finish']");
    public static Target LABEL_CONFIRMACIONCOMPRA =Target.the("Label que muestra la confirmacion de la compra")
            .locatedBy("//h2[@class='complete-header']");
}

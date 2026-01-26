package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.CheckoutPage;
import userinterface.ProductsPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TaskRealizarCheckout implements Task {
    private final String primerNombre;
    private final String segundoNombre;
    private final String codigoPostal;

    public TaskRealizarCheckout(String primerNombre, String segundoNombre, String codigoPostal) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.codigoPostal = codigoPostal;
    }
    public static TaskRealizarCheckout ConInformacionDe(String primerNombre, String segundoNombre, String codigoPostal){
        return instrumented(TaskRealizarCheckout.class,primerNombre, segundoNombre, codigoPostal);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.BUTTON_CARRITO.resolveFor(actor)),
                Click.on(CheckoutPage.BUTTON_GOTOCHECKOUT.resolveFor(actor)),
                Enter.theValue(primerNombre).into(CheckoutPage.LABEL_FIRSTNAME),
                Enter.theValue(segundoNombre).into(CheckoutPage.LABEL_LASTNAME),
                Enter.theValue(codigoPostal).into(CheckoutPage.LABEL_POSTALCODE),
                Click.on(CheckoutPage.BUTTON_CONTINUE.resolveFor(actor)),
                Click.on(CheckoutPage.BUTTON_FINISH.resolveFor(actor))
        );
    }
}

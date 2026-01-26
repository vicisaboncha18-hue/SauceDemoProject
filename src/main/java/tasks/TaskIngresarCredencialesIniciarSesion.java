package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TaskIngresarCredencialesIniciarSesion implements Task {
    private final String username;
    private final String password;

    public TaskIngresarCredencialesIniciarSesion(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public static Performable conCredenciales(String username, String password) {
        return instrumented(TaskIngresarCredencialesIniciarSesion.class, username,password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.INPUT_USERNAME),
                Enter.theValue(password).into(LoginPage.INPUT_PASSWORD),
                Click.on(LoginPage.LOGIN_BTN)
        );
    }
}

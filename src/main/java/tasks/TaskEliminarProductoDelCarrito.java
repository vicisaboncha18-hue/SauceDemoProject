package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.ProductsPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TaskEliminarProductoDelCarrito implements Task {
    private final String nombreProducto;

    public TaskEliminarProductoDelCarrito(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public static TaskEliminarProductoDelCarrito conNombre(String nombreProducto){
        return instrumented(TaskEliminarProductoDelCarrito.class,nombreProducto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                TaskSeleccionarProducto.ConNombre(nombreProducto),
                Click.on(ProductsPage.BUTTON_REMOVE.resolveFor(actor)),
                Click.on(ProductsPage.BUTTON_BACKTOPRODUCTS.resolveFor(actor))
        );
    }
}

package tasks;

import exceptions.ExcepcionProductoNoEncontrado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.ProductsPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TaskSeleccionarProducto implements Task {
    private final String nombreProducto;

    public TaskSeleccionarProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public static TaskSeleccionarProducto ConNombre(String nombreProducto){
        return instrumented(TaskSeleccionarProducto.class,nombreProducto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(
                    Click.on(ProductsPage.getProducto(nombreProducto).resolveFor(actor))
            );
        }catch (Throwable e){
            throw new ExcepcionProductoNoEncontrado(nombreProducto);
        }

    }
}

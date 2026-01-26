package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.ProductsPage;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class TaskAñadirProductoAlCarrito implements Task {
    private List<String> nombreProductos;

    public TaskAñadirProductoAlCarrito(List<String> nombreProductos) {
        this.nombreProductos = nombreProductos;
    }
    //Se generaron 2 metodos para tener la posibilidad de añadir tanto un producto individual
    // y tambien tener la posibilidad de agregar una lista de productos.
    public static TaskAñadirProductoAlCarrito conNombre(String nombreProductos){
        return instrumented(TaskAñadirProductoAlCarrito.class,List.of(nombreProductos));
    }
    public static TaskAñadirProductoAlCarrito conNombres(List<String> Productos){
        return instrumented(TaskAñadirProductoAlCarrito.class,Productos);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        for(String Producto:nombreProductos){
            actor.attemptsTo(
                    TaskSeleccionarProducto.ConNombre(Producto),
                    Click.on(ProductsPage.BUTTON_ADDTOCART.resolveFor(actor)),
                    Click.on(ProductsPage.BUTTON_BACKTOPRODUCTS.resolveFor(actor))
            );
        }

    }
}

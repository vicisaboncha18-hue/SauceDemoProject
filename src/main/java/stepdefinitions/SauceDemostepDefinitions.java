/*En esta seccion se detallan los steps utilizados por las definiciones*/
package stepdefinitions;

import hooks.SauceDemoHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import questions.RespuestaConfirmacionCeckout;
import questions.RespuestaConfirmacionLogin;
import questions.RespuestaErrorLogin;
import questions.RespuestaValidacionDelCarrito;
import tasks.TaskAñadirProductoAlCarrito;
import tasks.TaskEliminarProductoDelCarrito;
import tasks.TaskIngresarCredencialesIniciarSesion;
import tasks.TaskRealizarCheckout;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SauceDemostepDefinitions {
    @Given("El usuario se encuentra en la pagina de login")
    public void ElUsuarioSeEncuentraEnLaPaginaDeLogin(){
        theActorInTheSpotlight().attemptsTo(
                Open.url(SauceDemoHooks.getProperties().getProperty("SauceDemoURL"))
        );
    }
    @When("El usuario ingresa las credenciales correctas")
    public void ElUsuarioIngresaLasCredenciales(){
        theActorInTheSpotlight().attemptsTo(
                TaskIngresarCredencialesIniciarSesion.conCredenciales(
                        SauceDemoHooks.getProperties().getProperty("SauceDemoUsername"),
                        SauceDemoHooks.getProperties().getProperty("SauceDemoPassword")
                )
        );
    }
    @Then("La pagina debe mostrar un mensaje de bienvenida")
    public void LaPaginaMuestraUnMensajeDeBienvenida(){
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Se encuentra el mensaje de: ", RespuestaConfirmacionLogin.delMensaje("Products"))
        );
    }
    @When("El usuario ingresa con credenciales invalidas {string} y {string}")
    public void ElUsuarioIngresaLasCredencialesErroneas(String username, String password){
        theActorInTheSpotlight().attemptsTo(
                TaskIngresarCredencialesIniciarSesion.conCredenciales(username,password)
        );
    }
    @Then("La pagina debe mostrar el mensaje de error {string}")
    public void LaPaginaMuestraUnMensajeDeError(String mensaje){
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Se Muestra el mensaje de error:", RespuestaErrorLogin.delMensaje(mensaje))
        );
    }
    @When("El usuario selecciona el producto {string} y El usuario Agrega el producto al carrito")
        public void ElUsuarioSeleccionaUnProductoYAgregaElProductoAlCarrito(String nombreProducto){
            theActorInTheSpotlight().attemptsTo(
                    TaskAñadirProductoAlCarrito.conNombre(nombreProducto)
            );
        }

    @Then("El producto {string} debe mostrarse en la pantalla sel carrito.")
    public void elProductoDebeMostrarseEnLaPantallaSelCarrito(String nombreProducto) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El producto se muestra en el carrito: ", RespuestaValidacionDelCarrito
                        .delProducto(nombreProducto))
        );
    }


    @Given("El usuario ingresa las credenciales correctas y El usuario Agrega el producto {string} al carrito")
    public void elUsuarioIngresaLasCredencialesCorrectasYElUsuarioAgregaElProductoAlCarrito(String nombreProducto) {
        boolean ProductoYaAgregado;
        //Evalua si el producto ya fue agregado al previamente al carrito, si no es el caso, entonces lo agrega
        ElUsuarioIngresaLasCredenciales();
        ProductoYaAgregado=RespuestaValidacionDelCarrito.delProducto(nombreProducto)
                .answeredBy(theActorInTheSpotlight());
        if(!ProductoYaAgregado){
            ElUsuarioSeleccionaUnProductoYAgregaElProductoAlCarrito(nombreProducto);
        }

    }

    @When("El usuario procede a realizar el checkout e ingresa los datos")
    public void elUsuarioProcedeARealizarElCheckoutEIngresaLosDatos() {
        theActorInTheSpotlight().attemptsTo(
                TaskRealizarCheckout.ConInformacionDe("Victor","Bonilla","2101")
        );
    }

    @Then("La compra debe ser confirmada exitosamente")
    public void laCompraDebeSerConfirmadaExitosamente() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Se muestra confirmacion de la compra: ", RespuestaConfirmacionCeckout.ConMensaje("Thank you for your order!"))
        );
    }

    @And("El usuario elimina el producto {string} del carrito")
    public void elUsuarioEliminaUnProductoDelCarrito(String nombreProducto) {
        theActorInTheSpotlight().attemptsTo(
                TaskEliminarProductoDelCarrito.conNombre(nombreProducto)
        );
    }

    @When("El usuario selecciona y agrega los siguientes productos al carrito:")
    public void elUsuarioSeleccionaYAgregaLosSiguientesProductosAlCarrito(DataTable dataTable) {
        List<String> productos = dataTable.asList(String.class);
        theActorInTheSpotlight().attemptsTo(
                TaskAñadirProductoAlCarrito.conNombres(productos)
        );
    }
}

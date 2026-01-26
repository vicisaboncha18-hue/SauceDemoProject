package hooks;

import exceptions.ExceptionLoadProperties;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SauceDemoHooks {
    static Properties properties=new Properties();
    @Before
    public void setUpOnStage(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Tester");
    }
    @Before
    public void onStage() throws ExceptionLoadProperties {
        try(FileReader reader= new FileReader("src/test/resources/general.properties")){
            properties.load(reader);
        }catch(IOException e){
            throw new ExceptionLoadProperties("Error en cargar el archivo de propiedades", e);
        }
    }
    public static Properties getProperties(){
        return properties;
    }
}

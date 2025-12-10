package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Hooks {
    public  static WebDriver driver;
    @Before
    public void setup(){
        driver =new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @After
    public void teaDown(){
        driver.quit();
    }
}



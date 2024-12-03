import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
WebDriver driver;
    public loginpage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
@FindBy(id = "home-ubicacion")
WebElement homeubi;
    public WebElement homeubicacionPOM()
    {
        WebElement homeubicacion=driver.findElement(By.id("home-ubicacion"));
        return homeubicacion;
    }
    public WebElement resultadoDeImputPOM()
    {
        WebElement resultadoDeImput=driver.findElement(By.xpath("//span[@data-id='VILLA-PUEYRREDON']"));
        return resultadoDeImput;
    }
    
    public WebElement lupitaPOM()
    {
        WebElement lupita=driver.findElement(By.xpath("//button[@id='submit-buscar-por-ubicacion']"));
        return lupita;
    }
    public By flashPOM()
    {
        By flash=By.xpath("//h1[normalize-space()='Departamentos en Alquiler en Villa Pueyrredon']");
        return flash;
    }
    public By logoutPOM()
    {
        By logout =By.xpath("//img[@data-logo='true']");
        return logout;
    }
    public void loginsteps(String homeubicacion)
    {
    	homeubicacionPOM().sendKeys(homeubicacion);
    	resultadoDeImputPOM().click();
    	lupitaPOM().click();
    }
}

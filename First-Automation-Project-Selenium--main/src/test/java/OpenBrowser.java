import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowser {
WebDriver driver=null;
loginpage login=null;

  @BeforeTest
  public void OpenBrowser() throws InterruptedException {
      String chroampath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
      System.setProperty("webdriver.chrome.driver",chroampath);
      driver= new ChromeDriver();
      login=new loginpage(driver);
      driver.navigate().to("https://www.argenprop.com/");
      driver.manage().window().maximize();
      Thread.sleep(3000);

  }


  @Test
  public void ValidData()
  {
      login.loginsteps("Capital FederaL, villa puyrredon");
      String expectedresult="Departamentos en Alquiler en Villa Pueyrredon";
      String actualresult=driver.findElement(login.flashPOM()).getText();

      System.out.println("first assertion");
      Assert.assertTrue(actualresult.contains(expectedresult));

      System.out.println("second assertion");
      Assert.assertTrue(driver.findElement(login.logoutPOM()).isDisplayed());

  }
  @Test
  public void InValidData()
  {
      login.loginsteps("Barrio Pirulo");

      System.out.println("first assertion");
      String expectedresult="Departamentos en Alquiler en Villa Pueyrredon";
      String actualresult=driver.findElement(login.flashPOM()).getText();
      Assert.assertTrue(actualresult.contains(expectedresult),"Error message : text is wrong");



  }
  @AfterTest
  public void CloseDriver()
  {
      driver.quit();
  }




}

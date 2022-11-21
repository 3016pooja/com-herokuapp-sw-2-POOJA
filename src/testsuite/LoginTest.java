package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials(){
        //*Enter “tomsmith” username
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        //Enter SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
// click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify the text secure area
        String expectedMessage = "Secure Area";
        WebElement actualTestMessageElement= driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        String actualMessage= actualTestMessageElement.getText();

        Assert.assertEquals("secure area test displayed",expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter “tomsmith1” username
        driver.findElement(By.name("username")).sendKeys("tomsmith1");
        //Enter SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
     // click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        // Verify the error message “Your username   is invalid!”
        String expectedMessage = "Your username is invalid!\n" +
                "×";
        WebElement actualTestMessageElement= driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMessage= actualTestMessageElement.getText();

        Assert.assertEquals("flash erro message displayed",expectedMessage,actualMessage);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //*Enter “tomsmith” username
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        //Enter SuperSecretPassword” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
// click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify the text secure area
        String expectedMessage = "Your password is invalid!\n" +
                "×";
        WebElement actualTestMessageElement= driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMessage= actualTestMessageElement.getText();

        Assert.assertEquals("secure area test displayed",expectedMessage,actualMessage);
    }
    @After
    public void testDown(){
        //closeBrowser();
    }

}

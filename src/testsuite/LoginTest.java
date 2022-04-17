package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement signinlink = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signinlink.click();

        String expectedMessage = "Welcome Back!";
        WebElement actualMessageelement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to  area ", expectedMessage, actualMessage);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        WebElement signinlink = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signinlink.click();

        WebElement emailfield = driver.findElement(By.id("user[email]"));
        emailfield.sendKeys("Devanshi@gmail.com");
        WebElement passwordfield = driver.findElement(By.name("user[password]"));
        passwordfield.sendKeys("1234");

        WebElement signinbutton = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        signinbutton.click();

        String expectedMessage = "Invalid email or password.";
        WebElement actualMessageelement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to  area ", expectedMessage, actualMessage);
    }
}


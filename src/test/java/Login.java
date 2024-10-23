import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    WebDriver driver;


    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By loginField = By.id("user-name");
        By passwordField = By.id("password");
        By loginButton = By.id("login-button");
        By productsTitle = By.className("product_label");


        driver.findElement(loginField).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();

        boolean result = driver.findElement(productsTitle).isDisplayed();
        Assert.assertTrue(result);

        driver.quit();


    }


    @Test
    public void test2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By loginField = By.id("user-name");
        By passwordField = By.id("password");
        By loginButton = By.id("login-button");
        By errorMessage = By.xpath("//h3[@data-test ='error']");

        driver.findElement(loginField).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("");
        driver.findElement(loginButton).click();
        String error = driver.findElement(errorMessage).getText();

        Assert.assertEquals(error, "Epic sadface: Password is required");
        driver.quit();
    }

    @Test
    public void test3() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By loginField = By.id("user-name");
        By passwordField = By.id("password");
        By loginButton = By.id("login-button");
        By errorMessage = By.xpath("//h3[@data-test ='error']");

        driver.findElement(loginField).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("123456");
        driver.findElement(loginButton).click();
        String error = driver.findElement(errorMessage).getText();

        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }

    @Test
    public void test4() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By loginField = By.id("user-name");
        By passwordField = By.id("password");
        By loginButton = By.id("login-button");
        By errorMessage = By.xpath("//h3[@data-test ='error']");

        driver.findElement(loginField).sendKeys("");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
        String error = driver.findElement(errorMessage).getText();

        Assert.assertEquals(error, "Epic sadface: Username is required");
        driver.quit();
    }

    @Test
    public void test5() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By loginField = By.id("user-name");
        By passwordField = By.id("password");
        By loginButton = By.id("login-button");
        By errorMessage = By.xpath("//h3[@data-test ='error']");

        driver.findElement(loginField).sendKeys("");
        driver.findElement(passwordField).sendKeys("");
        driver.findElement(loginButton).click();
        String error = driver.findElement(errorMessage).getText();

        Assert.assertEquals(error, "Epic sadface: Username is required");
        driver.quit();
    }

    @Test
    public void test6() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        By loginButton = By.id("login-button");


        boolean result = driver.findElement(loginButton).isDisplayed();
        Assert.assertTrue(result);

        driver.quit();


    }
}
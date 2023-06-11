package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CChallenge {
    public WebDriver driver;
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void CodeChall(){
        WebElement user;
        user = driver.findElement(By.id("user-name"));
        user.click();
        user.sendKeys("standard_user");

        user = driver.findElement(By.id("password"));
        user.click();
        user.sendKeys("secret_sauce");

        user = driver.findElement(By.id("login-button"));
        user.click();
    }
    public void AddCart(){
        WebElement Add;
        Add = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        Add.click();
        Add = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        Add.click();
        Add = driver.findElement(By.cssSelector("div.page_wrapper div:nth-child(1) div.header_container:nth-child(1) div.primary_header div.shopping_cart_container:nth-child(3) > a.shopping_cart_link"));
        Add.click();
    }

    public void removeCheckout(){
        WebElement remove;
        remove = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        remove.click();
        remove = driver.findElement(By.id("checkout"));
        remove.click();
    }
    @Test
    public void verificarFuncionalidadPagWeb(){
        setUp();
        CodeChall();
        AddCart();
        removeCheckout();
    }

}

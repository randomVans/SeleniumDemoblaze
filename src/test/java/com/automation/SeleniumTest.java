package com.automation;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SeleniumTest extends BaseTest{
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test the login")
    @Feature("Login test form auth")
    public void testLoginPage(){
        openWeb("https://demoblaze.com/");
        selectFirstProductCategory("Laptops");
//        navigateToFormAuthentication();
//        fillLoginForm("tomsmith", "SuperSecretPassword!");
//        validateLoginSuccess();
    }

    @Step("Open Home Page")
    public void openWeb(String url){
        getDriver().get(url);
    }

    public void selectFirstProductCategory(String category){
        getDriver().findElement(By.cssSelector("[onclick='byCat(\\'notebook\\')']"));
//        getDriver().findElement(By.xpath("//a[.='"+category+"']"));
        try {
            Thread.sleep(5000);
        }catch (InterruptedException ie){}
        getDriver().findElement(By.xpath("//div[@id='tbodyid']/div[1]"));
    }

    @Step("Navigate to the form authentication")
    public void navigateToFormAuthentication(){
        getDriver().findElement(By.linkText("Form Authentication")).click();
    }


    @Step("Fill Login form")
    public void fillLoginForm(String userName, String password){
        getDriver().findElement(By.id("username")).sendKeys(userName);
        getDriver().findElement(By.id("password")).sendKeys(password);
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Step("Validate login success")
    public String validateLoginSuccess(){
        String succesMsg = getDriver().findElement(By.cssSelector(".flash.success")).getText();
        assertTrue(getDriver().findElement(By.cssSelector(".flash.success")).isDisplayed());
        return  succesMsg;
    }
}

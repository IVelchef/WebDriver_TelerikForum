package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AtlassianLoginPage extends BaseAtlassianPage{


    public AtlassianLoginPage() {
        super("/login");
    }

    private final By usernameLocator = By.id("username");
    private final By submitButtonLocator = By.id("login-submit");
    private final By passwordLocator = By.id("password");



    public void submitLoginForm(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        usernameInput.sendKeys(username);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButton.click();

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        passwordInput.sendKeys(password);

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitBtn.click();
    }
    public String getCurrentUrl() {
        return driver().getCurrentUrl();
    }
}

package com.jira.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AtlassianHomePage extends BaseAtlassianPage {
    public AtlassianHomePage() {
super("/о");
    }

    private final By pageTitleLocator = By.cssSelector("h1.css-xtidjr");
    private final By presentationButtonLocator = By.cssSelector("div.css-1cci1s > div:nth-child(4) > div");
    private final By logoutButtonLocator = By.className("css-12dc8u4");
    private final By appBoxLocator = By.cssSelector(".css-1xama9u");


    public void waitForPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleLocator));
    }

    public void checkElementVisibility () {

        WebElement appBox = driver().findElement(appBoxLocator);
        boolean isVisible = appBox.isDisplayed();

    }

    public void assertNavigated() {

        String actualUrl = driver().getCurrentUrl();

    }

    public void logout() {
        driver().findElement(presentationButtonLocator).click();
        var logoutBtn = driver().findElement(logoutButtonLocator);
        driverWait().until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutBtn.click();
    }


}
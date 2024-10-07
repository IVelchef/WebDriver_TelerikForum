package com.jira.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JiraProjectsHomePage extends BaseAtlassianPage {

    private final By projectsAppLocator = By.className("css-17oiokn");
    private final By jiraLogoutLocator = By.cssSelector("[id='atlassian-navigation.ui.profile.icon']");

    private final By jiraLogoutButton = By.xpath("//span[contains(text(),'Log out')]");
    private final By verifyTextOnPage = By.className("css-1hd76a5");

    private final By issueDetailsLocator = By.cssSelector("div[data-testid='issue.views.issue-details.issue-layout.container-left']");
    private final By modalLocator = By.cssSelector("section[data-testid='issue-create.ui.modal.modal-wrapper.modal']");
    private final By headerLocator = By.cssSelector("div#jira-issue-header[data-testid='issue-view-sticky-header-container.sticky-header']");




    public JiraProjectsHomePage() {
        super("/");
    }


    public void navigateToYourApps() {

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(projectsAppLocator));
        driver().findElement(projectsAppLocator).click();
    }


    public void assertNavigated() {

        String actualUrl = driver().getCurrentUrl();

    }


    public void jiraUserLogout() {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(jiraLogoutLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(jiraLogoutLocator));
        driver().findElement(jiraLogoutLocator).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(jiraLogoutButton));
        driverWait().until(ExpectedConditions.elementToBeClickable(jiraLogoutButton));
        driver().findElement(jiraLogoutButton).click();

    }

    public void waitForPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyTextOnPage));
    }

    public boolean isIssueCreatedSuccessfully() {
        try {
            driverWait().until(ExpectedConditions.visibilityOfElementLocated(issueDetailsLocator));

            return true;
        } catch (TimeoutException e) {
            return false;
        }

    }

    public boolean isModalVisible() {
        try {


            driverWait().until(ExpectedConditions.visibilityOfElementLocated(modalLocator));

            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isIssueHeaderVisible() {
        try {

            driverWait().until(ExpectedConditions.visibilityOfElementLocated(headerLocator));

            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}



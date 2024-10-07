package com.jira.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateJiraStoryPage extends CreateJiraProjectPage{

    private final By summaryFieldLocator =By.id("summary-field");
    private final By descriptionFieldLocator = By.id("ak-editor-textarea");
    private final By priorityFieldLocator =By.id("priority-field");
    private final By priorityLabelLocator = By.id("priority-field-label");
    private final By createButtonLocator =  By.xpath("//button[@data-testid='issue-create.common.ui.footer.create-button']");


    public void createIssue () {


    driverWait().until(ExpectedConditions.elementToBeClickable(summaryFieldLocator));
    driver().findElement(summaryFieldLocator).sendKeys("As a user, I want to see correct information in German when " +
            "switching the site language.");


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(descriptionFieldLocator)).click();
        driver().findElement(descriptionFieldLocator).sendKeys("When a user changes the site language to German, all text elements on the page, including menus, " +
                "offer descriptions, and other page text, must be correctly translated and displayed in German.\n" +
                "Acceptance Criteria : \n" +
                "All texts are correctly displayed in German.\n" +
                "No missing or incorrectly translated elements.\n" +
                "Users can navigate and use the website in German without issues.");

        driverWait().until(ExpectedConditions.elementToBeClickable(priorityLabelLocator)).click();
        WebElement priorityField = driver().findElement(priorityFieldLocator);
        priorityField.sendKeys("High" + Keys.ENTER);


        driverWait().until(ExpectedConditions.elementToBeClickable(createButtonLocator));
        driver().findElement(createButtonLocator).click();


    }
}

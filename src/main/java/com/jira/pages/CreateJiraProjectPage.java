package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateJiraProjectPage extends JiraProjectsHomePage {

    private final By createButtonLocator = By.cssSelector("[data-testid='global-pages.directories.projects-directory-v3.create-projects-button']");
    private final By projectTemplatesLocator = By.xpath("//span[contains(@class, 'css-178ag6o') and text()='Software development']");
    private final By scrumTemplate = By.cssSelector("[data-testid='project-template-select-v2.ui.layout.category-overview.template-list-card.template-list-button']");
    private final By useTemplateLocator = By.cssSelector("[data-testid='project-template-select-v2.ui.layout.screens.template-overview.template-overview-card.use-template-button.button']");
    private final By projectTypeLocator = By.cssSelector("[data-testid='project-template-select-v2.ui.layout.screens.project-types.footer.select-project-button-company-managed']");
    private final By projectNameFieldLocator = By.cssSelector("[data-testid='project-create.create-form.name-field.input']");
    private final By nextButtonLocator = By.xpath("//button[.//span[text()='Next']]");
    private final By continueButtonLocator = By.xpath("//button[@data-testid='devops-container-linking.ui.container-linking.page-actions.continue-button']");
    private final By boardAreaLocator = By.cssSelector("[data-testid='software-board.board-area']");

    public void createProject (String jiraProjectName) {

        driver().findElement(createButtonLocator).click();

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(projectTemplatesLocator));
        driver().findElement(projectTemplatesLocator).click();

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(scrumTemplate));
        driver().findElement(scrumTemplate).click();

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(useTemplateLocator));
        driver().findElement(useTemplateLocator).click();

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(projectTypeLocator));
        driver().findElement(projectTypeLocator).click();

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(projectNameFieldLocator));
        driver().findElement(projectNameFieldLocator).sendKeys(jiraProjectName);


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(nextButtonLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(nextButtonLocator));

        if (driver().findElement(nextButtonLocator).isDisplayed()) {
            driver().findElement(nextButtonLocator).click();
        } else {
            System.out.println("Button is not clickable due to another element.");
        }


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(continueButtonLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        driver().findElement(continueButtonLocator).click();



        driverWait().until(ExpectedConditions.visibilityOfElementLocated(boardAreaLocator));
        WebElement boardArea = driver().findElement(boardAreaLocator);
        assertTrue(boardArea.isDisplayed(), "Board area should be visible");



    }
}




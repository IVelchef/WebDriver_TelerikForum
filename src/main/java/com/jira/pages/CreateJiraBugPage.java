package com.jira.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateJiraBugPage extends CreateJiraProjectPage{

    private final By createIssueButtonLocator = By.id("createGlobalItem");
    private final By summaryFieldLocator =By.id("summary-field");
    private final By descriptionFieldLocator = By.id("ak-editor-textarea");
    private final By priorityFieldLocator =By.id("priority-field");
    private final By priorityLabelLocator = By.id("priority-field-label");
    private final By createButtonLocator =  By.xpath("//button[@data-testid='issue-create.common.ui.footer.create-button']");
    private final By navigationAppsSidebar =  By.cssSelector("a[data-testid='navigation-apps-sidebar-software-classic.ui.menu.issues-link--item']");
    private final By navigatorIssueOperations =  By.cssSelector("button[data-testid='issue-navigator-issue-operations.ui.button']");
    private final By issueActionView =  By.cssSelector("a[menuitemid='issueaction-view-issue']");
    private final By addButtonDropdown = By.cssSelector("button[data-testid='issue-view-foundation.quick-add.quick-add-items-compact.add-button-dropdown--trigger']");
    private final By addItemLink = By.cssSelector("button[data-testid='issue.issue-view.views.issue-base.foundation.quick-add.quick-add-item.link-issue']");
    private final By createLinkedIssue = By.cssSelector("button[data-testid='issue.views.issue-base.content.issue-links.add.create-linked-issue-button.create-linked-issue-button']");
    private final By createLinkedIssueContainerLocator = By.cssSelector("div._bfhktxrc");

    private static final int MAX_RETRIES = 5;
    private static final long WAIT_TIME_BETWEEN_RETRIES = 1000;
    public void createBug () {


        driver().findElement(createIssueButtonLocator).click();


        driverWait().until(ExpectedConditions.elementToBeClickable(summaryFieldLocator));
        driver().findElement(summaryFieldLocator).sendKeys("Language change to German does not reflect on UI");


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(descriptionFieldLocator)).click();
        driver().findElement(descriptionFieldLocator).sendKeys("Steps to reproduce:\n" +
                "1. Open the website https://www.phptravels.net.\n" +
                "2. From the dropdown menu in the top right corner, select \"Deutsch (German)\".\n" +
                "Expected vs. Actual result:\n" +
                "Expected: The website should reload and display content in German.\n" +
                "Actual: The website remains in English, even though the URL changes to https://www.phptravels.net/de.\n" +
                "Severity: Medium – The functionality is partially compromised, but the site can still be used in other languages.\n" +
                "Prerequisites: Users do not need a valid account to use the site for checking tickets, car reservations, or browsing.\n" +
                "Additional info:\n" +
                "Environment: macOS\n" +
                "Browser: Safari, version 16.6\n" +
                "OS: macOS\n" +
                "Classification:\n" +
                "Labels: Bug, Language Switch\n" +
                "Responsible team: Frontend Development\n" +
                "Functionality: Language Selection\n" +
                "Version observed on: Latest version of the website, as seen on https://www.phptravels.net\n" +
                "Layer causing the issue: Frontend/UI\n" +
                "Attached Images/Videos:\n" +
                "Screenshot of the expected result showing the website content in German.\n" +
                "Screenshot of the actual result showing the website content in English despite the URL change.\n" +
                "Website: https://www.phptravels.net/");

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(priorityLabelLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(priorityLabelLocator)).click();
        WebElement priorityField = driver().findElement(priorityFieldLocator);
        priorityField.sendKeys("High" + Keys.ENTER);

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createButtonLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(createButtonLocator));
        driver().findElement(createButtonLocator).click();

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(navigationAppsSidebar));
        driverWait().until(ExpectedConditions.elementToBeClickable(navigationAppsSidebar));
        driver().findElement(navigationAppsSidebar).click();


        WebElement parentDiv = driverWait().until(ExpectedConditions.visibilityOfElementLocated(createLinkedIssueContainerLocator));


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(navigatorIssueOperations));
        WebElement moreActionsButton = parentDiv.findElement(navigatorIssueOperations);
        driverWait().until(ExpectedConditions.elementToBeClickable(moreActionsButton)).click();

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(issueActionView));
        driverWait().until(ExpectedConditions.elementToBeClickable(issueActionView));
        driver().findElement(issueActionView).click();



        clickAddButtonWithRetry();




        driverWait().until(ExpectedConditions.visibilityOfElementLocated(addItemLink));
        driverWait().until(ExpectedConditions.elementToBeClickable(addItemLink));
        driver().findElement(addItemLink).click();



        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createLinkedIssue));
        driverWait().until(ExpectedConditions.elementToBeClickable(createLinkedIssue));
        driver().findElement(createLinkedIssue).click();


    }
    private void clickAddButtonWithRetry() {
        int attempt = 0;

        while (attempt < MAX_RETRIES) {
            try {
                WebElement addButton = driverWait().until(ExpectedConditions.elementToBeClickable(addButtonDropdown));
                addButton.click();
                System.out.println("Click on the 'addButtonDropdown' was successful.");
                return;
            } catch (TimeoutException e) {
                attempt++;
                System.out.println("Attempt " + attempt + " failed. Waiting " + WAIT_TIME_BETWEEN_RETRIES
                        + " ms before the next attempt.");
                try {
                    Thread.sleep(WAIT_TIME_BETWEEN_RETRIES);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    System.out.println("Waiting between attempts was interrupted.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred while trying to click on the 'addButtonDropdown': " + e.getMessage());
                break;
            }
        }
        System.out.println("Could not click on the 'addButtonDropdown' after " + MAX_RETRIES + " attempts.");
    }

}
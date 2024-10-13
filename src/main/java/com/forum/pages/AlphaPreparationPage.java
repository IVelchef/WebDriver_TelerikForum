package com.forum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlphaPreparationPage extends BaseStageForumPage {


    public AlphaPreparationPage() {
        super("/c/alpha-preparation/15");
    }

    private final By topicRowLocator = By.xpath("//tbody[@class='topic-list-body']//tr[.//a[text()='More than one image uploaded']]");
    private final By listAreaLocator = By.id("list-area");
    private final By createButtonLocator = By.cssSelector(".topic-footer-main-buttons .btn.btn-icon-text.btn-primary.create");
    private final By textAreaLocator = By.cssSelector(".d-editor-input");  // Използваме class селектор
    private final By createReplyButtonLocator = By.cssSelector("div.save-or-cancel button.btn.btn-icon-text.btn-primary.create");




    public void checkElementVisibility() {

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(listAreaLocator));

    }

public void openSpecificTopic () {


    driverWait().until(ExpectedConditions.visibilityOfElementLocated(listAreaLocator));
    WebElement topicRow = driverWait().until(ExpectedConditions.visibilityOfElementLocated(topicRowLocator));
    WebElement topicLink = topicRow.findElement(By.cssSelector("a.title.raw-link.raw-topic-link"));
    topicLink.click();


}

    public void addReplyToTopic () {

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createButtonLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(createButtonLocator)).click();


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(textAreaLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(textAreaLocator))
                .sendKeys("Hi, I am Vankich,  and I did it   :smile: :partying_face: :speak_no_evil: :see_no_evil: :heart:");


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createReplyButtonLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(createReplyButtonLocator)).click();


    }
}

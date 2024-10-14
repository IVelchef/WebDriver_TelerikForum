package com.forum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AlphaPreparationPage extends BaseStageForumPage {


    public AlphaPreparationPage() {
        super("/c/alpha-preparation/15");
    }

    private final By topicRowLocator = By.xpath("//tbody[@class='topic-list-body']//tr[." +
            "//a[text()='More than one image uploaded']]");
    private final By listAreaLocator = By.id("list-area");
    private final By createButtonLocator = By.cssSelector(".topic-footer-main-buttons " +
            ".btn.btn-icon-text.btn-primary.create");
    private final By textAreaLocator = By.cssSelector(".d-editor-input");
    private final By createReplyButtonLocator = By.cssSelector("div.save-or-cancel button" +
            ".btn.btn-icon-text.btn-primary.create");

public static final String titleComment = "Hi, I am Vanko, and I did it";
public static final String textEmojiComment = " :smile: :partying_face: :beers: :see_no_evil: :hear_no_evil: :speak_no_evil: :heart:";





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
                .sendKeys(titleComment + textEmojiComment);


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createReplyButtonLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(createReplyButtonLocator)).click();


    }

    public boolean validateCommentIsVisible () {

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(listAreaLocator));
        WebElement topicRow = driverWait().until(ExpectedConditions.visibilityOfElementLocated(topicRowLocator));
        WebElement topicLink = topicRow.findElement(By.cssSelector("a.title.raw-link.raw-topic-link"));
        topicLink.click();

        WebElement postsContainer = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.container.posts")));

        List<WebElement> comments = postsContainer.findElements(By.cssSelector("div.cooked"));

        for (WebElement comment : comments) {
            String commentText = comment.getText();
            System.out.println("Found comment: " + commentText);

            if (commentText.contains(titleComment)) {
                System.out.println("The comment was found! - " + titleComment);
                return true;
            }
        }

        System.out.println("The comment was not found.");
        return false;



    }
}


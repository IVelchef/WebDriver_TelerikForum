package com.forum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class AlphaPreparationPage extends BaseStageForumPage {


    public AlphaPreparationPage() {
        super("/c/alpha-preparation/15");
    }

    private final By topicRowLocator = By.xpath("//tbody[@class='topic-list-body']//tr[." +
            "//a[text()='Alpha 61 QA - We are awesome and great']]");
    private final By listAreaLocator = By.id("list-area");
    private final By moreActionsButton = By.cssSelector("button.widget-button.btn-flat.show-more-actions.no-text.btn-icon");
    private final By deleteButton = By.cssSelector("button.widget-button.btn-flat.delete.no-text.btn-icon");
    private final By createButtonLocator = By.cssSelector(".topic-footer-main-buttons " +
            ".btn.btn-icon-text.btn-primary.create");
    private final By textAreaLocator = By.cssSelector(".d-editor-input");
    private final By createReplyButtonLocator = By.cssSelector("div.save-or-cancel button" +
            ".btn.btn-icon-text.btn-primary.create");

public static final String titleComment = "Hi, I am Ivan , and I did it";
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

            if (commentText.contains(titleComment)) {
                System.out.println("The comment was found! - " + titleComment);
                return true;
            }
        }

        System.out.println("The comment was not found.");
        return false;

    }

//    public boolean deleteComment() {
//
////        driverWait().until(ExpectedConditions.visibilityOfElementLocated(listAreaLocator));
////        WebElement topicRow = driverWait().until(ExpectedConditions.visibilityOfElementLocated(topicRowLocator));
////        WebElement topicLink = topicRow.findElement(By.cssSelector("a.title.raw-link.raw-topic-link"));
////        topicLink.click();
//
//        WebElement postsContainer = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.container.posts")));
//
//        List<WebElement> comments = postsContainer.findElements(By.cssSelector("div.cooked"));
//
//        for (WebElement comment : comments) {
//            String commentText = comment.getText();
//
//            // Проверка дали намереният коментар е този, който искаме да изтрием
//            if (commentText.contains(titleComment)) {
//                System.out.println("The comment was found! - " + titleComment);
//
//                try {
//                    // Намиране на контейнера "actions" вътре в текущия коментар
//                    WebElement actionsContainer = comment.findElement(By.cssSelector("div.actions"));
//
//                    // Намиране на бутона "Още действия" и клик върху него
//                    WebElement moreActionsButton = actionsContainer.findElement(By.cssSelector("button.widget-button.btn-flat.show-more-actions.no-text.btn-icon"));
//                    driverWait().until(ExpectedConditions.elementToBeClickable(moreActionsButton)).click();
//
//                    // Изчакване и намиране на бутона за изтриване
//                    WebElement deleteButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.widget-button.btn-flat.delete.no-text.btn-icon")));
//                    driverWait().until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
//
//                    System.out.println("The comment was deleted.");
//                    return true;
//
//                } catch (Exception e) {
//                    System.err.println("Error: Unable to find 'More actions' or 'Delete' button for this comment.");
//                    e.printStackTrace();
//                    return false;
//                }
//            }
//        }
//
//        // Ако коментарът не е намерен
//        System.out.println("The comment was not found.");
//        return false;
//    }

}
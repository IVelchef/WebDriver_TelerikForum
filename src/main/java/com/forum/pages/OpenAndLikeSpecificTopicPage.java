package com.forum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenAndLikeSpecificTopicPage extends BaseStageForumPage{

    private final By topicRowLocator = By.xpath("//tbody[@class='topic-list-body']//tr[." +
            "//a[text()='Alpha 61 QA - We are awesome and great']]");
    private final By listAreaLocator = By.id("list-area");
    private final By likeButtonLocator = By.xpath("//button[@data-post-id='34574' and @title='like this post']");


    public OpenAndLikeSpecificTopicPage(){

        super("/c/alpha-preparation/15");
    }


    public void checkElementVisibility() {

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(listAreaLocator));

    }

    public void openSpecificTopic () {


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(listAreaLocator));
        WebElement topicRow = driverWait().until(ExpectedConditions.visibilityOfElementLocated(topicRowLocator));
        WebElement topicLink = topicRow.findElement(By.cssSelector("a.title.raw-link.raw-topic-link"));
        topicLink.click();


    }

    public void LikeTheTopic () {



        try {

            WebElement element = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.two-rows.extra-info-wrapper")));
            element.click();

            WebElement likeButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='like this post' and contains(@class, 'toggle-like')]")));
            if (likeButton.isDisplayed()) {
                likeButton.click();
                System.out.println("The topic has been liked.");

                driverWait().until(ExpectedConditions.attributeToBe(likeButton, "title", "undo like"));
            }
        } catch (Exception e) {
            System.out.println("Failed to find or click the like button.");
        }

    }



    public void unLikeTheTopic () {


        WebElement element = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.two-rows.extra-info-wrapper")));
        element.click();

        WebElement undoLikeButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='undo like' and contains(@class, 'toggle-like')]")));
        driverWait().until(ExpectedConditions.elementToBeClickable(undoLikeButton)).click();

        System.out.println("The topic has been liked.");
    }
}

package com.forum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenAndLikeSpecificTopicPage extends BaseStageForumPage{

    private final By topicRowLocator = By.xpath("//tbody[@class='topic-list-body']//tr[." +
            "//a[text()='Alpha 61 QA - We are awesome and great']]");
    private final By listAreaLocator = By.id("list-area");
    private final By likeButton = By.id("list-area");
    private final By likeButtonLocator = By.xpath("//button[@title='like this post' and contains(@class, 'toggle-like')]");


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

        WebElement element = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.two-rows.extra-info-wrapper")));
        element.click();

        WebElement likeButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'toggle-like')]")));

        String titleAttribute = likeButton.getAttribute("title");
        System.out.println("Current button title: " + titleAttribute);

        if (titleAttribute.equals("like this post")) {
            likeButton.click();
            System.out.println("The topic has been liked.");

            driverWait().until(ExpectedConditions.attributeToBe(likeButton, "title", "you've liked this post"));
        }


        else if (titleAttribute.equals("you've liked this post") || titleAttribute.equals("undo like") || titleAttribute.equals("you liked this post")) {
            WebElement undoLikeButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[@title=\"" + titleAttribute + "\" and contains(@class, 'toggle-like')]")
            ));




            driverWait().until(ExpectedConditions.elementToBeClickable(undoLikeButton)).click();
            System.out.println("The like has been undone.");

            driverWait().until(ExpectedConditions.attributeToBe(likeButton, "title", "like this post"));
        }

        else {
            System.out.println("The button has an unexpected title: " + titleAttribute);
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

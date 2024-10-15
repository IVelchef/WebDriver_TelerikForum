package com.forum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenAndLikeSpecificTopicPage extends BaseStageForumPage{

    private final By topicRowLocator = By.xpath("//tbody[@class='topic-list-body']//tr[." +
            "//a[text()='Alpha 50 QA - We are awesome and great']]");
    private final By listAreaLocator = By.id("list-area");


    private final By likeButtonLocator = By.xpath("//button[contains(@class, 'toggle-like')]");

    private final By createButtonLocator = By.cssSelector(".topic-footer-main-buttons " +
            ".btn.btn-icon-text.btn-primary.create");


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

        WebElement likeButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeButtonLocator));


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createButtonLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(createButtonLocator));




        String titleAttribute = likeButton.getAttribute("title");
        System.out.println("Current button title: " + titleAttribute);


        if (titleAttribute.equals("like this post")) {

            driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeButtonLocator));

            driverWait().until(ExpectedConditions.elementToBeClickable(likeButtonLocator));

            likeButton.click();

        }
        else if (titleAttribute.equals("you've liked this post") || titleAttribute.equals("undo like") || titleAttribute.equals("you liked this post")) {

            driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeButtonLocator));
            driverWait().until(ExpectedConditions.elementToBeClickable(likeButtonLocator));
            likeButton.click();

        } else {
            System.out.println("The button has an unexpected title: " + titleAttribute);
        }
    }




    public String getLikeButtonTitle() {
        WebElement likeButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'toggle-like')]")));
        return likeButton.getAttribute("title");
    }


}

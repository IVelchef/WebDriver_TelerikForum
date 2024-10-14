package com.forum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Random;

public class CreateNewTopicView extends StageForumHomePage {


    private final By newTopicButtonLocator = By.id("create-topic");
    private final By titleFieldLocator = By.id("reply-title");
    private final By textAreaLocator = By.cssSelector("textarea.d-editor-input");
    private final By createTopicButtonLocator = By.cssSelector("button.btn.btn-icon-text.btn-primary.create");

    private final String[] descriptionWords = {"automation", "selenium", "java", "topic", "framework",
            "random", "testing", "web", "driver", "click"};




    private String newTopicTitle;

    public void checkElementVisibility() {

        driverWait().until(ExpectedConditions.elementToBeClickable(newTopicButtonLocator));
        driver().findElement(newTopicButtonLocator).click();

    }

    public void createNewTopic() {

        driverWait().until(ExpectedConditions.elementToBeClickable(titleFieldLocator));
        newTopicTitle = generateRandomTitle();
        driver().findElement(titleFieldLocator).sendKeys(newTopicTitle);

        driverWait().until(ExpectedConditions.elementToBeClickable(textAreaLocator)).click();
        driver().findElement(textAreaLocator).sendKeys(generateRandomDescription());

        driverWait().until(ExpectedConditions.elementToBeClickable(createTopicButtonLocator));
        driver().findElement(createTopicButtonLocator).click();
    }


    private String generateRandomText ( int wordCount, String[] wordArray){
        StringBuilder text = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < wordCount; i++) {
            text.append(wordArray[random.nextInt(wordArray.length)]);
            if (i < wordCount - 1) {
                text.append(" ");
            }
        }
        return text.toString();
    }

    public String generateRandomTitle () {
        Random random = new Random();
        int randomNumber = 100 + random.nextInt(900);
        return "This is a random generated title for testing newTopic automation - " + randomNumber;
    }

    public String generateRandomDescription () {
        return generateRandomText(10, descriptionWords);
    }

    public String getNewTopicTitle() {
        return newTopicTitle;
    }
}

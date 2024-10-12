package com.forum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AllTopicsPage extends BaseStageForumPage {

    private final By allTopicsButtonLocator = By.id("ember7");
    private final By containerLocator = By.cssSelector(".topic-list-body");


    public AllTopicsPage() {
        super("/latest");
    }

    public void checkElementVisibility () {

        driverWait().until(ExpectedConditions.elementToBeClickable(allTopicsButtonLocator));
        driver().findElement(allTopicsButtonLocator).click();



    }

    public boolean validateNewTopicCreated(String topicTitle) {
        try {
            driver().navigate().refresh();

            driverWait().until(ExpectedConditions.visibilityOfElementLocated(containerLocator));
            driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("list-area")));


            By topicLocator = By.xpath("//div[@id='list-area']//a[contains(@class, 'title') and text()='" + topicTitle.trim() + "']");

            driverWait().until(ExpectedConditions.visibilityOfElementLocated(topicLocator));

            return driver().findElements(topicLocator).size() > 0;

        } catch (Exception e) {
            System.err.println("Грешка при валидацията на темата: " + e.getMessage());
            return false;
        }
    }
    }



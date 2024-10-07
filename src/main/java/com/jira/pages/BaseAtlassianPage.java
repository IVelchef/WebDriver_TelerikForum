package com.jira.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class BaseAtlassianPage extends BaseWebPage {


    public BaseAtlassianPage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    @Override
    public String getBasePageUrl() {
        return PropertiesManager.getConfigProperties().getProperty("JiraBaseUrl");
    }
}

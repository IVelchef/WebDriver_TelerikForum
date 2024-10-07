package atlassiantests.web;

import atlassiantests.core.JiraBaseTest;

import atlassiantests.unums.JiraTestData;
import org.junit.jupiter.api.Test;

public class JiraLoginTest extends JiraBaseTest {

    @Test
    public void userAuthenticated_when_validCredentialsProvided(){

        // Navigate to Login Page
        atlassianLoginPage.navigate();

        // Submit login form
        atlassianLoginPage.submitLoginForm(JiraTestData.username.getValue(), JiraTestData.password.getValue());
        atlassianHomePage.waitForPageTitle();


        // Assert expected Home page navigated
        atlassianHomePage.checkElementVisibility();
        atlassianHomePage.assertNavigated();

        // Navigate to Log out menu
        atlassianHomePage.logout();






    }










}



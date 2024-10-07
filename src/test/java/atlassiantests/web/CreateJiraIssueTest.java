package atlassiantests.web;
import atlassiantests.core.JiraBaseTest;
import atlassiantests.unums.JiraTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateJiraIssueTest extends JiraBaseTest {

    @BeforeEach
    public void beforeTest(){

        atlassianLoginPage.submitLoginForm(JiraTestData.username.getValue(), JiraTestData.password.getValue());
        JiraTestData.jiraProjectName.setProjectName(JiraTestData.generateRandomProjectName());

    }

    @Test
    public void createProject () {


        atlassianHomePage.waitForPageTitle();

        atlassianHomePage.checkElementVisibility();

        atlassianHomePage.assertNavigated();

        jiraProjectsHomePage.navigateToYourApps();

        jiraProjectsHomePage.assertNavigated();

        jiraProjectsHomePage.waitForPageTitle();

        createJiraProjectPage.createProject(JiraTestData.jiraProjectName.getValue());

        createJiraBugPage.createBug();

        Assertions.assertTrue(jiraProjectsHomePage.isModalVisible(), "Bug creation modal is not visible!");


        createJiraStoryPage.createIssue();

        Assertions.assertTrue(jiraProjectsHomePage.isIssueHeaderVisible(), "Jira issue header is not visible!");

        Assertions.assertTrue(jiraProjectsHomePage.isIssueCreatedSuccessfully(), "Link between Bug and Story not created with 'is blocked by' relation!!");


    }
}

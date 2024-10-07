package atlassiantests.core;
import com.jira.pages.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class JiraBaseTest extends BaseWebTest {
    protected AtlassianLoginPage atlassianLoginPage;
    protected AtlassianHomePage atlassianHomePage;
    protected JiraProjectsHomePage jiraProjectsHomePage;
    protected CreateJiraProjectPage createJiraProjectPage;
    protected CreateJiraStoryPage createJiraStoryPage;
    protected CreateJiraBugPage createJiraBugPage;

    @BeforeEach
    public void beforeTests() {

        atlassianLoginPage = new AtlassianLoginPage();
        atlassianHomePage = new AtlassianHomePage();
        jiraProjectsHomePage = new JiraProjectsHomePage();
        createJiraProjectPage = new CreateJiraProjectPage();
        createJiraStoryPage = new CreateJiraStoryPage();
        createJiraBugPage = new CreateJiraBugPage();


        driver().get(PropertiesManager.getConfigProperties().getProperty("JiraBaseUrl"));
    }

    @BeforeAll
    public static void beforeAll() {
    }

    // close driver
    @AfterEach
    public void afterTest() {
        driver().close();
    }

    @AfterAll
    public static void afterAll() {

        //logout
    }

}
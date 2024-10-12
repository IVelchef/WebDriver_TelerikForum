package stagetelerikforumtests.core;
import com.forum.pages.BaseStageForumPage;
import com.forum.pages.CreateNewTopicView;
import com.forum.pages.StageForumHomePage;
import com.forum.pages.StageForumLoginPage;
import com.jira.pages.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class ForumBaseTest extends BaseWebTest {

    protected StageForumLoginPage stageForumLoginPage;
    protected BaseStageForumPage baseStageForumPage;
    protected StageForumHomePage stageForumHomePage;
    protected CreateNewTopicView createNewTopicView;
    protected CreateJiraStoryPage createJiraStoryPage;
    protected CreateJiraBugPage createJiraBugPage;

    @BeforeEach
    public void beforeTests() {

        stageForumLoginPage = new StageForumLoginPage();
        baseStageForumPage = new BaseStageForumPage();
        stageForumHomePage = new StageForumHomePage();
        createNewTopicView = new CreateNewTopicView();


        driver().get(PropertiesManager.getConfigProperties().getProperty("TelerikStageForumBaseUrl"));
    }

    @BeforeAll
    public static void beforeAll() {
    }

    @AfterEach
    public void afterTest() {
        driver().close();
    }

    @AfterAll
    public static void afterAll() {

        //logout
    }
}

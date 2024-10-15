package stagetelerikforumtests.core;
import com.forum.pages.*;
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
    protected AllTopicsPage allTopicsPage;
    protected AlphaPreparationPage alphaPreparationPage;
    protected OpenAndLikeSpecificTopicPage openAndLikeSpecificTopicPage;

    @BeforeEach
    public void beforeTests() {

        stageForumLoginPage = new StageForumLoginPage();
        baseStageForumPage = new BaseStageForumPage();
        stageForumHomePage = new StageForumHomePage();
        createNewTopicView = new CreateNewTopicView();
        allTopicsPage = new AllTopicsPage();
        alphaPreparationPage = new AlphaPreparationPage();
        openAndLikeSpecificTopicPage = new OpenAndLikeSpecificTopicPage();


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

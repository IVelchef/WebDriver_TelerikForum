package stagetelerikforumtests.web;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stagetelerikforumtests.core.ForumBaseTest;
import stagetelerikforumtests.unums.ForumTestData;

public class ForumCreateNewTopicTests extends ForumBaseTest {
    private String newTopicTitle;

    @BeforeEach
    public void beforeTest(){
        stageForumLoginPage.navigate();
        stageForumLoginPage.submitLoginForm(ForumTestData.username.getValue(), ForumTestData.password.getValue());

    }

    @Test
    public void createNewTopicTest () {

        stageForumHomePage.waitForPageTitle();
        stageForumHomePage.checkElementVisibility();
        stageForumHomePage.assertNavigated();

        createNewTopicView.checkElementVisibility();
        createNewTopicView.assertNavigated();
        createNewTopicView.createNewTopic();
        newTopicTitle = createNewTopicView.getNewTopicTitle();


        allTopicsPage.navigate();

        boolean isTopicCreated = allTopicsPage.validateNewTopicCreated(newTopicTitle);
        Assertions.assertTrue(isTopicCreated, "Error - Topic created but not found in latest topic");



        stageForumHomePage.logout();

    }
}
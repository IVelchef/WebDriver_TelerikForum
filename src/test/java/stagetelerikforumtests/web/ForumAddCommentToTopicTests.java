package stagetelerikforumtests.web;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stagetelerikforumtests.core.ForumBaseTest;
import stagetelerikforumtests.unums.ForumTestData;

public class ForumAddCommentToTopicTests extends ForumBaseTest {

    @BeforeEach
    public void beforeTest(){
        stageForumLoginPage.navigate();
        stageForumLoginPage.submitLoginForm(ForumTestData.username.getValue(), ForumTestData.password.getValue());

    }

    @Test
    public void createNewCommentToTopic () {


        stageForumHomePage.waitForPageTitle();
        stageForumHomePage.checkElementVisibility();
        stageForumHomePage.assertNavigated();


        alphaPreparationPage.navigate();

        alphaPreparationPage.addReplyToTopic();

        alphaPreparationPage.navigate();
        boolean isCommentPresent = alphaPreparationPage.validateCommentIsVisible();

        Assertions.assertTrue(isCommentPresent, "The comment was not found in the topic.");


        stageForumHomePage.logout();

    }
}

package stagetelerikforumtests.web;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stagetelerikforumtests.core.ForumBaseTest;
import stagetelerikforumtests.unums.ForumTestData;

public class ForumLikeSpecificTitle extends ForumBaseTest {

    @BeforeEach
    public void beforeTest(){
        stageForumLoginPage.navigate();
        stageForumLoginPage.submitLoginForm(ForumTestData.username.getValue(), ForumTestData.password.getValue());

    }


    @Test
    public void likeSpecificTopic () {

        stageForumHomePage.waitForPageTitle();
        stageForumHomePage.checkElementVisibility();
        stageForumHomePage.assertNavigated();

        openAndLikeSpecificTopicPage.navigate();

        openAndLikeSpecificTopicPage.LikeTheTopic();

        Assertions.assertTrue(openAndLikeSpecificTopicPage.getLikeButtonTitle().equals("you've liked this post") ||
                openAndLikeSpecificTopicPage.getLikeButtonTitle().equals("undo like") ||
                openAndLikeSpecificTopicPage.getLikeButtonTitle().equals("you liked this post"), "Error");


        stageForumHomePage.logout();

    }

    @Test
    public void unlikeSpecificTopic () {

        stageForumHomePage.waitForPageTitle();
        stageForumHomePage.checkElementVisibility();
        stageForumHomePage.assertNavigated();


        openAndLikeSpecificTopicPage.navigate();

        openAndLikeSpecificTopicPage.LikeTheTopic();

        Assertions.assertTrue(openAndLikeSpecificTopicPage.getLikeButtonTitle().equals("like this post"), "Error");

        stageForumHomePage.logout();

    }




}

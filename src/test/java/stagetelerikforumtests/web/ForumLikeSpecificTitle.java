package stagetelerikforumtests.web;
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

        allTopicsPage.navigate();

        openAndLikeSpecificTopicPage.navigate();
        openAndLikeSpecificTopicPage.openSpecificTopic();

        openAndLikeSpecificTopicPage.LikeTheTopic();

        openAndLikeSpecificTopicPage.unLikeTheTopic();




        stageForumHomePage.logout();

    }




}

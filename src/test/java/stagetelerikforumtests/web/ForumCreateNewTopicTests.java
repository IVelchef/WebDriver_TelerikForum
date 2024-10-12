package stagetelerikforumtests.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stagetelerikforumtests.core.ForumBaseTest;
import stagetelerikforumtests.unums.ForumTestData;

public class ForumCreateNewTopicTests extends ForumBaseTest {

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

    stageForumHomePage.logout();


    }
}

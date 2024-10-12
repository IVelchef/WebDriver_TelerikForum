package stagetelerikforumtests.web;
import org.junit.jupiter.api.Test;
import stagetelerikforumtests.core.ForumBaseTest;
import stagetelerikforumtests.unums.ForumTestData;

public class ForumLoginTest extends ForumBaseTest {

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {

        stageForumLoginPage.navigate();

        stageForumLoginPage.submitLoginForm(ForumTestData.username.getValue(), ForumTestData.password.getValue());

        stageForumHomePage.checkElementVisibility();
        stageForumHomePage.assertNavigated();

        // Navigate to Log out menu
        stageForumHomePage.logout();





    }
}

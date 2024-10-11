package stagetelerikforumtests.unums;

import java.util.UUID;

public enum ForumTestData {

    username ("ivanvelchev2105@gmail.com"),
    password ("Vanio143276"),
    jiraProjectName(""); //There is no need to fill in, it is reduced automatically.

    private  String value;


    ForumTestData(String probName) {
        this.value = probName;
    }
    public String getValue() {
        return value;
    }

    public void setProjectName(String projectName) {
        this.value = projectName;
    }

    public static String generateRandomProjectName() {
        return "Defect Management-" + UUID.randomUUID().toString();
    }
}

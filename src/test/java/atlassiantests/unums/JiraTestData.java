package atlassiantests.unums;

import java.util.UUID;

public enum JiraTestData {
    username ("ivan.velchev.a61@learn.telerikacademy.com"),
    password ("Voltran143276"),
    jiraProjectName("");

    private  String value;


    JiraTestData(String probName) {
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


package stagetelerikforumtests.unums;

import java.util.UUID;

public enum ForumTestData {

    username ("ivan.velchev.a61@learn.telerikacademy.com"),
    password ("Vanio143");


    private  String value;


    ForumTestData(String probName) {
        this.value = probName;
    }

    public String getValue() {
        return value;
    }
}

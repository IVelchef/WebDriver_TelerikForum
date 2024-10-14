package stagetelerikforumtests.unums;

import java.util.UUID;

public enum ForumTestData {

    username ("ivanvelchev2105@gmail.com"),
    password ("Vanio143276");


    private  String value;


    ForumTestData(String probName) {
        this.value = probName;
    }

    public String getValue() {
        return value;
    }
}

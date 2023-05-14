package model;

public class Novel extends Book {
    private static final String type = "Novel";

    public Novel(String title) {
        super(title);
        this.setType(type);
    }


}

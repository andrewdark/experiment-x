package ua.pp.darknsoft.dto;

public class TestTO {
    private String name;

    private String content;

    public String getName() {
        return name;
    }
    public TestTO setName(String testName) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }
    public TestTO setContent(String content) {
        this.content = content;
        return this;
    }
}
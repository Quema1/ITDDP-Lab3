package org.example.fitnessClub.additions;

public class SearchParams {
    private String pattern;
    private String author;

    public SearchParams(String pattern, String author) {
        this.pattern = pattern;
        this.author = author;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

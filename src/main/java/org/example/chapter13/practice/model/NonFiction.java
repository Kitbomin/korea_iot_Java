package org.example.chapter13.practice.model;

import lombok.Getter;

@Getter

public class NonFiction extends Book {
    private String field; //교과, 수험서...

    public NonFiction (String id, String title, String author, String field) {
        super(id, title, author);
        this.field = field;
    }

    @Override
    public String toString() {
        return super.toString() + ", Field: " + field;
    }
}

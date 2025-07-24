package org.example.chapter16.practice.entity;

public enum Category {
    FICTION, NONFICTION, SCIENCE, HISTORY, FANTASY;

    public static Category fromString(String value) {
        try {
            return Category.valueOf(value);

        }catch (IllegalArgumentException e) {
            // 인자와 일치하지 않은 값을 주면 발생하는 오류 ->  valueOf에 value 말고 다른 값 넣으면 발생함
            throw new IllegalArgumentException("Invalid category: " + value);
        }
    }
}

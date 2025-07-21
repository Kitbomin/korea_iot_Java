package org.example.chapter13.practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor //필드값 전부를 매개변수로 가지는 생성자를 만들어주는 어노테이션
@ToString //안에 있는 정보를 확인할 친구
@Getter // 데이터를 하나씩 뽑아줄거임

public abstract class Book {
    //추상클래스: 생성자를 가질 수 있음 -> 직접적인 인스턴스화는 되지 않음. 하위 클래스 생성자 내에서 호출 용도로 정의하는 용도임
    private String id;
    private String title;
    private String author;

    //인터페이스는 직접적인 인스턴스화는 불가능함. 그리고 생성자를 못가짐

}

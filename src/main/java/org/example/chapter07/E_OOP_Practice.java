package org.example.chapter07;

// == 도서 관리 시스템 == //
// : 책의 정보를 저장, 책의 상태(대여가능 여부) 책의 정보 출력

//1) Book 클래스:
class Book {
    // 속성 - title(String, 불변성), author(String, 불변성), isAvailable(boolean)
    private final String title;
    private final String author;
    private boolean isAvailable;

    // 생성자 - 매개변수 -> title, author
    Book(String title, String author) {
        this.title = title;
        this.author = author;
        isAvailable = true;
    }

    // 메서드 - borrowBook(), returnBook(), displayInfo()
    //책 대여
    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("책 대여가 성공적으로 완료됨");
        } else {
            System.out.println("현재 대여 중임 (대여 불가)");
        }
    }

    //책 반납
    void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("책 반납이 성공적으로 완료됨");
        } else {
            System.out.println("이미 반납된 상태임 (반납 불가)");
        }
    }

    //정보
    void displayInfo() {
        System.out.println("제목: " + title + "저자: " + author +
                "대여가능 여부: " + (isAvailable ? "대여가능" : "대여 중"));

    }

    // 캡슐화를 위한 getter 메서드 추가
    public String getTitle () { return title; }
    public String getAuthor () { return author; }
    public boolean isAvailable() { return isAvailable; }
    //얘는 get을 왜 안쓸까...=> boolean 이라서 => getter를 쓸 때에도 boolean 데이터는 get 키워드 작성을 권장하지 않음



}

// 2) EBook 클래스 - Book클래스 상속
class EBook extends Book {

    /*
        EBook() {
            super();
        }
        이게 생략되어있을거임
     */

    // 속성 = fileSize(double)
    private double fileSize;


    // 생성자 = EBook(title, author, fileSize)
    EBook(String title, String author, double fileSize) {
        super(title, author);
        this.fileSize = fileSize;
    }

    // 메서드 = isplayInfo() -> 재정의, fileSize
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("파일 크기: " + fileSize + "MB");
    }

    double getFileSize() {
        return fileSize;
    }
}


public class E_OOP_Practice {
    public static void main(String[] args) {
        //Book 객체생성
        Book book1 = new Book("자바는 ...", "이승아");
        book1.displayInfo();
        book1.borrowBook();
        book1.displayInfo();
        book1.borrowBook();

        book1.returnBook();
        book1.returnBook();

        EBook eBook1 = new EBook("스프링부트는.....", "이ㄷ겸", 131.23);
        eBook1.displayInfo();

        eBook1.borrowBook();
        eBook1.returnBook();
    }
}

package org.example.chapter12;

/**
 * === MVC 패턴 ===
 * : Model, View, Controller
 * - 사용자가 인터페이스(UI)를 설계하는 소프트웨어 디자인 패턴 중 하나
 * - 세가지 구성 요소로 나뉘어 개발을 진행(역할 분담)
 *
 * 디자인 패턴: 소프트웨어 디자인 과정에서 자주 발생하는 문제들에 대한 일반적인 해결책
 * 1. Model
 *  : 애플리케이션의 데이터와 비즈니스 로직을 담당
 *  - DB, 파일 시스템, 외부 서비스와의 통신을 통해 데이터를 저장하고 검색
 *  - 상태 변경에 대해 View와 Controller 에게 알릴 수 있는 매커니즘을 제공
 *    >> view와 Controller의 세부 구현사항으로 부터 독립적임
 *
 * 2. View
 *  : 사용자에게 데이터를 표시하는 방법을 정의
 *  - Model의 정보를 표시, 사용자 액션을 Controller 에게 전달함
 *  - Model이 가진 정보를 사용자가 이해할 수 있는 형태로 변환
 *
 * 3. Controller
 *  : 사용자의 입력을 처리하고, Model과 View 사이의 상호작용을 관리함
 *  - 사용자의 입력에 반응해 Model을 업데이트하고, 필요한 경우 view를 새롭게 출력
 *
 * MVC 패턴 장점
 * - 역할 분담이 가능
 *   :각 구성 요소가 독립적인 기능을 책임짐 > 코드관리와 확장이 용이해짐
 *
 * - 유지보수가 용이함
 *   : 애플리케이션의 비즈니스 로직과 사용자 인터페이스(User Interface) 가 분리되어 유지보수가 쉬움
 *
 *
 * MVC 패턴 단점
 * - 복잡성이 증가함
 *  : 간단한 애플리케이션 구현에는 MVC 패턴 구조가 복잡성을 증가시킴
 *
 * - 학습 곡선이 높다
 *  : 이해하고 사용하기까지의 일정한 학습이 필요함
 *
 * MVC 패턴 작동원리
 * - View >> Controller >> Model >> Controller >> View
 *
 * +) 스프링: 자바 기반 웹 프레임워크 >> Spring Boot (Spring MVC 내장)
 *
 *
 * */

// - 학교 급식 시스템 - //
// Model: 급식표(데이터) - 급식 메뉴가 적힌 종이
// View: 칠판(화면) - 학생들이 확인하는 곳
// Controller(컨트롤러) - 영양사 쌤 - 급식표 내용을 업데이트, 칠판에 알려주는 역할

// MVC 동작 흐름
// 학생 (사용자) >> View(화면 클릭) >> Controller(영양사) >> Model(급식표) >>
// Controller >> View >> 화면 출력

// 1. Model
class Lunchmenu {
    private String menu;

    public String getMenu() {return menu;}
    public void setMenu(String menu) {this.menu = menu;}
}

//2. View
class LunchView {
    public void displayMenu(String menu) {
        if (menu == null || menu.isEmpty()) {
            System.out.println("오늘 급식은 없어요");
        } else {
            System.out.println("오늘 급식 메뉴는: " + menu);
        }
    }
}

//3. Controller
class LunchController {
    private Lunchmenu model;
    private LunchView view;

    public LunchController(Lunchmenu model, LunchView view) {
        this.model = model;
        this.view = view;
    }

    public void setLunchMenu(String menu) {
        model.setMenu(menu);
    }

    public void updateView() {
        String menu = model.getMenu();
        view.displayMenu(menu);
    }

    public void studentRequestMenu () {
        System.out.println("[학생 요청] 오늘 급식 무에용");
        updateView();
    }

}

public class MVC {
    public static void main(String[] args) {
        // == 학교 급식 시스템 == //
        Lunchmenu menu = new Lunchmenu();
        LunchView view = new LunchView();

        LunchController controller = new LunchController(menu, view);

        controller.studentRequestMenu();

        controller.setLunchMenu("김밥, 떡볶이, 콜라");
//        controller.updateView();
        controller.studentRequestMenu();

        controller.setLunchMenu("김밥, 매운 떡볶이, 콜라");
        controller.updateView();

        controller.setLunchMenu("");
        controller.studentRequestMenu();

    }
}

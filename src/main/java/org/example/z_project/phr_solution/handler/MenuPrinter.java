package org.example.z_project.phr_solution.handler;

public class MenuPrinter {
    public static void displayMenu() {
        System.out.println("\n[ 메뉴 선택 ]");

        System.out.println("1. 환자 등록");
        System.out.println("2. 환자 정보 전체 조회");
        System.out.println("3. 환자 정보 단건 조회");
        System.out.println("4. 환자 정보 수정");
        System.out.println("5. 환자 정보 삭제");

        System.out.println("6. 건강 기록 추가");
        System.out.println("7. 건강 기록 조회");
        System.out.println("8. 건강 기록 필터링");
        System.out.println("9. 건강 기록 삭제");

        System.out.println("10. 프로그램 종료");

        System.out.print("메뉴를 선택하세요 >> ");
    }
}

package org.example.chapter10.practice01;

// Inventory: 재고관리
// 여기서 실질적으로 실행이 됨

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InventorySystem {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager(); //도서관리 시스템을 인스턴스 화 시킴
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(" === Inventory System === ");
            System.out.println("1. Create 책 추가");
            System.out.println("2. Read 전체 책 조회");
            System.out.println("3. Update 책 수정(재고)");
            System.out.println("4. Delete 책 삭제");
            System.out.println("5. 책 통합 검색");
            System.out.println("6. 책 카테고리 검색");
            System.out.println("7. 책 가격 검색");
            System.out.println("0. 프로그램 종료합니다아");

            //여기서 왜 try가 나오죠? => 얘도 조건식 처럼 쓸 수 있어야함...
            try {
                // sc.nextLine(); => 입력값이 문자열로 인식됨. 이 문자열을 다시 정수 참조형으로 만들어서 choice 에 넣을거임
                // Integer.parseInt(A) => A값을 분석해 Integer 형태로 변경 -> 숫자형태로 변경할 수 없는 값이 입력되는 경우 NumberFormatException이 발생함
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        // 책 추가
                        System.out.println("Enter Book ID ");
                        String id = sc.nextLine();
                        System.out.println("Enter Book Title: ");
                        String title = sc.nextLine();
                        System.out.println("Enter Book ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.println("Enter Book Author ");
                        String author = sc.nextLine();
                        System.out.println("Enter Book Publisher: ");
                        String publisher = sc.nextLine();
                        System.out.println("Enter Book Category: ");
                        String category = sc.nextLine();

                        System.out.println("Enter Book Publish Year: ");
                        int year = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter Book Price: ");
                        int price = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter Book Stock: ");
                        int stock = Integer.parseInt(sc.nextLine());

                        manager.add(new Book(id, title, isbn, author, publisher, year, price, stock,  category));
                        break;


                    case 2:
                        manager.listAll();
                        break;

                    case 3:
                        System.out.println("Enter Book ID to update stock: ");
                        String updateId = sc.nextLine();
                        System.out.println("Enter Quantity to add/subtract: ");
                        int quantity = Integer.parseInt(sc.nextLine());

                        manager.updateStock(updateId, quantity);
                        break;

                    case 4:
                        System.out.println("Enter Book Id to remove: ");
                        String removedId = sc.nextLine();
                        manager.remove(removedId);
                        break;

                    case 5:
                        System.out.println("검색어를 입력하세용: ");
                        String keyword = sc.nextLine();

                        List<Item> searchResults = manager.search(keyword);
                        if (searchResults.isEmpty()) {
                            System.out.println("이 키워드로 못찾아용" + keyword);
                        } else {
                            for (Item item: searchResults) {
                                item.display();
                            }
                        }
                        break;

                    case 6:
                        System.out.println("카테고리를 입력하세용: ");
                        String searchCategory = sc.nextLine();

                        List<Item> categoryResults = manager.search(searchCategory);
                        if (categoryResults.isEmpty()) {
                            System.out.println("이 카테고리로 못찾아용" + searchCategory);
                        } else {
                            for (Item item: categoryResults) {
                                item.display();
                            }
                        }
                        break;

                    case 7:
                        System.out.println("최소 가격을 입력해요: ");
                        int minPrice = Integer.parseInt(sc.nextLine());
                        System.out.println("최대 가격을 입력해요: ");
                        int maxPrice = Integer.parseInt(sc.nextLine());

                        List<Item> priceResults = manager.searchByPriceRange(minPrice, maxPrice);

                        if (priceResults.isEmpty()) {
                            System.out.println("이 가격으로는 못찾아용 "  );
                        } else {
                            for (Item item: priceResults) {
                                item.display();
                            }
                        }

                    case 0:
                        System.out.println("종료할래요? 그럼 y를 눌러줘용ㅇ");
                        if (sc.nextLine().equalsIgnoreCase("y")) {
                            System.out.println("종료해용");
                            sc.close();
                            return; //메서드의 종료 -> while문 탈출
                        }
                        System.out.println("다시 입력해줘요");
                        break; // 스위치문 탈출한거지 while 문을 탈출한게 아님

                    default:
                        System.out.println("유효하지 않은 선택이에요! 다시 시도해주셔용ㅇ");
                }

            } catch (NumberFormatException e) {
              // 숫자 형태의 입력이 아닌 경우 발생
                System.out.println("Please Enter a valid number");
            } catch (NoSuchElementException e) {
                //컬렉션에서 요소를 가져올 때 해당 요소가 없는 경우 발생하는 예외
                //- 존재하지 않는 것을 가져올 때 발생
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

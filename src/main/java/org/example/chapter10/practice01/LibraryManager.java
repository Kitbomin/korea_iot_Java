package org.example.chapter10.practice01;

//실제 도서 관리 기능을 수행
// 관리할 행동을 구현

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LibraryManager implements Manageable {

    // 책 저장 공간 (ArrayList - 중복 O, 순서 보장 O, / 조회가 빠름 - Linked보다 빠르잖음)
    private List<Item> items = new ArrayList<>();


    @Override
    public void add(Item item) {
        items.add(item);
        System.out.println("Item added: " + item.getName());
    }

    @Override
    public void remove(String id) {
        // 삭제여부 확인용 boolean 데이터
        boolean removed = false;

        // 인덱스 번호를 사용해 요소제거 : 일반 for 문 사용, 초기화 변수 == 인덱스 번호 로 설정
        int size = items.size();

        for (int i = 0; i<size; i++) {
            //전체 items를 순회: 각 순번의 item의 id와 매개변수의 id가 일치 한다면 -> 해당 인덱스 요소 제거
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                removed = true;
                System.out.println("Item with ID: " + id + " removed");

                break;
            }
        }

        if (!removed) {
            //제거된 요소가 없다면
            System.out.println("No Item found with ID");
        }
    }

    @Override
    public void updateStock(String id, int quantity) {
        for (Item item: items) {
            if (item.getId().equals(id) && item instanceof Book) {
                // 이건 다른형식
                // Book selectedBook = (Book)item;

                ((Book) item).updateStock(quantity); //다운캐스팅 + 형변환까지
                //selectedBook.updatedStock(quantity)

                System.out.println("Stock updated for ID: " + id + ", Stock: " + ((Book) item).getStock());
                //("Stock updated for ID: " + id + ", StockL " + selectedBook.getStock();)
            }
        }
    }

    @Override
    public void listAll() {
        // 전체 조회: isEmpty() 로 요소값이 존재하는 지 확인 후 로직 처리
        if (items.isEmpty()) {
            System.out.println("No Items In The Library");
        } else {
            System.out.println(" == library Items == ");
            for (Item item: items) {
                item.display();
            }
        }
    }

    @Override
    public List<Item> search(String keyword) {
        // 전체 리스트의 요소에서 키워드 검색을 시행: name, author, publisher, ... 통합검색 -> 모든 키워드로!

        List<Item> foundItems = new ArrayList<>(); // 검색된 도서 정보들이 필터링된 애들이 저장될 리스트
        for (Item item: items){
            if (item.getName().contains(keyword)
            || (item instanceof Book
                    && ((Book)item).getAuthor().contains(keyword)
                    ||((Book)item).getPublisher().contains(keyword))
            ) {
                foundItems.add(item);

            }

        }

        if (foundItems.isEmpty()){
            throw new NoSuchElementException("키워드로 못찾겟엉요: " + keyword);
        }

        return List.of();
    }

    @Override
    public List<Item> searchByCategory(String category) {
        List<Item> result = new ArrayList<>();

        for (Item item: items) {
            if (item instanceof Book
                    && ((Book)item).getCategory().equalsIgnoreCase(category) // 대소문자를 구분하지 않고 데이터의 값을 비교할 수 있음 -> 영어만 사용 가능
             ) {
                result.add(item);
            }
        }

        if (result.isEmpty()) {
            throw new NoSuchElementException("카테고리 결과가 없어용ㅇ");
        }

        return result;
    }

    @Override
    public List<Item> searchByPriceRange(int minPrice, int maxPrice) {
        List<Item> result = new ArrayList<>();
        for (Item item: items) {
            if (item instanceof Book) {
                int price = ((Book)item).getPrice();

                if (price >= minPrice && price <= maxPrice) {
                    result.add(item);
                }
            }
        }

        if (result.isEmpty()) {
            throw new NoSuchElementException("가격을 못찾게성ㅇ요");
        }

        return result;
    }
}

package org.example.chapter15;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * == 정렬의 다양한 형태 ==
 *
 * 1. 불변성 데이터: Stream API 사용
 *    목적) 원본 리스트를 변경하지 않고, 정렬된 새로운 리스트만 필요 시 사용
 *    Ex)  클라이언트 응답용 DTO 리스트 정렬 시
 *         응답용 DTO?
 */


@Getter
@AllArgsConstructor
class Product {
    private int price;
}

class ProductRepository {
    List<Product> findAll () {
        return new ArrayList<>(List.of(
                new Product(15),
                new Product(10),
                new Product(20),
                new Product(21),
                new Product(9)
        ));
    }
}

//제품과 관련된 비즈니스 로직을 수행하는 클래스
//CRUD + 필터링 / 통계
// -> 가격 기준으로 정렬 조회
class ProductService {
    ProductRepository productRepository = new ProductRepository();


    // 생성
    void createProduct(){}

    // 수정
    void updateProduct(){}

    // 가격 기준으로 정렬된 새로운 리스트 반환(원본은 변경되지 않음)
    List<Product> getProductsSortedByPrice() {
        List<Product> products = productRepository.findAll();

        //stream().sorted() 는 중간연산
        //: 원본을 그대로 두고, 가공된 결과를 생성함
        // - 불변 데이터 처리에 유리하고, 클린 코드 작성에도 적합함
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }
}

/**
 * 2. 원본 리스트 자체 정렬 시
 *    - List.sort() 또는 Collections.sort()
 *    목적) 원본 데이터를 직접 수정해서 정렬 순서를 유지해야하는 경우
 *    Ex)  캐시된 리스트, 재사용 리스트, 통계 계산용 리스트 등에 사용
 *          >> 데이터베이스나 외부 API에서 자주 조회되는 데이터를 미리 리스트에 저장해두고 필요 시 다시 원본을 가져오지 않고 빠르게 읽어오는 용도
 */

@AllArgsConstructor
class Post {
    private String title;
}

class PostRepository {
    List<Post> cashedPopularPosts() {
        //DB SQL을 통해 정렬된 데이터를 반환해 가져온 상태라 가정
        return new ArrayList<>(List.of(
                new Post("인기 1"),
                new Post("인기 2"),
                new Post("인기 3"),
                new Post("인기 4"),
                new Post("인기 5")
        ));
    }
}

class PostService {
    PostRepository postRepository = new PostRepository();
    private List<Post> cashedPopularPosts;

    public List<Post> getPopularPosts() {
        if (cashedPopularPosts == null) {
            //DB에서 인기게시글 조회
            cashedPopularPosts = postRepository.cashedPopularPosts();
        }
        //한 번 불러온 후 매번 DB 조회를 하지 않고 재사용
        return cashedPopularPosts;
    }

    public void refreshPopularPostsCache() {
        //필요할 때 갱신
        cashedPopularPosts = postRepository.cashedPopularPosts();
    }
}




public class B_Sort {
    public static void main(String[] args) {

    }
}

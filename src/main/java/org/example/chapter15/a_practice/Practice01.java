package org.example.chapter15.a_practice;

// == 주문 목록에서 상품별 총 판매량 계산 == //

// 주문 클래스

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
@AllArgsConstructor
class Order {
    private String product;
    private int quantity;

}



public class Practice01 {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("노트북", 5),
                new Order("핸드폰", 6),
                new Order("태블릿", 1),
                new Order("스마트워치", 3),
                new Order("핸드폰", 5),
                new Order("이어폰", 2),
                new Order("노트북", 7),
                new Order("태블릿", 1)
        );

        // == 상품 별 총 판매량 계산 == //
        // 1) 각 상품 별 그룹화(분리)
        // 2) 해당 데이터에서 그룹화 된 요소의 quantity를 모두 더함 - summingInt() >> 총 판매량이 계산됨

        Map<String, Integer> productSales =
                orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct, //키값
                                Collectors.summingInt(Order::getQuantity)) //Value
                );

        System.out.println(productSales);



    }
}

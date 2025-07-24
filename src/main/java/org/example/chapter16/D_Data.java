package org.example.chapter16;

/**
 * === DTO, VO, DAO, Entity ===
 * : 데이터를 목적에 따라 정의하는 구조
 *
 * 1. DTO(Data Transfer Object)
 *  : 데이터를 전달하기 위한 객체(요청과 응답에 따라 데이터를 주고받을 때)
 *
 * 2. VO(Value Object)
 *  : 값 자체를 표현하는 객체
 *
 * 3. DAO(Data Access Object)
 *  : 데이터 베이스에 접근하는 역할을 하는 객체
 *
 * 4. Entity
 *  : 실제 DB 테이블과 매핑되는 클래스
 */

import lombok.*;
import java.util.Date;

/*
 * 1. DTO
 *  : 계층 간 데이터 교환을 위해 사용하는 객체
 *  - 로직을 가지지 않는 순수한 데이터 객체(비즈니스 로직 X, Getter & Setter 만 존재)
 *  - 요청(Request) 과 응답(Response) 객체로 구분해 사용한다.
 */
@Getter @Setter
@NoArgsConstructor //많이 사용은 함
@AllArgsConstructor
class UserSignInRequestDto {
    //로그인을 위한 요청값
    private String userId;
    private String password;
}



/*
 * 2. VO
 *  : 특정 값을 표현하는 객체
 *  - 주로 사용자 주소, 이름, 좌표 등 도메인에서 의미 있는 값을 표현함
 *  - 불변성을 가짐 (읽기 전용 -> 데이터를 담는 용도로 보통 쓰임) : 생성 시 내용 변경 불가함
 *      >> 주로 필드값을 final, Getter만 가짐
 *
 *  데이터 식별 값이 필요없음 -> 식별이 목적이 아닌 값 자체의 중요도를 보기 위해
 *  동일성 보다 동등성이 중요함 -> 데이터랑 1:1 매칭이 되는지(주소 값까지 동일할 필요 없음 내용값이 같으면 됨)
 *  VO는 값이 같으면 동일한다 봄
 */
@AllArgsConstructor @Getter
@EqualsAndHashCode//이게 머꼬 ->
class Address {
    private final String city;
    private final String zipcode;
}



/*
 * 3. DAO
 *  : 데이터 베이스 접근 객체
 *  - 서비스 모델과 데이터베이스를 연결하는 역할을 담당함
 *  - DB에 접근해 CRUD 작업을 담당함
 *
 *  >> 일반적으로 JDBC, JPA, MyBatis를 통해 구현됨
 *  >> Spring 기반 프로젝트에서 Repository 또는 Wrapper로 대체되는 경우가 많음
 *
 *  실질적인 로직은 DAO 대신에 JPA의 interface를 사용함
 */
// JDBC 기반(Java + DB)
@AllArgsConstructor
class UserResponseDto{
    String id;
    String nickname;
}
class UserDao {
    // 로그인 시 userId로 정보 조회
    public UserResponseDto getUserById (String userId) {
        // DB에 접근해 해당 userId 사용자의 닉네임을 조회했다고 가정
        String id = "qwe";
        String nickname = "개구리";

        return new UserResponseDto(id, nickname);
    }
}


/*
 * 4. Entity
 *  : 실제 데이터 베이스의 테이블에 해당하는 데이터 구조와 매핑되는 클래스
 *  - JPA(Java Persistence API)와 같은 ORM(Object-Related Mapping) 툴에서 사용
 *  - DB의 각 레코드와 매핑됨
 *
 *  > @Entity, @Id, @Colum 등을 사용
 */
@Getter @Setter
//@Entity @Table(name = "users") => 이런걸 할 수 ㅣㅇㅆ다
class User {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private Date createdAt; //해당 데이터가 생성된 일시 - 회원가입 날짜
}


public class D_Data {
    public static void main(String[] args) {

    }
}

package org.example.chapter15.c_board_app.dto;

//BoardResponseDto
// DB 게시판 데이터 중 사용자에게 응답으로 전달할 객체구조
// -content 값을 제외한 필드 제공

import lombok.ToString;
import org.example.chapter15.c_board_app.entity.Board;

@ToString
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;


    //생성자를 따로 만드는 이유 ->
    public BoardResponseDto(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }

    public static BoardResponseDto fromEntity(Board board){
        return new BoardResponseDto(board);
    }

}

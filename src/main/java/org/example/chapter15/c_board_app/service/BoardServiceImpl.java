package org.example.chapter15.c_board_app.service;

import org.example.chapter15.c_board_app.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.dto.BoardResponseDto;
import org.example.chapter15.c_board_app.entity.Board;
import org.example.chapter15.c_board_app.repository.BoardRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoardServiceImpl implements BoardService {
    private final BoardRepository repository;

    // 생성자 주입 방식
    public BoardServiceImpl() {
        this.repository = new BoardRepository();
    }



    @Override
    public void createBoard(BoardRequestDto dto) {
        // dto 객체에서 인스턴스 메서드 호출
        Board board = dto.toEntity();
        repository.save(board);
    }

    @Override
    public List<BoardResponseDto> findAllBoards() {
        List<Board> boardList = repository.findAll();

        //게시판 데이터를 응답 객체로 변환
        List<BoardResponseDto> boardResponseDtos = boardList.stream()
//                .map(board -> BoardResponseDto.fromEntity(board))
                .map(BoardResponseDto::fromEntity)
                .collect(Collectors.toList());

        return boardResponseDtos;
    }

    @Override
    public BoardResponseDto findBoardById(Long id) {

        // 이렇게 하는 이유는 Optional<Board>를 Optional<BoardResponseDto>로 변환하는 작업
        // : 변환 작업 시 내부 데이터가 null인 경우 Exception 발생
        Optional<Board> board = repository.findById(id);

        // 이 id에 아직 데이터가 존재할 지는 모름 -> 그래서 예외처리
        BoardResponseDto boardResponseDto = board.map(BoardResponseDto::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 게시글을 찾을 수 없습니다."));

        return boardResponseDto;
    }

    @Override
    public void updatedBoard(Long id, BoardRequestDto dto) {
        Board existingBoard = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 게시글을 찾을 수 없습니다."));

        //만약 id가 존재한다면?
        existingBoard.setTitle(dto.getTitle());
        existingBoard.setContent(dto.getContent());
    }

    @Override
    public void deleteBoard(Long id) {

        if (!repository.findById(id).isPresent()) {
            // 해당 id의 데이터가 존재하지 않을 경우
            throw new IllegalArgumentException("해당 id의 게시글을 찾을 수 없습니다.");
        }

        repository.delete(id);

    }
}

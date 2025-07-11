package org.example.chapter10;

// === 이벤트 관리 시스템 === //
// : 이벤트 참가자 명단 & 대기열 관리를 위한 시스템
// - 참가자는 사전 등록된 명단(사용자 하나씩 뽑아오는게 좋음)을 통해 이벤트 참가
// - 명단이 가득 찰 경우 대기열 추가 -> 참가자가 떠나면 대기열의 다음 사람이 추가됨 -> 큐를 쓰자용

// 1) 이벤트 참가자 명단 관리: 사전 등록, 당일 추가 참가자 등록은 안됨 -> 데이터는 고정값, 조회만 됨 => 그래서 ArrayList를 쓸거임
//    => 참가자에 대한 조회 기능만 가능

// 2) 대기열 관리자: 이벤트의 한정된 좌석, 좌석이 모두 차면 추가 참가자는 대기열에 등록됨
//    -> LinkedList사용, 목록의 추가 삭제 횟수가 많음 => 참가자 조회는 딱히 안할거임

import java.util.ArrayList;
import java.util.LinkedList;

class EventManagement {
    //필드 선언
    ArrayList<String> participantList = new ArrayList<>();
    LinkedList<String> waitingQueue = new LinkedList<>();

    //메서드 선언
    void addParticipant(String name) {
        participantList.add(name);
    }

    void addToWaitingQueue(String name) {
        waitingQueue.add(name);
    }

    void leaveParticipant(String name) {
        // 대기열의 인원이 존재해야만 대기열 인원을 참가자 명단에 추가 가능
        // : 대기열 크기(.size > 0)이어야함

        if (waitingQueue.size() > 0) {
            String newParticipant = waitingQueue.remove(0); //대기열 제거
            addParticipant(newParticipant); //참가자 명단에 추가됨
        }

    }

    boolean checkParticipant(String name) {
        return participantList.contains(name);
    }
}

public class C_ListPractice {
    public static void main(String[] args) {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addParticipant("가가가");
        eventManagement.addParticipant("나나나");
        eventManagement.addParticipant("다다다");
        eventManagement.addParticipant("라라라");
        eventManagement.addParticipant("마마마");

        eventManagement.addToWaitingQueue("바바바");
        eventManagement.addToWaitingQueue("사사사");
        eventManagement.addToWaitingQueue("아아아");
        eventManagement.addToWaitingQueue("자자자");

        System.out.println("참가자 명단" + eventManagement.participantList);
        System.out.println("대기자 명단" + eventManagement.waitingQueue);

        eventManagement.addToWaitingQueue("차차차");
        eventManagement.addToWaitingQueue("카카카");
        eventManagement.addToWaitingQueue("타타타");

        eventManagement.leaveParticipant("가가가");
        eventManagement.leaveParticipant("나나나");
        eventManagement.leaveParticipant("다다다");

        System.out.println("new 참가자" + eventManagement.participantList);

        System.out.println(eventManagement.waitingQueue);

        System.out.println(eventManagement.checkParticipant("아아아"));
        System.out.println(eventManagement.checkParticipant("자자자"));
        System.out.println(eventManagement.checkParticipant("차차차"));
        System.out.println(eventManagement.checkParticipant("카카카"));
    }
}

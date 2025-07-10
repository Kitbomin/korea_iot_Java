package org.example.chapter05;

//
class BaseBallPlayer {
    // === 인스턴스 변수 ===

    // 선수 이름(name -  문자열)
    String name;
    // 타율(battingAverage - 실수)
    float battingAVG;
    // 홈런 수(homeRuns - 정수)
    int homeRuns;

    // === 정적(클래스) 변수 ===: 생성된 선수의 총 인원(playerCount - 정수)
    static int playerCount;
    // >> 모든 인스턴스에서 공유




    // == 생성자 ==
    // +) 필드값 초기화
    BaseBallPlayer(String name, float battingAVG, int homeRuns) {
        this.name = name;
        this.battingAVG = battingAVG;
        this.homeRuns = homeRuns;
        //정적 변수 후위 증가
        playerCount++;
    }


    // 1) 인스턴스 메서드
    // : double newBattingAverage, int newHomeRuns 값을 전달 받아 각각의 타율과 홈런 수를 업데이트
    void updateStatus(float newBattingAVG, int newHomeRuns) {
        battingAVG = newBattingAVG;
        homeRuns = newHomeRuns;
    }

    // 2) 정적 메서드: 특정 홈런 수 이상인 선수를 평가
    static String evaluateHomeRun (int homeRunCount) {
        // : 홈런 수가 20개 이상이면 "홈런상 후보! 축하드립니다!"
        if (homeRunCount > 20) {
            return "홈런상 후보! 축하축하";

        }else {
            // : 미만일 경우 "홈런상 후보에 등록될 수 없습니다." 반환
            return "홈런상 후보 등록 안됨";
        }

    }


}

public class E_Practice {
    public static void main(String[] args) {

        //인스턴스 생성
        BaseBallPlayer player1 = new BaseBallPlayer("김태양", 0.325F, 16);
        BaseBallPlayer player2 = new BaseBallPlayer("이태양", 0.295F, 20);
        BaseBallPlayer player3 = new BaseBallPlayer("박태양", 0.325F, 11);
        BaseBallPlayer player4 = new BaseBallPlayer("최태양", 0.325F, 21);

        System.out.println("총 생성된 선수의 수: " + BaseBallPlayer.playerCount);

        player2.updateStatus(0.312f, 22);
        System.out.println(player2.battingAVG);
        System.out.println(player2.homeRuns);

        System.out.println(BaseBallPlayer.evaluateHomeRun(player3.homeRuns));
        System.out.println(BaseBallPlayer.evaluateHomeRun(player4.homeRuns));
    }
}

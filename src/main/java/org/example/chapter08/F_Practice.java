package org.example.chapter08;

// 추상클래스
// : 모바일 애플리케이션

abstract class MobileApp {
    //추상메서드 한개 이상 포함해야함 => 실행에 대한 동작 정의
    // - 각 앱 마다 '고유한 실행을 정의'(상속받은 클래스에서 구현)

    abstract void execute ();

    //일반 메서드
    void appInfo () {
        System.out.println("This is a mobile app");
    }
}

// == SNS 애플리케이션 == //
class SocialApp extends MobileApp {
    String name; //인스턴스 필드(각 객체가 가질 이름)

    SocialApp(String name) {
        this.name = name;
    }

    @Override
    void execute() { //실행
        System.out.println(name + " app executes");
    }

    @Override
    void appInfo() {
        System.out.println(name + " app is most popular social app");
    }

    // social app이 가지는 고유 메서드
    void shareContent(String content) {
        System.out.println(name + " shares : " + content);
    }
}


// == 게임 == //

class GameApp extends MobileApp {
    @Override
    void execute() {
        System.out.println("Game app executes");
    }
}


public class F_Practice {
    public static void main(String[] args) {
        // == 다형성 적용 == //
        // : 업캐스팅

        MobileApp gameApp = new GameApp();
        MobileApp socialApp = new SocialApp("Instagram");

        //다형성 적용에 의해 공통된 메서드 호출
        gameApp.execute();
        gameApp.appInfo(); // 재정의가 안되어있어서 부모의 행위를 출력

        socialApp.execute();
        socialApp.appInfo();

//        socialApp.shareContent("이미지"); => 업캐스팅 시 하위 클래스의 고유 메서드에 접근 불가

        // 형변환

        if (socialApp instanceof GameApp) {
            System.out.println("socialApp이 Game의 객체");
            GameApp onlyGame = (GameApp) socialApp;
        } else if (socialApp instanceof SocialApp) {
            System.out.println("social 이 Social앱 타입의 객체");
            SocialApp onlySocial = (SocialApp) socialApp;

            onlySocial.shareContent("images");
        }

        // == 객체 배열 & 다형성 적용 == //

        MobileApp[] apps = {
            // 생성과 동시에 업캐스팅
                new GameApp(),
                new SocialApp("FaceBook"),
                new SocialApp("KakaoTalk")
        };

        for (MobileApp app: apps) {
            app.execute();
            app.appInfo();

            if (app instanceof SocialApp) {
                //다운캐스팅을 해서 내부 동작 실행시켜주기
                SocialApp specificSocial = (SocialApp) app;
                specificSocial.shareContent("Files");
            }
        }

    }
}

package org.example.otherpackage;

// 이게 ProtectedClass의 부모클래스 역할을 함
public class OtherClass {
     protected  String otherField = "다른 패키지의 필드(protected)";

     protected void otherMethod () {
         System.out.println("다른 패키지으 ㅣ메서드(protected");
     }

    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        System.out.println(publicClass.publicField);
        publicClass.publicMethod();
    }
}

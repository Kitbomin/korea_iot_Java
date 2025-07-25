package org.example.z_project.phr_solution.handler;

// 입력값에 대한 처리를 모아놓은 핸들러

import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

    public static int getChoice() {
        // 맨 처음 선택
        while (!sc.hasNextInt()){
            System.out.println("숫자를 입력해주세요.");
            sc.nextLine(); //버퍼처리
        }

        int choice = sc.nextInt();
        sc.nextLine(); //버퍼처리

        return choice;

    }

    // 내용값 입력
    public static String getInput(String prompt) {

        while (true) {
            System.out.print(prompt + ": ");
            String input = sc.nextLine().trim();//문자열 양쪽 공백 제거

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("입력값을 비워둘 수 없습니다. 다시 입력해주세요.");

        }
    }

    // Long 타입 -> id 고유값 반환
    public static Long getIdInput() {
        while (true) {
            String input = getInput("ID를 입력하세요");
            try {

                return Long.parseLong(input);
            }catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능: " + e.getMessage());
            }
        }

    }

    // 요청
    // 1) 환자 정보 생성 입력값 처리
    public static PatientCreateRequestDto createPatientRequest() {
        PatientCreateRequestDto dto = null;

        try {
            // 이름, 나이, 성별 입력 로직
            String name = getInput("환자이름을 입력해주세요");
            int age = Integer.parseInt(getInput("환자 나이를 입력해주세요"));
            String gender = getInput("환자 성별을 입력해주세요");

            dto = new PatientCreateRequestDto(name, age, gender);

        } catch (NumberFormatException e) {
            System.out.println("환자 나이는 숫자값을 입력해야해요: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return dto;
    }


    // 2) 환자 정보 업데이트 입력값 처리
    public static PatientUpdateRequestDto updatePatientRequest() {
        PatientUpdateRequestDto dto = null;

        try {
            // 이름, 나이, 성별 입력 로직
            String name = getInput("환자이름을 입력해주세요");
            int age = Integer.parseInt(getInput("환자 나이를 입력해주세요"));

            dto = new PatientUpdateRequestDto(name, age);

        } catch (NumberFormatException e) {
            System.out.println("환자 나이는 숫자값을 입력해야해요: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return dto;
    }


    public static void closeScanner() {
        sc.close();
    }
}

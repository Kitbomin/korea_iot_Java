package org.example.z_project.phr_solution;

/*
 *  PHR -> 개인 건강 기록, Personal Health Record 솔루션 프로젝트
 *
 *  1. 프로젝트 개요
 *      - 개인 건강 기록 (PHR) 솔루션을 위한 간단한 콘솔 기반 응용 프로그램
 *
 *      - 환자의 기본 정보를 관리, 환자의 건강 기록에 대한 등록, 수정, 조회 기능 구현
 *
 *      - 특정 조건에 따라 건강 기록을 필터링하고 집계하는 기능 구현
 *
 *  2. 주요 기능 & 비즈니스 로직
 *   - 환자 정보 관리(Patient): C R(단건, 전체) U D
 *   - 건강 기록 관리(HealthRecord): CRUD + 필터링(조회)
 *
 *  3. 비즈니스 로직 구조
 *   - Controller: 사용자 입력 처리 + 알맞은 서비스 메서드 호출
 *   - Service: 핵심 비즈니스 로직 수행
 *   - Repository: 데이터 저장소(DB)와의 상호작용 담당
 *   - dto: 계층 간 데이터 전송을 위한 객체
 *   - entity: 데이터 저장소(DB)의 테이블과 매핑되는 도메인 객체
 *
 *  4. 실행 및 관리
 *   - App.java: 프로그램 실행 진입점, 사용자와의 상호작용을 관리하고 전체 흐름을 제어하는 역할
 *              >> App.java가 사용자 입력처리, 메뉴 출력, 흐름 제어 모두를 담당 -> SOLID의 SRP(단일 책임 원칙)에 위배됨
 *              >> handler + App.java로 구분
 *
 */


import org.example.z_project.phr_solution.controller.PatientController;
import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.handler.InputHandler;
import org.example.z_project.phr_solution.handler.MenuPrinter;

import java.util.List;

public class App {
    private static final PatientController patientController = new PatientController();


    private static boolean processChoice(int choice) {
        //사용자의 입력을 처리하는 역할
        switch (choice) {

            //환자 관련 기능
            // 등록
            case 1: {
                // 드옭
                PatientCreateRequestDto requestDto = InputHandler.createPatientRequest();

                if (requestDto == null) {
                    System.out.println("필수 입력값을 유효하게 넣어야합니다.");
                    break;
                }

                patientController.registerPatient(requestDto);

                break;
            }
            // 전체조회
            case 2: {
                // 전체 조회
                List<PatientListResponseDto> patients = patientController.getAllPatients();
                if (patients.isEmpty()) {
                    System.out.println("환자 정보가 없어요");
                }else {
                    patients.forEach(System.out::println);
                }

                break;
            }
            // 단건조회
            case 3: {
                // 단건 조회
                Long id = InputHandler.getIdInput();
                PatientDetailResponseDto patient = patientController.getPatientById(id);



                if (patient == null) { // 맨처음 담은 null 값 검증
                    System.out.println("해당하는 ID의 환자가 없어요");

                }else System.out.println(patient);

                break;
            }
            // 수정
            case 4: {
                // 수정
                Long id = InputHandler.getIdInput();
                PatientUpdateRequestDto requestDto = InputHandler.updatePatientRequest();

                if (requestDto == null) {
                    System.out.println("필수 입력값을 유효하게 넣어야합니다.");
                    break;
                }

                patientController.updatePatient(id, requestDto);

                break;
            }
            // 삭제
            case 5: {
                // 삭제
                Long id = InputHandler.getIdInput();
                patientController.deletePatient(id);
                break;

            }

            // 건강 기록 관련 기능

            case 10: {
                System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
                return false;
            }

            default: {
                System.out.println("잘못된 입력입니다. 유효한 메뉴를 입력해주세요.");
                break;
            }



        }
        return true;

    }


    public static void main(String[] args) {
        try {
            while (true) {
                MenuPrinter.displayMenu();
                int choice = InputHandler.getChoice();
                if (!processChoice(choice)) break; // processChoice의 반환값이 false면 로직 종료

            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            //예외 발생 상관없이 반드시 실행 보장
            InputHandler.closeScanner();

        }

    }
}

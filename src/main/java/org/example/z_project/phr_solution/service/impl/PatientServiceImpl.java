package org.example.z_project.phr_solution.service.impl;

import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.entity.Patient;
import org.example.z_project.phr_solution.repository.PatientRepository;
import org.example.z_project.phr_solution.service.PatientService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//요청값을 반환하기 위한 로직

public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;


    private static long currentId = 1; // 환자 고유번호(id) 관리 변수

    public PatientServiceImpl() {
        this.patientRepository = PatientRepository.getInstance(); //싱글톤 패턴 사용
    }

    //ID 생성 로직 - Wrapper로 Long 사용
    private Long generateID() {
        return currentId++;
    }

    @Override
    public void registerPatient(PatientCreateRequestDto dto) {
        /*환자 등록 로직
         1) 요청, 응답
              -> 등록이니까 요청값이 필요 -> 응답은 필요에 따라 결정 가능
         2) 요청 값이 있을 경우 데이터 검증
              - EX) 해당 환자 정보가 이미 저장되어 있는지의 여부 확인 필요, 잘못된 이름이나 나이, 성별인지 확인 필요
         */

        Patient patient = new Patient(
                generateID(), dto.getName(), dto.getAge(), dto.getGender()
        );

        patientRepository.save(patient);
    }

    @Override
    public List<PatientListResponseDto> listAllPatients() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientListResponseDto> responseDtos = patients.stream()
                .map(patient -> new PatientListResponseDto(patient.getName(), patient.getGender()))
                .collect(Collectors.toList());

        return responseDtos;
    }


    @Override
    public PatientDetailResponseDto getPatientById(Long id) {
        PatientDetailResponseDto data = null;

        //내부 로직
        try {
//            Optional<Patient> optionalPatient = patientRepository.findById(id); //id에 회원이 있을 수도 있고 없을 수도 있음
//
//            if (optionalPatient.isEmpty()) {
//                // 해당 id의 환자 정보가 없는 경우
//                new IllegalArgumentException("해당 ID를 가진 환자를 조회할 수 없습니다: " + id); //발생할 오류 정의
//            }
//
//            Patient patient = optionalPatient.get(); //해당 id의 환자가 있으면 optionalPatient 포장지를 벗겨서 내용물을 가져옴

            // 위의 주석처리된 코드를 이렇게 한번에 처리 가능함
            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 환자를 조회할 수 없습니다: " + id));

            data = new PatientDetailResponseDto(patient.getId(), patient.getName(), patient.getAge());

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return data;
    }

    @Override
    public void updatePatient(Long id, PatientUpdateRequestDto dto) {
        try {
            Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 환자를 조회할 수 없습니다: " + id));

            patient.setName(dto.getName());
            patient.setAge(dto.getAge());

            patientRepository.save(patient); // 수정 후 다시 save 할거임


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void deletePatient(Long id) {
        try {
            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 환자를 조회할 수 없습니다: " + id));

            patientRepository.delete(patient);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

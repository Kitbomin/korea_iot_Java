package org.example.z_project.phr_solution.service;

import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;

import java.util.List;

// 환자 정보에 대한 비즈니스 로직
public interface PatientService {
    // C
    void registerPatient(PatientCreateRequestDto dto); // 요청값

    // R
    // All
    List<PatientListResponseDto> listAllPatients(); //요청값 없ㅇ므

    // 단건
    PatientDetailResponseDto getPatientById(Long id);

    // U
    void updatePatient(Long id, PatientUpdateRequestDto dto);

    // D
    void deletePatient(Long id);
}

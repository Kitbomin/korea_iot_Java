package org.example.z_project.phr_solution.service.impl;

import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    @Override
    public void registerPatient(PatientCreateRequestDto dto) {

    }

    @Override
    public List<PatientListResponseDto> listAllPatients() {
        return List.of();
    }

    @Override
    public PatientDetailResponseDto getPatientById(Long id) {
        return null;
    }

    @Override
    public void updatePatient(Long id, PatientUpdateRequestDto dto) {

    }

    @Override
    public void deletePatient(Long id) {

    }
}

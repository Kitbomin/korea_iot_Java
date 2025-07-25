package org.example.z_project.phr_solution.dto.patient.request;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class PatientCreateRequestDto {
    // 환자의 4가지 필드값 중 3가지
    private String name;
    private int age;
    private String gender;
}

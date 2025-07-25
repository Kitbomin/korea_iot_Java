package org.example.z_project.phr_solution.repository;

import org.example.z_project.phr_solution.entity.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientRepository {
    //저장소 역할 리스트
    List<Patient> patients = new ArrayList<>();

    // 싱글톤 구현
    private static final PatientRepository instance = new PatientRepository();
    private PatientRepository() {}
    public static PatientRepository getInstance() {
        return instance;
    }

    public void save(Patient patient) {
        
    }

    public List<Patient> findAll() {
        return null;
    }

    public Optional<Patient> findById(Long id) {
    }

    public void delete(Patient patient) {
    }
}

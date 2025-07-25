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
    public static PatientRepository getInstance() {return instance;}

    public void save(Patient patient) {
        // 생성 (Create), 수정(Update) 가 같은 save를 사용
//        delete(patient); -> 이걸 좀더 고급지게 하면 아래와 같음

        Optional<Patient> existing = findById(patient.getId());

//        existing.ifPresent(value -> this.delete(value));
        existing.ifPresent(this::delete); //this -> PatientRepository 구성 받아옴 // 전달 받은 환자의 id가 이미 존재하는 경우 -> 삭제

        patients.add(patient);
    }


    public List<Patient> findAll() {
        return new ArrayList<>(patients); //새로운 주소값에 담아서 읽기 전용으로 내보냄
    }


    public Optional<Patient> findById(Long id) {
        return patients.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }

    public void delete(Patient patient) {
        patients.remove(patient);
    }
}

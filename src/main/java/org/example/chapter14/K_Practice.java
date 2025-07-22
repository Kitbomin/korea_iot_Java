package org.example.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// == 직원 관리 시스템 ==

@AllArgsConstructor //유사 @Setter
@Getter
@ToString
class Employee {
    private String department;
    private String name;
    private int salary;

}

public class K_Practice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("IT", "이승아", 300),
                new Employee("HR", "조승범", 500),
                new Employee("IT", "김준일", 400),
                new Employee("OP", "전예찬", 350),
                new Employee("HR", "윤대휘", 380)
        );

        //1. 급여가 400 이상인 직원 필터링
        List<Employee> filteredEmployee = employees.stream()
                .filter(employee -> employee.getSalary() >= 400)
                .toList();

        System.out.println("-------------------");
        System.out.println("급여가 400이상인 직원");

        filteredEmployee.forEach(System.out::println);



        //2. IT부서 직원의 이름만 추출
        //1) 부서 IT인 직원 filter
        //2) 부서가 'IT'인 직원 목록을 전체 순회하여 이름만 추출 -map
        List<String> employeeName = employees.stream()
//                .filter(employee -> employee.getDepartment().contains("IT"))
                .filter(employee -> "IT".equals(employee.getDepartment()))
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("-------------------");
        System.out.println("부서가 IT인 직원");

        System.out.println(employeeName);



        // 3. 특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링
        // 1) 부서가 'HR'인 직원을 필터링 >> equals
        // 2) 위의 목록 중 이름에 '조'가 포함된 직원을 필터링 >> contains
        List<Employee> nameJo = employees.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .filter(employee -> employee.getName().contains("조"))
                .toList();

        System.out.println("-------------------");
        System.out.println("부서가 HR인 직원임과 동시에 '조'가 포함된 직원");

        nameJo.forEach(System.out::println);

        nameJo.forEach(employee -> System.out.println(employee.getName())); //이러면 이름만 출력 가능 -> 근데 메서드 참조는 안됨



        // 4. 부서별 직원 그룹화
        // Collectors 클래스 - groupingBy
        Map<String, List<Employee>> groupedByDepartment = employees.stream()
//                .collect(Collectors.groupingBy(employee -> employee.getDepartment())) => 이것도 됨
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("-------------------");
        System.out.println("부서별 직원 그룹화");
        groupedByDepartment.forEach((department, employeesed)
                -> System.out.println(department + employeesed));


        //번외
        for (Map.Entry<String, List<Employee>> entry: groupedByDepartment.entrySet()) {
            String department = entry.getKey();
            List<Employee> employeesInDept = entry.getValue();

            System.out.print(department + ": ");
            for (Employee employee: employeesInDept) {
                System.out.print(employee.getName() + " ");
            }

            System.out.println();
        }

        //번외 2
        groupedByDepartment.forEach((department, employeesByDept) -> {
            String name = employeesByDept.stream()
                    .map(Employee::getName)
                    .collect(Collectors.joining(" "));

            System.out.println(department + ": " + name);
        });

        // 5. 부서별 평균 급여 계산
        // Collectors 클래스 - groupingBy
        //                  - averaging 타입: 해당 타입의 평균을 계산(averagingInt 사용)
        Map<String , Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                         Collectors.averagingInt(Employee::getSalary)));

        System.out.println(avgSalaryByDept);


    }
}

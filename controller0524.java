package com.ohgiraffers.practices.methodcontroller;

import com.ohgiraffers.practices.model.PublisherDTO0524;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Controller0524 {
    /*11. 캡슐화 이용, 출력결과값 저장할 PrintResult와
    실제 기능할 Class Service쪽으로 요청 보내기 위한 ProgramService 공간 생성(final 상수)
     */
    private final PrintResult printResult;
    private final EmpService empService;

    // 12. run과 Service 사이에서 control 담당해줄 method 만들기
    // 17. 바로 아래 메소드 처음에 class 이름이랑 다른 걸로 만들었는데 자꾸 경고 떴음.
    // final로 선언한 게 잘못됐다고도 하고, 아래 public method를 public void로 만들어야한다고 하기도 하고..
    // 근데 method이름을 class명과 똑같이 하니 다 해결됨.
    public Controller0524() {
        printResult = new PrintResult();
        empService = new EmpService();
    }

    public void readAllEmp() {
        List<PublisherDTO0524> empList = empService.readAllEmp();
        if(empList != null){
            printResult.printEmpList(empList);
        } else {
            printResult.printErrorMsg("selectList");
        }
    }

    public void readEmpByDept(Map<String, String> parameter) {
        String deptCode = parameter.get("deptCode");

        //27. PublisherDTO.. emp에서 List<Pub..DTO..> emp로 변경
        List<PublisherDTO0524> emp = empService.readEmpByDept(deptCode);
        // 22. PublisherDTO0524 dto = empService. 여기까지 쓰고
        // EmpService에 public Pu..DTO.. readEmpByDept(String deptCode) 만들러 감

        //23. if-else로 부서코드로 직원조회 실패했을 경우 대비
        if(emp != null) {
            printResult.printEmpList(emp);
            /*28. 부서별 직원 조회 결과가 계속 주욱 한 줄로만 나옴.
            printResult.printEmp(emp);를 .printEmpList(emp);로 바꾸고 재조회
             */
        } else{
            printResult.printErrorMsg("selectDept");
        }
    }

    public void readEmpById(Map<String, String> parameter) {
        int empId = Integer.parseInt(parameter.get("empId"));

        PublisherDTO0524 employee = empService.readEmpById(empId);
        if(employee != null){
            printResult.printEmp(employee);
        } else{
            printResult.printErrorMsg("selectOne");
        }
    }

    public void createNewEmp(Map<String, String> parameter) {
        String empId = parameter.get("empId");
        String empName = parameter.get("name");
        //35. String name에서 String empName으로 수정
        String email = parameter.get("email");
        String deptCode = parameter.get("deptCode");
        int salary = Integer.parseInt(parameter.get("salary"));
        String hiredDateStr = parameter.get("hiredDate");
        Date hiredDate = java.sql.Date.valueOf(hiredDateStr);
        /* 31. Date hiredDate = parameter.get("hiredDate");였던 걸
        String hiredDateStr = parameter.get("hiredDate");
        Date hiredDate = java.sql.Date.valueOf(hiredDateStr); 이렇게 두 단계로 바꿈.
        class Run0524  Date hiredDate = sc.nextLine();도
        String hiredDate = sc.nextLine();로 수정
        (Date와 String 자료형 차이로 인한 오류를 없애기 위한 수정)
        https://github.com/copilot/share/480b508c-01a4-8ca0-9813-c24f80154019
         */

        // 30.parameter가 3개 이상이기 때문에 DTO에 뭉쳐서 보낸다
        PublisherDTO0524 newEmp = new PublisherDTO0524();
        newEmp.setEmpId(empId);
        newEmp.setEmpName(empName);
        newEmp.setEmail(email);
        newEmp.setDeptCode(deptCode);
        newEmp.setSalary(salary);
        newEmp.setHireDate(hiredDate);

        // 32. 새 직원 정보 등록 실패시 문구 출력 기능
        if(empService.createNewEmp(newEmp)){
            printResult.printSuccessMsg("insert");
        } else{
            printResult.printErrorMsg("insert");
        }
    }

    public void updateEmpInfo(Map<String, String> parameter) {
        String name = parameter.get("empName");
        String deptCode = parameter.get("deptCode");
        int salary = Integer.parseInt(parameter.get("salary"));
        String empCode = parameter.get("modiCode");

        PublisherDTO0524 dto = new PublisherDTO0524();
        dto.setEmpName(name);
        dto.setDeptCode(deptCode);
        dto.setSalary(salary);
        dto.setEmpId(empCode);

        if(empService.updatEmpInfo(dto)) {
            printResult.printSuccessMsg("update");
            // "update" successMsg 만듦
        } else {
            printResult.printErrorMsg("update");
            // "update" errorMsg 만듦
        }
    }

    public void deleteEmpInfo(int i) {
        int empId = Integer.parseInt(String.valueOf(i));

        PublisherDTO0524 dto = new PublisherDTO0524();
        dto.setEmpId(String.valueOf(empId));

        if(empService.deleteEmpInfo(dto)){
            printResult.printSuccessMsg("delete");
        } else {
            printResult.printErrorMsg("delete");
        }

    }
}

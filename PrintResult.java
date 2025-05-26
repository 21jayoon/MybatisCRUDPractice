package com.ohgiraffers.practices.methodcontroller;

import com.ohgiraffers.practices.model.PublisherDTO0524;

import java.util.List;

public class PrintResult {
    public void printEmpList(List<PublisherDTO0524> empList) {
        for(PublisherDTO0524 emp : empList){
            System.out.println(emp);
        }
    }

    public void printEmp(PublisherDTO0524 emp) {
        System.out.println(emp);
    }
    // class EmpService 내 readEmpById method에서 사용됨

    public static void printErrorMsg(String errorInput) {
        // String 변수 선언
        String errorMsg = "";

        switch (errorInput){
            case "selectList" : errorMsg = "목록 조회에 실패하였습니다."; break;
            //16. Run에서 전체 사원 조회되는지 확인

            //24. 부서코드로 부서 내 직원 조회 실패했을 때 실패 문구 출력
            case "selectDept" : errorMsg = "부서코드별 직원 조회에 실패했습니다.";break;
            //25. case 2: readEmpByDept(inputDeptCode()) 작동 확인

            //27. 사번으로 해당직원 조회 실패시 문구 출력
            case "selectOne" : errorMsg = "해당 사번을 가진 직원 조회 실패"; break;

            case "insert" : errorMsg = "새 직원 정보 입력 실패"; break;
            case "update" : errorMsg = "정보 업데이트 실패"; break;
            case "delete" : errorMsg = "정보 삭제 실패"; break;
        }
        System.out.println(errorMsg);
    }

    public void printSuccessMsg(String insert) {
        // String 변수 선언
        String successMsg = "";

        switch (insert){
            case "insert" :
                successMsg = "새 직원 정보 입력 성공"; break;
            case "update" :
                successMsg = "직원 정보 업데이트 성공";break;
            case "delete" :
                successMsg = "정보 삭제 성공. 퇴사처리가 완료되었습니다."; break;
        }
        System.out.println(successMsg);
    }
}

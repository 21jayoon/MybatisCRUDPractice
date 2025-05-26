package com.ohgiraffers.practices.run;

import com.ohgiraffers.practices.methodcontroller.controller0524;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Run0524 {
    public static void main(String[] args){
        /* 사용자의 입력을 받아 희망출팡사에서 이번 6월에 열릴
        서울국제도서전에 외근 나갈 직원을 뽑을 것임
         */
        //1. Scanner 불러오기
        Scanner sc = new Scanner(System.in);

        //2. 기능을 불러올 메소드들이 담겨있는 class controller0524 불러오기
        controller0524 empController = new controller0524();

        // 3. do-while과 switch로 서비스 기본 형태 만들기
        do {
            System.out.println("===희망출판사 직원 정보 조회===");
            System.out.println("|    1. 전체 직원 조회       |");
            System.out.println("|    2. 부서별 직원 조회      |");
            System.out.println("|    3. 사원으로 직원 조회    |");
            System.out.println("|    4. 신규 직원 추가        |");
            System.out.println("|    5. 직원 정보 업데이트     |");
            System.out.println("|    6. 직원 정보 삭제        |");
            System.out.println("|    9. 프로그램 종료         |");
            System.out.println("---------------------------");
            System.out.print(" 직원 관리 번호를 입력하세요 :  ");

            // 4. swtich 매개변수로 들어갈 정수 num, Scanner로 받아오기
            int num = sc.nextInt();

            //5.일단 method이름 정해놓고
            switch (num) {
                case 1 :
                    empController.readAllEmp();break;
                    //17. 뭔가 오류가 계속 난다. 일단 경고창에 뜬 모든 method를 readAllEmp()로 고쳐봄
                    //19. DTO 고침.  private String EMP_ID; 이런 식으로 되어 있던 거 모두 private String empId; 이 형태로.
                case 2 :
                    //6. 부서코드 입력 받고 실제 DB에서 일치하는 값 받아올 inputDeptID 메소드 필요
                    empController.readEmpByDept(inputDeptCode());break;
                    // Expected one result (or null) to be returned by selectOne(), but found: 2
                //26. SelectOne 말고 List로 수정
                case 3 :
                    empController.readEmpById(inputEmdId());break;
                case 4 :
                    empController.createNewEmp(inputNewInfo());break; //return?? 왜 새 정보 등록하고 종료가 안 되지0526 2:10오전
                case 5 :
                    empController.updateEmpInfo(inputUpdate());break;
                /*case 6 :
                    empController.deleteEmpInfo(inputDelete());break; */
                case 9 :
                    System.out.println("프로그램 종료"); return;
                default :
                    System.out.println("잘못된 선택지입니다.");
            }
        } while(true);

        //7. resources패키지에 SQL DB랑 연결해줄 xml파일 두 개 생성

    //21. case2 : 부서 코드별 직원 조회 inputDeptCode() class run에 만들기
    }


    private static Map<String, String> inputDeptCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("부서코드 입력(D1...D4) : ");
        String deptCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("deptCode", deptCode);

        return parameter;
    }

    private static Map<String, String> inputEmdId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("사번 입력 (300-314) : ");
        String empId = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);

        return parameter;
    }

        private static Map<String, String> inputNewInfo() {
            Scanner sc = new Scanner(System.in);
            System.out.print("사번 입력(3xx, 315번부터) : ");
            String empId = sc.nextLine();
            System.out.print("이름 입력 : ");
            String empName = sc.nextLine();
            System.out.print("이메일 입력(--@heuimangpub.com) : ");
            String email = sc.nextLine();
            System.out.print("부서코드 입력(D1-D4) : ");
            String deptCode = sc.nextLine();
            System.out.print("급여 입력 : ");
            String salary = sc.nextLine();
            System.out.print("입사일 입력 (20YY-MM-DD) : ");
            String hiredDate = sc.nextLine();

            Map<String, String> parameter = new HashMap<>();
            parameter.put("empId", empId);
            parameter.put("name", empName);
            /*34.There is no getter for property named 'name' in 'class com.ohgiraffers.practices.model.PublisherDTO0524'
            ("name", name);에서 ("name", empName);으로 수정
             */
            parameter.put("email", email);
            parameter.put("deptCode", deptCode);
            parameter.put("salary", salary);
            parameter.put("hiredDate", hiredDate);

            return parameter;
        }
}

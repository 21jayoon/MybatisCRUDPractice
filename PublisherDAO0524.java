package com.ohgiraffers.practices.model;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PublisherDAO0524 {

    public List<PublisherDTO0524> readAllEmp(SqlSession sqlSession) {
        return sqlSession.selectList("PublisherMapper.readAllEmp");
    }
    //18. 관련 모든 객체명 readAllEmp로 변경
    // 15. Run에서 readAllEmp 기능 동작하는지 확인하기 위해
    // class PrintResult 가서 필요 기능(selectList errorMsg 출력) 만들어준다.

    public static List<PublisherDTO0524> readEmpByDept(SqlSession sqlSession, String deptCode) {
        return sqlSession.selectList("PublisherMapper.readEmpByDept", deptCode);
    }

    public static PublisherDTO0524 readEmpById(SqlSession sqlSession, int empId) {
        return sqlSession.selectOne("PublisherMapper.readEmpById", empId);
    }

    public static int insertInfo(SqlSession sqlSession, PublisherDTO0524 dto) {
        return sqlSession.insert("PublisherMapper.createNewEmp", dto);
        /* 33. Mapped Statements collection does not contain value for PublisherMapper.insertInfo
         publisher-mapper.xml에 정해놨던 id에 따라 PublisherMapper.createNewEmp로 고침 */
    }
}

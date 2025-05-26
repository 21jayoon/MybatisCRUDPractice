package com.ohgiraffers.practices.methodcontroller;

import com.ohgiraffers.practices.model.PublisherDAO0524;
import com.ohgiraffers.practices.model.PublisherDTO0524;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.config.Template.getSqlSession;

public class EmpService {
    private final PublisherDAO0524 publisherDAO;

    public EmpService() {
        publisherDAO = new PublisherDAO0524();
    }

    // 13. getSqlSession (problem occurred) 해결 방법 :
    // class Template 만들어준 후 getSqlSession import class해줌
    public List<PublisherDTO0524> readAllEmp() {
        SqlSession sqlSession = getSqlSession();

        List<PublisherDTO0524> empList = publisherDAO.readAllEmp(sqlSession);

        //14. Class PublisherDAO...에 selectAllEmp method 만들어주러 이동 (ALT+ENTER 사용)

        sqlSession.close();

        return empList;
    }

    public List<PublisherDTO0524> readEmpByDept(String deptCode) {
        SqlSession sqlSession = getSqlSession();
        List<PublisherDTO0524> empList = PublisherDAO0524.readEmpByDept(sqlSession, deptCode);
        sqlSession.close();
        return empList;
    }

    public PublisherDTO0524 readEmpById(int empId) {
        SqlSession sqlSession = getSqlSession();
        PublisherDTO0524 employee = PublisherDAO0524.readEmpById(sqlSession, empId);
        sqlSession.close();
        return employee;
    }

    public boolean createNewEmp(PublisherDTO0524 dto) {
        SqlSession sqlSession = getSqlSession();
        int result = PublisherDAO0524.insertInfo(sqlSession, dto);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true : false;
    }
}

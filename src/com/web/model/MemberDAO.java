package com.web.model;
// JDBC

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;


public class MemberDAO {

    private static SqlSessionFactory sqlSessionFactory;

    //  초기화 블럭, 프로그램 실행 시 딱 한번만 실행되는 코드 영역.
    static {
        try {
            String resource = "com/web/mybatis/config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource); //읽기, 연동
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // connect, close 방식이 아닌 sqlfactory에서 세션 하나를 꺼내온다.

    //  회원 전체 리스트 보기
    public List<MemberVO> memberList(){
        // connection + statement = sqlsession
        SqlSession session = sqlSessionFactory.openSession(); //session 가져옴
        List<MemberVO> list =  session.selectList("memberList");
        session.close(); // session 반납
        return list;
    }

    //  회원가입
    public int memberInsert(MemberVO vo){
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.insert("memberInsert", vo);
        session.commit();  // db수정 시
        session.close();
        return cnt;
    }

    //  회원삭제
    public int memberDelete(int num){
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.delete("memberDelete",num);
        session.commit();
        session.close();
        return cnt;
    }

    //  회원상세보기
    public MemberVO memberContent(int num){
        SqlSession session = sqlSessionFactory.openSession();
        MemberVO vo = session.selectOne("memberContent", num);
        session.close();
        return vo;
    }

    //  회원업데이트
    public int memberUpdate(MemberVO vo){
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.update("memberUpdate", vo);
        session.commit();
        session.close();
        return cnt;
    }

    // 회원로그인
    public String memberLogin(MemberVO vo){
        SqlSession session = sqlSessionFactory.openSession();
        String user_name = session.selectOne("memberLogin", vo);
        return user_name;
    }
}




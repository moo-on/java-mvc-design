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
}
//    private Connection conn;
//    private PreparedStatement ps;
//    private ResultSet rs;
//
//    //  데이터베이스 연결객체 생성
//    public void getConnect() {
//        String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=UTF-8";
//        String user = "root";
//        String password ="rkwodml1";
//
//        // MySQL Driver Loading
//        try {
//            /*정적로딩
//             * DriverManager driver = new com.mys ql.jdbc.Driver();
//             * conn = driver.getConnection(URL, user, password);
//             */
//            // 동적로딩 - 컴파일 시점에는 단순 문자열, 실행 지점에 Driver class를 메모리에 올림
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(URL, user, password);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public int memberInsert(MemberVO vo) {
//        String SQL = "insert into member(id, pass, name, age, email, phone) values(?,?,?,?,?,?)";
//        //SQL 전송객체 생성
//        getConnect();
//        int cnt = -1;
//        try {
//            ps = conn.prepareStatement(SQL);//미리 컴파일을 시킨다. 속도 등 장점
//            ps.setString(1, vo.getId());
//            ps.setString(2, vo.getPass());
//            ps.setString(3, vo.getName());
//            ps.setInt(4, vo.getAge());
//            ps.setString(5, vo.getEmail());
//            ps.setString(6, vo.getPhone());
//            // 값을 전송
//            cnt = ps.executeUpdate(); // 전송 후 실패 여부 값 반환
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            dbClose();
//        }
//        return cnt;
//    }
//    //회원(VO) 전체 리스트(ArrayList) 가져오기
//    public ArrayList<MemberVO> memberList() {
//        String SQL = "select * from member";
//        getConnect();
//        ArrayList<MemberVO> list = new ArrayList<>();
//        try {
//            ps = conn.prepareStatement(SQL);
//            //결과 집합 을 받아옴
//            rs = ps.executeQuery(); // rs -> 커서, 컬럼을 가르킴.
//
//            while(rs.next()) {
//                int num =  rs.getInt("num");
//                String id =  rs.getString("id");
//                String pass =  rs.getString("pass");
//                String name =  rs.getString("name");
//                int age =  rs.getInt("age");
//                String email =  rs.getString("email");
//                String phone =  rs.getString("phone");
//
//                MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone);
//                list.add(vo);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            dbClose();
//        }
//        return list; // memberlist
//    }
//
//    public int memberDelete(int num) {
//        String SQL = "delete from member where num = ?";
//        getConnect();
//        int cnt = -1;
//        try {
//            ps=conn.prepareStatement(SQL);
//            ps.setInt(1, num); // 첫번째 파라미터리시레 2
//            cnt = ps.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            dbClose();
//        }
//        return cnt;
//    }
//
//    public MemberVO memberContent(int num) {
//        String SQL = "select * from member where num = ?";
//        getConnect();
//        int cnt = -1;
//        MemberVO vo = null;
//        try {
//            ps=conn.prepareStatement(SQL);
//            ps.setInt(1, num); // 첫번째 파라미터리여서 1
//            rs = ps.executeQuery();
//            if(rs.next()) {
//                //회원 한명의 정보를 가져온 후 VO에 묶어준다.
//                num =  rs.getInt("num");
//                String id =  rs.getString("id");
//                String pass =  rs.getString("pass");
//                String name =  rs.getString("name");
//                int age =  rs.getInt("age");
//                String email =  rs.getString("email");
//                String phone =  rs.getString("phone");
//                vo = new MemberVO(num, id, pass, name, age, email, phone);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            dbClose();
//        }
//        return vo;
//    }
//
//    public int memberUpdate(MemberVO vo) {
//        String SQL = "update member set age=?, email = ?, phone = ? where num =?";
//        getConnect();
//        int cnt = -1;
//        try {
//            ps = conn.prepareStatement(SQL);
//            ps.setInt(1, vo.getAge());
//            ps.setString(2, vo.getEmail());
//            ps.setString(3, vo.getPhone());
//            ps.setInt(4, vo.getNum());
//
//            cnt = ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            dbClose();
//        }
//        return cnt;
//    }
//
//    // 데이터베이스 연결 끊기
//    public void dbClose() {
//        try {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }




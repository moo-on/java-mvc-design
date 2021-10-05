package com.web.model;
// JDBC
import java.sql.*;
import java.util.*;

public class MemberDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    //  데이터베이스 연결객체 생성
    public void getConnect() {
        String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=UTF-8";
        String user = "root";
        String password ="rkwodml1";

        // MySQL Driver Loading
        try {
            /*정적로딩
             * DriverManager driver = new com.mys ql.jdbc.Driver();
             * conn = driver.getConnection(URL, user, password);
             */
            // 동적로딩 - 컴파일 시점에는 단순 문자열, 실행 지점에 Driver class를 메모리에 올림
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int memberInsert(MemberVO vo) {
        String SQL = "insert into member(id, pass, name, age, email, phone) values(?,?,?,?,?,?)";
        //SQL 전송객체 생성
        getConnect();
        int cnt = -1;
        try {
            ps = conn.prepareStatement(SQL);//미리 컴파일을 시킨다. 속도 등 장점
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getPass());
            ps.setString(3, vo.getName());
            ps.setInt(4, vo.getAge());
            ps.setString(5, vo.getEmail());
            ps.setString(6, vo.getPhone());
            // 값을 전송
            cnt = ps.executeUpdate(); // 전송 후 실패 여부 값 반환
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }
    //회원(VO) 전체 리스트(ArrayList) 가져오기
    public ArrayList<MemberVO> memberList() {
        String SQL = "select * from member";
        getConnect();
        ArrayList<MemberVO> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(SQL);
            //결과 집합 을 받아옴
            rs = ps.executeQuery(); // rs -> 커서, 컬럼을 가르킴.

            while(rs.next()) {
                int num =  rs.getInt("num");
                String id =  rs.getString("id");
                String pass =  rs.getString("pass");
                String name =  rs.getString("name");
                int age =  rs.getInt("age");
                String email =  rs.getString("email");
                String phone =  rs.getString("phone");

                MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone);
                list.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return list; // memberlist
    }

    public int memberDelete(int num) {
        String SQL = "delete from member where num = ?";
        getConnect();
        int cnt = -1;
        try {
            ps=conn.prepareStatement(SQL);
            ps.setInt(1, num); // 첫번째 파라미터리시레 2
            cnt = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }

    public MemberVO memberContent(int num) {
        String SQL = "select * from member where num = ?";
        getConnect();
        int cnt = -1;
        MemberVO vo = null;
        try {
            ps=conn.prepareStatement(SQL);
            ps.setInt(1, num); // 첫번째 파라미터리여서 1
            rs = ps.executeQuery();
            if(rs.next()) {
                //회원 한명의 정보를 가져온 후 VO에 묶어준다.
                num =  rs.getInt("num");
                String id =  rs.getString("id");
                String pass =  rs.getString("pass");
                String name =  rs.getString("name");
                int age =  rs.getInt("age");
                String email =  rs.getString("email");
                String phone =  rs.getString("phone");
                vo = new MemberVO(num, id, pass, name, age, email, phone);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return vo;
    }

    public int memberUpdate(MemberVO vo) {
        String SQL = "update member set age=?, email = ?, phone = ? where num =?";
        getConnect();
        int cnt = -1;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, vo.getAge());
            ps.setString(2, vo.getEmail());
            ps.setString(3, vo.getPhone());
            ps.setInt(4, vo.getNum());

            cnt = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }

    // 데이터베이스 연결 끊기
    public void dbClose() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

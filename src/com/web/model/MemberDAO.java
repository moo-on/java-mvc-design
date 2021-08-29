package com.web.model;
// JDBC
import java.sql.*;
import java.util.*;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//  �����ͺ��̽� ���ᰴü ����
	public void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=UTF-8";
		String user = "root";
		String password ="rkwodml1";
		
		// MySQL Driver Loading
		try {
		/*�����ε�
		 * DriverManager driver = new com.mys ql.jdbc.Driver();
		 * conn = driver.getConnection(URL, user, password);
		 */
		// �����ε� - ������ �������� �ܼ� ���ڿ�, ���� ������ Driver class�� �޸𸮿� �ø�  
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(URL, user, password);
		} catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	public int memberInsert(MemberVO vo) {
		String SQL = "insert into member(id, pass, name, age, email, phone) values(?,?,?,?,?,?)";
		//SQL ���۰�ü ����
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);//�̸� �������� ��Ų��. �ӵ� �� ����
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			// ���� ����
			cnt = ps.executeUpdate(); // ���� �� ���� ���� �� ��ȯ
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	//ȸ��(VO) ��ü ����Ʈ(ArrayList) ��������
	public ArrayList<MemberVO> memberList() {
		String SQL = "select * from member";
		getConnect();
		ArrayList<MemberVO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(SQL);
			//��� ���� �� �޾ƿ�
			rs = ps.executeQuery(); // rs -> Ŀ��, �÷��� ����Ŵ.
			
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
			ps.setInt(1, num); // ù��° �Ķ���͸��÷� 2
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
			ps.setInt(1, num); // ù��° �Ķ���͸����� 1
			rs = ps.executeQuery();
			if(rs.next()) {
				//ȸ�� �Ѹ��� ������ ������ �� VO�� �����ش�.
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
	
	// �����ͺ��̽� ���� ����
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

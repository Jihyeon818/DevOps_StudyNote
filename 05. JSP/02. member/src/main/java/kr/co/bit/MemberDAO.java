package kr.co.bit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MemberDAO {
	String id="root";
	String pw="1234";
	String url="jdbc:mysql://localhost:3306/hyeon";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	public void getCon() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//DB에 접속
			conn = DriverManager.getConnection(url,id,pw);
			
		}catch (Exception e) {}
	}
	public void insertMember(MemberBean mbean) {
	      try {
	         getCon();
	         String sql="insert into member values(?,?,?,?,?,?,?,?)";
	         pstmt=conn.prepareStatement(sql);
	         
	         pstmt.setString(1, mbean.getId());
	         pstmt.setString(2, mbean.getPass1());
	         pstmt.setString(3, mbean.getEmail());
	         pstmt.setString(4, mbean.getTel());
	         pstmt.setString(5, mbean.getHobby());
	         pstmt.setString(6, mbean.getJob());
	         pstmt.setString(7, mbean.getAge());
	         pstmt.setString(8, mbean.getInfo());
	         
	         pstmt.executeUpdate();
	         
	         conn.close();
	         
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	  }
	public Vector<MemberBean> allSelectMember(){
		Vector<MemberBean> v = new Vector<MemberBean>();
		
		try {
			getCon();
			String sql="SELECT * FROM member";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				MemberBean bean = new MemberBean();
				
				bean.setId(rs.getString(1));
				bean.setPass1(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setTel(rs.getString(4));
				bean.setHobby(rs.getString(5));
				bean.setJob(rs.getString(6));
				bean.setAge(rs.getString(7));
				bean.setInfo(rs.getString(8));
				
				v.add(bean); //테이블에 삽입된 정보들을 다 꺼내서 MemverBean필드에 저장
							//저장 후 백터에 삽입
			}
			conn.close();
		}catch (Exception e) {}
		return v;
	}
	public MemberBean oneMember(String id) {
		MemberBean bean = new MemberBean();
		try {
			getCon();
			String sql = "SELECT * FROM member WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bean.setId(rs.getString(1));
				bean.setPass1(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setTel(rs.getString(4));
				bean.setHobby(rs.getString(5));
				bean.setJob(rs.getString(6));
				bean.setAge(rs.getString(7));
				bean.setInfo(rs.getString(8));
			}
			conn.close();
		} catch (Exception e) {}
		return bean;
	}
	
	public String getPass(String id) {
		String pass="";
		try {
			getCon();
			
			String sql = "SELECT pass1 FROM member WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pass=rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pass;
	}
	public void updateMember(MemberBean mbean) {
		try {
			getCon();
			String sql = "UPDATE member SET email=?, tel=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mbean.getEmail());
			pstmt.setString(2, mbean.getTel());
			pstmt.setString(3, mbean.getId());
			
			pstmt.executeUpdate();
			conn.close();
		}catch (Exception e) {}
	}
	public void deleteMember(String id) {
		try {
			getCon();
			String sql = "DELETE FROM member WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			conn.close();
		}catch (Exception e) {}
	}
}

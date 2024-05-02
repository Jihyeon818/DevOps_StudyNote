package bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import bit.dto.MemberBean;

public class MemberDAO {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	private MemberDAO() {
		
	}
	private static MemberDAO instance=new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	//싱글톤: 오로지 한번의 객체 생성으로 메모리 효율적 관리 목적
	
	public Connection getConnection() throws Exception{
		Connection conn = null;
		//server.xml 의 Context에 설정해둔 DB정보를 읽어오는 작업
		Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/pool");	        
        conn = ds.getConnection();

        return conn;		
	}
	
	//사용자 인증
	public int userCheck(String id, String pwd) {
		int result=-1;
		String sql = "SELECT pwd FROM member2 WHERE userid=?";
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) { //아이디가 일치하는 행이 있다면
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)) {
					result=1; //비밀번호도 함께 일치할 경우
				}else {
					result=0; //아이디가 일치하지만 비번이 불일치
				}
			}else { //아이디가 존재하지 않으면
				result=-1; //정보가 없을 경우
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//아이디 기준으로 회원정보 가져오기
	public MemberBean getMember(String userid) {
		MemberBean bean=null;
		String sql = "SELECT * FROM WHERE userid= ?";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bean=new MemberBean();
				bean.setName(rs.getString("name"));
				bean.setUserid(rs.getString("userid"));
				bean.setPwd(rs.getString("pwd"));
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				bean.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				}catch(Exception e) {}
		}
		return bean;
	}
	//ID중복체크
	public int checkID(String userid) {
		int result=-1;
		String sql = "SELECT userid FROM member2 WHERE userid=?";
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=1;
			}else {
				result=-1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}

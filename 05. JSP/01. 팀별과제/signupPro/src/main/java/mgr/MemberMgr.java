package mgr;

import static mgr.DBConnectionMgr.close;
import static mgr.DBConnectionMgr.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MemberBean;
import bean.ZipBean;

public class MemberMgr {
    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    private static MemberMgr memberMgr = new MemberMgr();

    public static MemberMgr getInstance() {return memberMgr;}


    // 멤버빈을 매개변수로 받아서 데이터베이스에 저장
    public void insertMember(MemberBean member) {
        String sql = "insert into members values(?,?,?,?,?,?,?,?,?,?)";

        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPwd());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getGender());
            pstmt.setString(5, member.getEmail());
            pstmt.setString(6, member.getBirth());
            pstmt.setString(7, member.getZipcode());
            pstmt.setString(8, member.getAddress());
            pstmt.setString(9, member.getHobby());
            pstmt.setString(10, member.getJob());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt);
        }
    }

    // id를 매개변수로 받아서 해당하는 멤버의 정보를 멤버빈에 담아서 반환
    public MemberBean findMember(String id) {
        MemberBean bean = new MemberBean();
        String sql = "select * from member where id = ?";

        try {
            conn = DBConnectionMgr.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                bean.setId(rs.getString("id"));
                bean.setPwd(rs.getString("pwd"));
                bean.setName(rs.getString("name"));
                bean.setGender(rs.getString("gender"));
                bean.setEmail(rs.getString("email"));
                bean.setBirth(rs.getString("birth"));
                bean.setZipcode(rs.getString("zipcode"));
                bean.setAddress(rs.getString("address"));
                bean.setHobby(rs.getString("hobby"));
                bean.setJob(rs.getString("job"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionMgr.close(conn, pstmt, rs);
        }
        return bean;
    }

    // zipBean을 매배견수로 받아서 데이터베이스에 저장
    public void insertZip(ZipBean zip) {
        String sql = "insert into members values(?,?,?,?)";

        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, zip.getZipcode());
            pstmt.setString(2, zip.getArea1());
            pstmt.setString(3, zip.getArea2());
            pstmt.setString(4, zip.getArea3());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt);
        }
    }

    // 우편번호를 매개변수로 받아서 해당하는 주소들을 리스트 형태로 반환. size가 0일 경우는 우편번호를 잘못 입력한 것임
    public List<String> searchZip(String zipcode) {
        String sql = "select * from tblZipcode where zipcode = ?";
        List<String> zipList = new ArrayList<>();
        StringBuilder sb;

        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, zipcode);
            rs = pstmt.executeQuery();

            while(rs.next()){
                sb = new StringBuilder();
                sb.append(rs.getString("area1")).append(" ");
                sb.append(rs.getString("area2")).append(" ");
                sb.append(rs.getString("area3"));

                zipList.add(sb.toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

        return zipList;
    }

    // 아이디와 비밀번호를 매개변수로 받아서 결과값 반환. -1이면 오류, 0이면 실패, 1이면 성공
    public int loginCheck(String id, String pwd) {
        String sql = "select count(*) from member where id = ? and pwd = ?";
        int count = -1;

        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();

            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

        return count;
    }

    // id 중복체크. true를 반환하면 중복없음. false를 반환하면 중복있음
    public Boolean checkId(String id) {
        String sql = "select * from member where id = ?";

        try {
            conn = DBConnectionMgr.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnectionMgr.close(conn, pstmt, rs);
        }
    }

}
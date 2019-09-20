package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.ReviewVO;

public class ReviewDAO_Oracle extends ReviewDAO{

	public List<ReviewVO> getReviewRec(){
		String sql = "select * from ( " + 
				"	    select rownum row#,rid,userid,fid,image,text,eval,date " + 
				"	    from (select * from review order by rid desc) " + 
				"	) where row# between ? and ? ";
		
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, 5);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setRid(rs.getInt("rid"));
				vo.setUserid(rs.getString("userid"));
				vo.setFid(rs.getInt("fid"));
				vo.setImage(rs.getString("image"));
				vo.setText(rs.getString("text"));
				vo.setEval(rs.getString("eval"));
				
			}
			
		} catch (Exception e) {
			
		}
		return list;
	}
	
	public int insertReview(ReviewVO vo) throws Exception{
		String sql = "insert into review (rid, userid, fid, image, text, eval, pubdate) " + 
				"      values( (select nvl(max(rid),0)+1 from review ) , ?, ?, ?, ?, ?, sysdate) ";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, vo.getUserid());
			ps.setInt(2, vo.getFid());
			ps.setString(3, vo.getImage());
			ps.setString(4, vo.getText());
			ps.setString(5, vo.getEval());
			
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
		} catch (Exception e) {
//			e.printStackTrace();
			throw e;
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
	}
	
	public int deleteReview(int rid){
		String sql = "delete from review where rid = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setInt(1, rid);
			
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
	}
	
	public int updateReview(ReviewVO vo){
		String sql = "UPDATE review SET image =?, text =?, eval =? where rid = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, vo.getImage());
			ps.setString(2, vo.getText());
			ps.setString(3, vo.getEval());
			
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
	}
	
	
	

}

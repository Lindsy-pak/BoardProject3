package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;

public class BoardDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();

		String sql = "SELECT * FROM lin_t ORDER BY BoardNum DESC";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				list.add(vo);

				int boardNum = rs.getInt("boardNum");
				String title = rs.getString("title");
				Date regidate = rs.getDate("regidate");

				vo.setBoardNum(boardNum);
				vo.setTitle(title);
				vo.setRegidate(regidate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public BoardVO selboard(int num) {
		String sql ="SELECT * FROM lin_t WHERE boardNum= ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();

			if (rs.next()) {
				BoardVO vo = new BoardVO();

				int boardNum = rs.getInt("boardNum");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				Date regidate = rs.getDate("regidate");

				vo.setBoardNum(boardNum);
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setRegidate(regidate);
				
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	public int insertBoard(BoardVO data) {
		String sql = "INSERT INTO lin_t (title, contents) VALUES (?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, data.getTitle());
			ps.setString(2, data.getContents());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}
	
	public int delBoard(BoardVO data) {
		String sql = "DELETE FROM lin_t WHERE boardNum= ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, data.getBoardNum());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}
	
	public int modBoard(BoardVO data) {
		String sql = "UPDATE lin_t SET title = ?, contents = ? WHERE boardNum= ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, data.getTitle());
			ps.setString(2, data.getContents());
			ps.setInt(3, data.getBoardNum());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}
	

}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QnaDAO extends DAOBase{
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private QnaDTO dto = null;
	ArrayList<QnaDTO> dtoList = new ArrayList<QnaDTO>();
	
	public ArrayList<QnaDTO> qnalist(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ss = request.getSession();
		String SQL = "";
		try {
			if(ss.getAttribute("kind").equals("student"))
				SQL="select qna.* from student left join qna on student.id = qna.student_id where student.schoolno='"+ss.getAttribute("uid")+"';";
//			else if(ss.getAttribute("kine").equals("teacher"))
//				SQL="select qna.* from teacher left join qna on ";
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			if(rs.next()) {
				dto = new QnaDTO();
				dto.setId(rs.getInt("id"));
				dto.setStudent_id(rs.getInt("student_id"));
				dto.setLecture_id(rs.getInt("lecture_id"));
				dto.setDay(rs.getString("day"));
				dto.setQatitle(rs.getString("qatitle"));
				dto.setQaask(rs.getString("qaask"));
				dto.setQaanswer(rs.getString("qaanswer"));
				dto.setC_confirm(rs.getBoolean("c_confirm"));
				dtoList.add(dto);
			}
			return dtoList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeDBResources(rs, stmt, pstmt, conn);
		}
			return dtoList;
	}
}

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
	private StudentDTO stdto = null;
	private LectureDTO ltdto = null;
	private TeacherDTO tcdto = null;
	private SubjectDTO sbdto = null;
	
	ArrayList<QnaDTO> dtoList = new ArrayList<QnaDTO>();//
	HttpSession ss = null;
	
	public void qnainfo(HttpServletRequest request, HttpServletResponse response) {
		ss = request.getSession();
	}
	public ArrayList<QnaDTO> qnalist(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ss = request.getSession();
		String SQL = "";
		try {
			if(ss.getAttribute("kind").equals("student"))
				SQL="select * from student left join qna on student.id = qna.student_id left join lecture on lecture.id = qna.lecture_id "
						+ "left join teacher on teacher.id = lecture.teacher_id left join subject on "
						+ "subject.id = lecture.subject_id where student.schoolno='"+(String)ss.getAttribute("uid")+"'";
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				tcdto = new TeacherDTO();
				ltdto = new LectureDTO();
				sbdto = new SubjectDTO();
				
				tcdto.setName(rs.getString("teacher.name"));
				sbdto.setName(rs.getString("subject.name"));
				ltdto.setSubject(sbdto);
				
				dto = new QnaDTO();
				dto.setId(rs.getInt("id"));
				dto.setLecture(ltdto);
				dto.setTeacher(tcdto);
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
			return null;
	}
	/*
	public QnaDTO qnainfo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ss = request.getSession();
		String SQL = "";
		try {
			SQL="select qna.* from qna where qna.id ='"+request.getParameter("no")+"';";
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
			}
			return dto;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeDBResources(rs, stmt, pstmt, conn);
		}
			return dto;
	}
	
	*/
}

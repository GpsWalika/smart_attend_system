package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//select DISTINCT min(subject.yyyy) as minyear, max(subject.yyyy) as maxyear from subject
//select depart.name, teacher.name, subject.name, subject.grade, lecture.class, lectureday.* from subject left join lecture on lecture.subject_id = subject.id left join lectureday on lectureday.lecture_id = lecture.id left join room on room.id = lectureday.room_id left join teacher on teacher.id = lecture.teacher_id left join depart on depart.id = teacher.depart_id where subject.yyyy=2019 and subject.term = 2 and lectureday.normstate='3'
public class ADRemoveDAO extends DAOBase{
	Connection conn = null; 
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 
	HttpSession sesobj = null;
	public int []Year(HttpServletRequest request, HttpServletResponse response) {
		int _Year[] = new int[2];
		try {
			String query="select DISTINCT min(subject.yyyy) as minyear, max(subject.yyyy) as maxyear from subject";
			conn = getConnection();
			stmt = conn.createStatement();
	    	ResultSet rs = null;
			rs = stmt.executeQuery(query);
			rs.next();
			_Year[0] = rs.getInt("minyear");
			_Year[1] = rs.getInt("maxyear");
			return _Year;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {	closeDBResources(rs, stmt, pstmt, conn);	}
		return null;
	}
}

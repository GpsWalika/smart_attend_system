package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

//select DISTINCT min(subject.yyyy) as minyear, max(subject.yyyy) as maxyear from subject
//select depart.name, teacher.name, subject.name, subject.grade, lecture.class, lectureday.* from subject left join lecture on lecture.subject_id = subject.id left join lectureday on lectureday.lecture_id = lecture.id left join room on room.id = lectureday.room_id left join teacher on teacher.id = lecture.teacher_id left join depart on depart.id = teacher.depart_id where subject.yyyy=2019 and subject.term = 2 and lectureday.normstate='3'
public class ADRemoveDAO extends DAOBase{
	Connection conn = null; 
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 
	HttpSession sesobj = null;
}

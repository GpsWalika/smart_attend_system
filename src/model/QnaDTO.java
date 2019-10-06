package model;

public class QnaDTO {
	int id;
	StudentDTO student;
	LectureDTO lecture;
	TeacherDTO teacher;
	String day;
	String qatitle;
	String qaask;
	String qaanswer;
	boolean c_confirm;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	public LectureDTO getLecture() {
		return lecture;
	}
	public void setLecture(LectureDTO lecture) {
		this.lecture = lecture;
	}
	public TeacherDTO getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherDTO teacher) {
		this.teacher = teacher;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getQatitle() {
		return qatitle;
	}
	public void setQatitle(String qatitle) {
		this.qatitle = qatitle;
	}
	public String getQaask() {
		return qaask;
	}
	public void setQaask(String qaask) {
		this.qaask = qaask;
	}
	public String getQaanswer() {
		return qaanswer;
	}
	public void setQaanswer(String qaanswer) {
		this.qaanswer = qaanswer;
	}
	public boolean getC_confirm() {
		return c_confirm;
	}
	public void setC_confirm(boolean c_confirm) {
		this.c_confirm = c_confirm;
	}
	
	
}

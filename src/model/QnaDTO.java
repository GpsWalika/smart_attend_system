package model;

public class QnaDTO {
	int id;
	int student_id;
	int lecture_id;
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
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
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
	public boolean isC_confirm() {
		return c_confirm;
	}
	public void setC_confirm(boolean c_confirm) {
		this.c_confirm = c_confirm;
	}
}

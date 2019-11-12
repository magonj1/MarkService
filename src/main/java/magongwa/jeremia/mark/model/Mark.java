package magongwa.jeremia.mark.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Mark")
public class Mark {

	@Id
	private ObjectId Mark_id;
	private String studentId;
	private String subjectId;
	@Field("markDate")
	private LocalDate markDate;
	private int markValue;
	
	
	
	public Mark(String studentId, String subjectId, LocalDate markDate, int markValue) {
		super();
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.markDate = markDate;
		this.markValue = markValue;
	}
	
	public ObjectId getMark_id() {
		return Mark_id;
	}
	public void setMark_id(ObjectId mark_id) {
		Mark_id = mark_id;
	}
	public String getStudent_id() {
		return studentId;
	}
	public void setStudent_id(String studentId) {
		this.studentId = studentId;
	}
	public String getSubject_id() {
		return subjectId;
	}
	public void setSubject_id(String subjectId) {
		this.subjectId = subjectId;
	}
	public LocalDate getMarkDate() {
		return markDate;
	}
	public void setMarkDate(LocalDate markDate) {
		this.markDate = markDate;
	}
	public int getMarkValue() {
		return markValue;
	}
	public void setMarkValue(int markValue) {
		this.markValue = markValue;
	}

	@Override
	public String toString() {
		return "Mark [Mark_id=" + Mark_id + ", student_id=" + studentId + ", subject_id=" + subjectId + ", markDate="
				+ markDate + ", markValue=" + markValue + "]";
	}
	
	
	
	
}
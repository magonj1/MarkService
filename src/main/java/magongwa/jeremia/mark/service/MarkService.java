package magongwa.jeremia.mark.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import magongwa.jeremia.mark.model.Mark;
import magongwa.jeremia.mark.repository.MarkRepository;


@Service
public class MarkService {

   @Autowired
   private MarkRepository markRepository;
   
   public Mark create(String student_id, String subject_id, LocalDate markDate, int markValue)
	{
		return markRepository.save(new Mark(student_id, subject_id, markDate, markValue));
	}
	public List<Mark> getAll()
	{
		return markRepository.findAll();
	}
	
	public Mark getByStudentId(String studentId)
	{
		return markRepository.findByStudentId(studentId);
	}
	public Mark getBySubjectId(String subjectID)
	{
		return markRepository.findBySubjectId(subjectID);
	}	
	
	public Mark update(String student_id,int markValue)
	{
		Mark mark = markRepository.findByStudentId(student_id);
		mark.setMarkValue(markValue);
		
		return markRepository.save(mark);
	}
	public void deleteAll()
	{
		markRepository.deleteAll();
	}
	public void delete(String student_id)
	{
		Mark mark = markRepository.findByStudentId(student_id);
		markRepository.delete(mark);
	}
   
}

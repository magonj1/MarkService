package magongwa.jeremia.mark.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import magongwa.jeremia.mark.model.Mark;
import magongwa.jeremia.mark.service.MarkService;



@RestController
public class MarkController {

	@Autowired
	private MarkService markService;
	
	@RequestMapping("/create")
	public String Create(@RequestParam String student_id,@RequestParam String subject_id ,@RequestParam String markDate ,@RequestParam int markValue )
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate localDate = LocalDate.parse(markDate, formatter);
		Mark mark  = markService.create( student_id,  subject_id, localDate, markValue);
	
		return mark.toString();
	}
	@RequestMapping("/getAll")
	public List<Mark> getMarks()
	{
		return markService.getAll();
	}
	@RequestMapping("/get")
	public Mark getMark(@RequestParam String studentId)
	{
		return markService.getByStudentId(studentId);
	}
	@RequestMapping("/update")
	public String update(@RequestParam String studentId,@RequestParam int markValue)
	{
		return markService.update(studentId,markValue).toString();
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam String studentId)
	{
		markService.delete(studentId);
		return "Deleted "+studentId;
	}
	@RequestMapping("/deleteAll")
	public String deleteAll()
	{
		markService.deleteAll();
		return "Deleted all the Records";
	}
	
	
}

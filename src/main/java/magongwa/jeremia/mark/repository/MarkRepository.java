package magongwa.jeremia.mark.repository;

import magongwa.jeremia.mark.model.Mark;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends MongoRepository<Mark,ObjectId> {

	public  Mark findByStudentId(String studentId);
	public  Mark findBySubjectId(String subjectId);
	
	
}

package magongwa.jeremia.mark.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import magongwa.jeremia.mark.model.Mark;
import magongwa.jeremia.mark.repository.MarkRepository;


@Service
public class MarkService {

   @Autowired
   private MarkRepository markRepository;
   
   public List<Mark> findAll() {
       return markRepository.findAll();
   }

   public Optional<Mark> findById(String id) {
       return markRepository.findById(id);
   }

   public Mark save(Mark mark) {
       return markRepository.save(mark);
   }

   public void deleteById(String id) {
	   markRepository.deleteById(id);
   }
   
}

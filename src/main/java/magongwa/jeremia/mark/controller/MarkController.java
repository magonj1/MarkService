package magongwa.jeremia.mark.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import magongwa.jeremia.mark.model.Mark;
import magongwa.jeremia.mark.service.MarkService;



@CrossOrigin(origins = {"http://localhost:4200"},maxAge = 4800, allowedHeaders = "*",allowCredentials = "false")
@RestController
@RequestMapping(path = "Api/Mark")
public class MarkController {

	@Autowired
	private MarkService markService;
	
	 @GetMapping
	    public ResponseEntity<List<Mark>> findAll() {
	        return ResponseEntity.ok(markService.findAll());
	    }

	    @PostMapping
	    public ResponseEntity create(@Valid @RequestBody Mark product) {
	        return ResponseEntity.ok(markService.save(product));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Mark> findById(@PathVariable String id) {
	        Optional<Mark> mark = markService.findById(id);
	        if (!mark.isPresent()) {
	           
	            ResponseEntity.badRequest().build();
	        }

	        return ResponseEntity.ok(mark.get());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Mark> update(@PathVariable String id, @Valid @RequestBody Mark product) {
	        if (!markService.findById(id).isPresent()) {
	       
	            ResponseEntity.badRequest().build();
	        }

	        return ResponseEntity.ok(markService.save(product));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity delete(@PathVariable String id) {
	        if (!markService.findById(id).isPresent()) {
	           
	            ResponseEntity.badRequest().build();
	        }

	        markService.deleteById(id);

	        return ResponseEntity.ok().build();
	    }
	
	
}

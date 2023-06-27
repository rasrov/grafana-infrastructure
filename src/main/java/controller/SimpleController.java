package controller;

import jakarta.validation.Valid;
import model.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.SimpleService;

import java.util.Optional;

@RestController
@RequestMapping("/simple")
public class SimpleController {

  @Autowired
  private SimpleService simpleService;

  @PostMapping
  public ResponseEntity<Simple> saveSimple(@Valid @RequestBody Simple simple) {
    return ResponseEntity.status(HttpStatus.CREATED).body(simpleService.saveSimple(simple));
  }

  @GetMapping
  public ResponseEntity<Page<Simple>> getAllSimple(
      @RequestParam(required = false, defaultValue = "0") Integer page,
      @RequestParam(required = false, defaultValue = "10") Integer size,
      @RequestParam(required = false, defaultValue = "false") Boolean enablePagination) {
    return ResponseEntity.ok(simpleService.getAllSimple(page, size, enablePagination));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity deleteSimple(@PathVariable("id") Long id) {
    simpleService.deleteSimple(id);
    return ResponseEntity.ok(!simpleService.existById(id));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Optional<Simple>> findSimpleById(@PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(simpleService.findById(id));
  }

  @PutMapping
  public ResponseEntity<Simple> editSimple(@Valid @RequestBody Simple simple) {
    return ResponseEntity.status(HttpStatus.CREATED).body(simpleService.editSimple(simple));
  }

}

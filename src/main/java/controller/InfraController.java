package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfraController {

  @GetMapping("/message")
  public String getMessage() {
    return "test-message";
  }

}

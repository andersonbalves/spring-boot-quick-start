package com.oop.demo.infra.hello;

import com.oop.demo.service.hello.HelloWorldUseCase;
import com.oop.demo.service.hello.dto.HelloWorldRequest;
import com.oop.demo.service.hello.dto.HelloWorldResponse;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

  public static final String BEM_VINDO = "Bem vindo %s! Ouvi dizer que sua idade é %s anos. =)";
  @Autowired
  HelloWorldUseCase service;

  @GetMapping("/hello-world")
  public @ResponseBody ResponseEntity<String> getHelloWorldMessage(
      @RequestParam(value = "name") String name,
      @RequestParam(value="birthday") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthday) {
    HelloWorldRequest request = HelloWorldRequest.builder()
        .nome(name)
        .dataNascimento(birthday)
        .build();

    HelloWorldResponse response = service.execute(request);

    String message = String.format(BEM_VINDO, response.getNome(),
        response.getIdade());

    return ResponseEntity.ok(message);
  }
}

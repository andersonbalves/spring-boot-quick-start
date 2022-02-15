package com.oop.demo.service.hello;

import com.oop.demo.service.hello.dto.HelloWorldRequest;
import com.oop.demo.service.hello.dto.HelloWorldResponse;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldUseCase {

  public HelloWorldResponse execute(HelloWorldRequest request) {
    Period periodo = Period.between(request.getDataNascimento(), LocalDate.now());
    return HelloWorldResponse.builder()
        .nome(request.getNome())
        .idade(periodo.getYears())
        .build();
  }

}

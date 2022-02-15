package com.oop.demo.service.hello.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloWorldResponse {
  private String nome;
  private Integer idade;
}

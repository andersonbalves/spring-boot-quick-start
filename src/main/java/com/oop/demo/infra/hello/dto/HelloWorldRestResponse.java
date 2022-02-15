package com.oop.demo.infra.hello.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloWorldRestResponse {
  private String message;
}

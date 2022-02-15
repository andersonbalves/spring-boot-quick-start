package com.oop.demo.service.hello.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloWorldRequest {
    private String nome;
    private LocalDate dataNascimento;
}

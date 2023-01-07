package com.qzce.boardtalk.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String HttpStatus;
    private String HttpMethod;
    private String message;

    private List<Errors> errors;

    @Getter
    @NoArgsConstructor
    public static class Errors {
        private String field;
        private String result;
    }
}



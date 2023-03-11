package com.rochards.demoapp.author;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AuthorResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final LocalDate birthdate;
    private final LocalDateTime createdAt;
}

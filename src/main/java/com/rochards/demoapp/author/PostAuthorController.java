package com.rochards.demoapp.author;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("authors")
@AllArgsConstructor
public class PostAuthorController {

    private static final Logger LOGGER = LogManager.getLogger(PostAuthorController.class);

    private final AuthorRepository authorRepository;

    @PostMapping
    public ResponseEntity<AuthorResponse> create(@RequestBody @Valid AuthorRequest authorRequest) {
        LOGGER.info("Starting saving new author: {}", authorRequest);
        AuthorModel newAuthor = AuthorModelMapper.requestToModel(authorRequest);

        LOGGER.info("Saving author in database");
        newAuthor= authorRepository.save(newAuthor);
        LOGGER.info("New author inserted successfully: {}", newAuthor);

        AuthorResponse authorResponse = AuthorModelMapper.modelToResponse(newAuthor);

        LOGGER.info("Finishing saving new author");
        return ResponseEntity.ok(authorResponse);
    }
}

package com.rochards.demoapp.author;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("authors")
@AllArgsConstructor
public class GetAuthor {

    private static final Logger LOGGER = LogManager.getLogger(GetAuthor.class);

    private final AuthorRepository authorRepository;
    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllByPage(@RequestParam(value = "page", defaultValue = "0") int page,
                                                             @RequestParam(value = "size", defaultValue = "10") @Max(100) int size) {
        LOGGER.info("Starting getAllByPage. page = {}, size = {}", page, size);
        Page<AuthorModel> authors = authorRepository.findAll(PageRequest.of(page, size));
        List<AuthorResponse> authorResponses = authors.stream()
                .map(AuthorModelMapper::modelToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(authorResponses);
    }
}

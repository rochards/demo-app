package com.rochards.demoapp.author;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest // esta anotação não nos permite mockar o repository, só se fosse uma classe em vez de interface
@AutoConfigureMockMvc
class PostAuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
//    @Autowired nao preciso injetar aqui, o proprio spring vai se encarregar de disso quando chamar o controller
//    private AuthorRepository authorRepository;

    @Test
    void createValidateAuthor() throws Exception {
        AuthorRequest authorRequest = new AuthorRequest("Machado de Assis", "assis@gmail.com", LocalDate.of(1989, 6, 21));

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/authors")
                                .content(objectMapper.writeValueAsString(authorRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Machado de Assis")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.is("assis@gmail.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthdate", Matchers.is(LocalDate.of(1989, 6, 21).toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").isString());
    }
}
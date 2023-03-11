package com.rochards.demoapp.author;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "author")
public class AuthorModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String name;
    @Column(unique = true)
    @EqualsAndHashCode.Include
    private String email;
    @Column(nullable = false)
    private LocalDate birthdate;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Deprecated
    public AuthorModel() {
    }

    public AuthorModel(String name, String email, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
    }
}



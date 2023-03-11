package com.rochards.demoapp.author;

public class AuthorModelMapper {
    private AuthorModelMapper() {
    }

    public static AuthorModel requestToModel(AuthorRequest authorRequest) {
        return new AuthorModel(
                authorRequest.getName(),
                authorRequest.getEmail(),
                authorRequest.getBirthdate()
        );
    }

    public static AuthorResponse modelToResponse(AuthorModel authorModel) {
        return new AuthorResponse(
                authorModel.getId(),
                authorModel.getName(),
                authorModel.getEmail(),
                authorModel.getBirthdate(),
                authorModel.getCreatedAt()
        );
    }
}

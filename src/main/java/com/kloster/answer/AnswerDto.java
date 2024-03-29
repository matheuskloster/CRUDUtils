package com.kloster.answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AnswerDto {

    @JsonIgnore
    private Long id;
    private String texto;
    private String username;
}
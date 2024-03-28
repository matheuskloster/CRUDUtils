package com.kloster.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OtherDto {

    @JsonIgnore
    private Long id;
    private String nome;
    private String email;

}
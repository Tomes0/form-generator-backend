package com.econsult.formgenerator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormMinimal {
    private Long id;
    private String name;
    private String code;
}

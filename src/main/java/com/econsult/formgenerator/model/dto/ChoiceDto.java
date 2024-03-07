package com.econsult.formgenerator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceDto {
    private Long id;
    private String code;
    private String name;
    private List<PropertyDto> propertyList;
    private Long ordinalPosition;
}

package com.econsult.formgenerator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldDto {
    private Long id;
    private String code;
    private String name;
    private Long ordinalPosition;
    private String fieldType;
    private Boolean hasDependency;
    private List<PropertyDto> propertyList;
    private List<ChoiceDto> choices;
}

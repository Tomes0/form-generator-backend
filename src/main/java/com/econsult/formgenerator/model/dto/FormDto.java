package com.econsult.formgenerator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormDto {

    private Long id;
    private String code;
    private String name;
    private Date creationDate;
    private Date lastModificationDate;
    private Boolean isValid;
    private List<PropertyDto> propertyList;
    private List<GroupDto> groups;
}

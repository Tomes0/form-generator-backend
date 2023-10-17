package com.econsult.formgenerator.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "bcp_messages")
public class Form {

    private Long id;
    private String name;
    private String code;
}

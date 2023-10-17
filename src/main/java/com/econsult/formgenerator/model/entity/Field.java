package com.econsult.formgenerator.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "field")
public class Field {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "code")
    private String code;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "ordinal_position")
    private Long ordinalPosition;

    @Column(name = "field_type")
    private String fieldType;

    @Column(name = "has_dependency")
    private Boolean hasDependency;

    //TODO: add dependency logic

    @Column(name = "custom_properties")
    private String customProperties;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Choice> choices;
}

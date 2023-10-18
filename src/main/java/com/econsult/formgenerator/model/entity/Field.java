package com.econsult.formgenerator.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "form_group_field")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "ordinal_position")
    private Long ordinalPosition;
    private String fieldType;

    @Column(name = "has_dependency")
    private Boolean hasDependency;

    //TODO dependency

    @Column(name = "custom_properties")
    private String customProperties;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<Choice> choices;
}

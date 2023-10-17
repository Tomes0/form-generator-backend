package com.econsult.formgenerator.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "group")
public class Group {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "code")
    private String code;

    @Column(name= "name")
    private String name;

    @Column(name = "form_id")
    private Long formId;

    @Column(name = "ordinal_position")
    private Long ordinalPosition;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Field> fields;
}

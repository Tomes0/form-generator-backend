package com.econsult.formgenerator.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "choice")
public class Choice {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "field_id")
    private Long fieldId;

    @Column(name = "ordinal_position")
    private Long ordinalPosition;
}

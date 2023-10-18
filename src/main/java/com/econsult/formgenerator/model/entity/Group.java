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
@Table(name = "form_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    @Column(name = "ordinal_position")
    private Long ordinalPosition;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Field> fields;
}

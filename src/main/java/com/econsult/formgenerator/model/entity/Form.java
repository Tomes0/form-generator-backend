package com.econsult.formgenerator.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "last_modifier_id")
    private Long lastModifierDate;

    @Column(name = "last_modification_date")
    private Date lastModificationDate;
}

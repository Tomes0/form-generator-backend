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
@Table(name = "form")
public class Form {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "last_modifier_id")
    private Long lastModifierDate;

    @Column(name = "last_modification_date")
    private Date lastModificationDate;

    @Column(name = "is_valid")
    private Boolean isValid;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Group> groups;
}

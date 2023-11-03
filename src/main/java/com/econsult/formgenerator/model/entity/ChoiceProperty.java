package com.econsult.formgenerator.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "form_group_field_choice_property")
public class ChoiceProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "property_name")
    private String propertyName;

    @Column(name = "property_value")
    private String propertyValue;

    @ManyToOne
    @JoinColumn(name = "choice_id")
    private Choice choice;
}

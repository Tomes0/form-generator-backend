package com.econsult.formgenerator.repository;

import com.econsult.formgenerator.model.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

    ArrayList<Form> getAllByIsValid(Boolean isValid);

    Form findByCode(String code);
}

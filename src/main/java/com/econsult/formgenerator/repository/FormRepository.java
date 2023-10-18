package com.econsult.formgenerator.repository;

import com.econsult.formgenerator.model.entity.Form;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FormRepository extends CrudRepository<Form, Long> {

    ArrayList<Form> getAllByIsValid(Boolean isValid);
}

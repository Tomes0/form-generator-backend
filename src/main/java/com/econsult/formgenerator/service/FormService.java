package com.econsult.formgenerator.service;

import com.econsult.formgenerator.model.dto.FormDto;
import com.econsult.formgenerator.model.dto.FormMinimal;
import org.springframework.http.HttpStatus;

public interface FormService {

    /**
     * Returns all form minimals from database.
     *
     * @return an array of FormMinimal
     */
    FormMinimal[] getFormMinimals();

    FormDto saveForm(FormDto form);

    FormDto createNewForm(String form);

    FormDto getFormByCode(String code);

    HttpStatus deleteForm(String code);
}

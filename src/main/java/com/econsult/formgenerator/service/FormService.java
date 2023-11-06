package com.econsult.formgenerator.service;

import com.econsult.formgenerator.model.dto.FormDto;
import com.econsult.formgenerator.model.dto.FormMinimal;

public interface FormService {

    /**
     * Returns all form minimals from database.
     *
     * @return an array of FormMinimal
     */
    FormMinimal[] getFormMinimals();

    FormDto saveForm(FormDto form);

    FormDto initForm(FormDto form);

    FormDto getFormByCode(String code);
}

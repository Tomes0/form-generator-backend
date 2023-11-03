package com.econsult.formgenerator.service;

import com.econsult.formgenerator.model.dto.FormMinimal;
import com.econsult.formgenerator.model.entity.Form;

import java.util.List;

public interface FormService {

    /**
     * Returns all form minimals from database.
     *
     * @return a list of FormMinimal
     * */
    List<FormMinimal> getFormMinimals();

    Form saveForm(Form form);

    Form initForm(Form form);

    Form getFormFromCode(String code);

    Form saveFormFromCode(Form form);
}

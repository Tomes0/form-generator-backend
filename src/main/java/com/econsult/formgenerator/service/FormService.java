package com.econsult.formgenerator.service;

import com.econsult.formgenerator.model.dto.FormMinimal;

import java.util.List;

public interface FormService {

    /**
     * Returns all form minimals from database.
     *
     * @return a list of FormMinimal
     * */
    List<FormMinimal> getFormMinimals();
}

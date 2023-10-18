package com.econsult.formgenerator.service.impl;

import com.econsult.formgenerator.model.dto.FormMinimal;
import com.econsult.formgenerator.service.FormService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FormServiceImpl implements FormService {

    private final ModelMapper modelMapper;


    public FormServiceImpl(ModelMapper modelMapper ) {
        this.modelMapper = modelMapper;
    }


    @Override
    public List<FormMinimal> getFormMinimals() {
        List<FormMinimal> list = new ArrayList<FormMinimal>();

        return list;
    }
}

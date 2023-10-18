package com.econsult.formgenerator.service.impl;

import com.econsult.formgenerator.model.dto.FormMinimal;
import com.econsult.formgenerator.model.entity.Form;
import com.econsult.formgenerator.repository.FormRepository;
import com.econsult.formgenerator.service.FormService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FormServiceImpl implements FormService {

    private final FormRepository formRepository;
    private final ModelMapper modelMapper;


    public FormServiceImpl(ModelMapper modelMapper, FormRepository formRepository ) {
        this.modelMapper = modelMapper;
        this.formRepository = formRepository;
    }


    @Override
    public List<FormMinimal> getFormMinimals() {
        List<FormMinimal> list = Arrays
                .stream(this.formRepository.getAllByIsValid(true).toArray(Form[]::new))
                .map(form -> modelMapper.map(form, FormMinimal.class))
                .collect(Collectors.toList());

        return list;
    }
}

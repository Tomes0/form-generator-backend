package com.econsult.formgenerator.service.impl;

import com.econsult.formgenerator.model.dto.FormDto;
import com.econsult.formgenerator.model.dto.FormMinimal;
import com.econsult.formgenerator.model.entity.Form;
import com.econsult.formgenerator.model.entity.Group;
import com.econsult.formgenerator.repository.FormRepository;
import com.econsult.formgenerator.service.FormService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public FormMinimal[] getFormMinimals() {
        return Arrays
            .stream(this.formRepository.getAllByIsValid(true).toArray(Form[]::new))
            .map(form -> modelMapper.map(form, FormMinimal.class))
            .toList().toArray(FormMinimal[]::new);
    }

    @Override
    public FormDto saveForm(FormDto req) {
        Form newForm = modelMapper.map(req, Form.class);

        List<Group> groups = newForm
                .getGroups()
                .stream()
                .peek(group -> group.setForm(newForm))
                .toList();

        newForm.setGroups(groups);

        this.formRepository.save(newForm);
        return req;
    }

    @Override
    public FormDto initForm(FormDto req) {
        Form newForm = modelMapper.map(req, Form.class);
        this.formRepository.save(newForm);
        return req;
    }

    @Override
    public FormDto getFormByCode(String code) {
        return modelMapper.map(this.formRepository.findTopByCode(code), FormDto.class) ;
    }
}

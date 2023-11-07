package com.econsult.formgenerator.service.impl;

import com.econsult.formgenerator.model.dto.CreateFormDto;
import com.econsult.formgenerator.model.dto.FormDto;
import com.econsult.formgenerator.model.dto.FormMinimal;
import com.econsult.formgenerator.model.entity.Form;
import com.econsult.formgenerator.model.entity.Group;
import com.econsult.formgenerator.repository.FormRepository;
import com.econsult.formgenerator.service.FormService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
        Form form = this.formRepository.findByCode(req.getCode());
        Form newForm = modelMapper.map(req, Form.class);

        List<Group> updatedGroups = newForm.getGroups().stream().peek(group -> group.setForm(form)).toList();

        form.getGroups().clear();
        form.getGroups().addAll(updatedGroups);

        form.setIsValid(newForm.getIsValid());
        form.setCode(newForm.getCode());
        form.setCreationDate(newForm.getCreationDate());
        form.setLastModificationDate(newForm.getLastModificationDate());

        this.formRepository.saveAndFlush(form);
        return req;
    }


    @Override
    public FormDto createNewForm(CreateFormDto req) {
        Form newForm = new Form();
        newForm.setName(req.getFormName());
        newForm.setCode(req.getFormName().toUpperCase().replace(" ", "_"));
        newForm.setIsValid(true);

        this.formRepository.saveAndFlush(newForm);
        return modelMapper.map(newForm, FormDto.class);
    }

    @Override
    public FormDto getFormByCode(String code) {
        return modelMapper.map(this.formRepository.findByCode(code), FormDto.class) ;
    }

    @Override
    public HttpStatus deleteForm(String code) {
        Form toBeDeleted = this.formRepository.findByCode(code);

        if(toBeDeleted != null){
            this.formRepository.delete(toBeDeleted);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }
}

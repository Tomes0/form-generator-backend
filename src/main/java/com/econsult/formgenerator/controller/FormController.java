package com.econsult.formgenerator.controller;


import com.econsult.formgenerator.model.dto.FormMinimal;
import com.econsult.formgenerator.model.entity.Form;
import com.econsult.formgenerator.service.FormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Form APIs")
@RestController
@CrossOrigin
@RequestMapping("/rest/form")
public class FormController {
    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @Operation(summary = "Returns all the form minimals from the database")
    @GetMapping("/getFormMinimals")
    private ResponseEntity<FormMinimal[]> getFormMinimals(){
        FormMinimal[] formMinimals = formService.getFormMinimals().toArray(FormMinimal[]::new);
        return ResponseEntity.ok(formMinimals);
    }

    @Operation(summary = "Returns all the form minimals from the database")
    @GetMapping("/getFormFromCode")
    private ResponseEntity<Form> getFormFromCode(@RequestParam  String code){
        return ResponseEntity.ok(formService.getFormFromCode(code));
    }

    @Operation(summary = "Create new form")
    @PostMapping("/saveForm")
    private ResponseEntity<Form> createForm(@RequestBody Form form){
        return ResponseEntity.ok(formService.saveForm(form));
    }

    @Operation(summary = "Initialize new form")
    @PostMapping("/initForm")
    private ResponseEntity<Form> initForm(@RequestBody Form form){
        return ResponseEntity.ok(formService.initForm(form));
    }

}

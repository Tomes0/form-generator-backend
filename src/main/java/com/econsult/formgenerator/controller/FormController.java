package com.econsult.formgenerator.controller;


import com.econsult.formgenerator.model.dto.FormDto;
import com.econsult.formgenerator.model.dto.FormMinimal;
import com.econsult.formgenerator.service.FormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(formService.getFormMinimals());
    }
    @Operation(summary = "Returns all the form minimals from the database")
    @GetMapping("/getFormByCode")
    private ResponseEntity<FormDto> getFormByCode(@RequestParam  String code){
        return ResponseEntity.ok(formService.getFormByCode(code));
    }
    @Operation(summary = "Create new form")
    @PostMapping("/saveForm")
    private ResponseEntity<FormDto> saveForm(@RequestBody FormDto form){
        return ResponseEntity.ok(formService.saveForm(form));
    }
    @Operation(summary = "Create new form")
    @PostMapping("/createNewForm")
    private ResponseEntity<FormDto> createNewForm(@RequestBody String formName){
        return ResponseEntity.ok(formService.createNewForm(formName));
    }

    @Operation(summary = "Delete form")
    @DeleteMapping("/deleteForm/{code}")
    private HttpStatus deleteForm(@PathVariable String code){
        return formService.deleteForm(code);
    }
}

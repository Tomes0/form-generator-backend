package com.econsult.formgenerator.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Form APIs")
@RestController
@CrossOrigin
@RequestMapping("/rest/form")
public class FormController {

    @Operation(summary = "Returns all the form minimals from the database")
    @GetMapping("/getFormMinimals")
    public void getFormMinimals(){
    }

}

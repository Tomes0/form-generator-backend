package com.econsult.formgenerator.util;

import com.econsult.formgenerator.model.entity.*;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class FormCollectionUpdates {

    public static void updateGroups(Form newForm, Form form) {
        List<Group> updatedGroups = newForm
                .getGroups()
                .stream()
                .peek(group -> group.setForm(form))
                .peek(group -> updateFields(group))
                .toList();

        updateFormProperties(newForm, form);

        form.getGroups().clear();
        form.getGroups().addAll(updatedGroups);
    }

    public static void updateFormProperties(Form newForm, Form form) {
        List<FormProperty> updatedProperties = newForm
                .getPropertyList()
                .stream()
                .peek(property -> property.setForm(form))
                .toList();

        form.getPropertyList().clear();
        form.getPropertyList().addAll(updatedProperties);
    }

    public static void updateFields(Group group){
        List<Field> fields = group
                .getFields()
                .stream()
                .peek(field -> field.setGroup(group))
                .toList();

        updateFieldProperties(group);

        group.getFields().clear();
        group.getFields().addAll(fields);
    }

    public static void updateFieldProperties(Group group){
        List<GroupProperty> updatedProperties = group
                .getPropertyList()
                .stream()
                .peek(property -> property.setGroup(group))
                .toList();

        group.getPropertyList().clear();
        group.getPropertyList().addAll(updatedProperties);
    }
}

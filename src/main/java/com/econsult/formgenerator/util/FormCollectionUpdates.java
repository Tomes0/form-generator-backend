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
                .peek(FormCollectionUpdates::updateFields)
                .toList();

        updateFormProperties(newForm, form);

        form.getGroups().clear();
        form.getGroups().addAll(updatedGroups);
    }

    private static void updateFormProperties(Form newForm, Form form) {
        List<FormProperty> updatedProperties = newForm
                .getPropertyList()
                .stream()
                .peek(property -> property.setForm(form))
                .toList();

        form.getPropertyList().clear();
        form.getPropertyList().addAll(updatedProperties);
    }

    private static void updateFields(Group group){
        List<Field> fields = group
                .getFields()
                .stream()
                .peek(field -> field.setGroup(group))
                .peek(FormCollectionUpdates::updateChoices)
                .toList();

        updateGroupProperties(group);

        group.getFields().clear();
        group.getFields().addAll(fields);
    }

    private static void updateGroupProperties(Group group){
        List<GroupProperty> updatedProperties = group
                .getPropertyList()
                .stream()
                .peek(property -> property.setGroup(group))
                .toList();

        group.getPropertyList().clear();
        group.getPropertyList().addAll(updatedProperties);
    }

    private static void updateChoices(Field field) {
        List<Choice> choices = field
                .getChoices()
                .stream()
                .peek(choice -> choice.setField(field))
                .toList();

        updateFieldProperties(field);

        field.getChoices().clear();
        field.getChoices().addAll(choices);

        choices = field
                .getChoices()
                .stream()
                .peek(FormCollectionUpdates::updateChoiceProperties)
                .toList();

        field.getChoices().clear();
        field.getChoices().addAll(choices);
    }

    private static void updateFieldProperties(Field field) {
        List<FieldProperty> updatedProperties = field
                .getPropertyList()
                .stream()
                .peek(property -> property.setField(field))
                .toList();

        field.getPropertyList().clear();
        field.getPropertyList().addAll(updatedProperties);
    }

    private static void updateChoiceProperties(Choice choice) {
        List<ChoiceProperty> updatedProperties = choice
                .getPropertyList()
                .stream()
                .peek(property -> property.setChoice(choice))
                .toList();

        choice.getPropertyList().clear();
        choice.getPropertyList().addAll(updatedProperties);
    }
}

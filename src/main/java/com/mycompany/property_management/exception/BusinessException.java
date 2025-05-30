package com.mycompany.property_management.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    private List<ErrorModel> errors;

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorModel> errors) {
        this.errors = errors;
    }

    public BusinessException(List<ErrorModel> errors){
        this.errors = errors;
    }
}

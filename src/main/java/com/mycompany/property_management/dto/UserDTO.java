package com.mycompany.property_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private String ownerName;
    @NotNull(message = "Owner Email is compulsory")
    @Size(min = 1, max = 50, message = "Owner Email should be between 1 to 50 characters")
    @NotEmpty(message = "Owner Email cannot be empty")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 6, max = 13, message = "Password should contain between 6 to 13 characters")
    private String password;


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.exception.BusinessException;
import com.mycompany.property_management.exception.ErrorModel;
import com.mycompany.property_management.repository.UserRepository;
import com.mycompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optUe =userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if (optUe.isPresent()){

            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Email already exist");
            errorModel.setMessage("This Email already Exist");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity= userRepository.save(userEntity);
        userDTO = userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        if(optionalUserEntity.isPresent()){
            userDTO = userConverter.convertEntitytoDTO(optionalUserEntity.get());
        }
        else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Invalid_Login");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}

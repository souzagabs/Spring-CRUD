package com.dia312.springcrud.controllers;

import com.dia312.springcrud.dto.UsersRecordDto;
import com.dia312.springcrud.model.UsersModel;
import com.dia312.springcrud.repository.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsersModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(usersRepository.findAll());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id")UUID id){
        Optional<UsersModel> user0= usersRepository.findById(id);
        if(user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user0.get());
    }

    @PostMapping("/usuarios")
    public ResponseEntity<UsersModel> saveUser(@RequestBody @Valid UsersRecordDto usersRecordDto){
        var usersModel = new UsersModel();
        BeanUtils.copyProperties(usersRecordDto, usersModel) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(usersRepository.save(usersModel));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable (value="id") UUID id){
        Optional<UsersModel>user0=usersRepository.findById(id);
            if (user0.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }

            usersRepository.delete(user0.get());
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
        }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable (value="id") UUID id,@RequestBody @Valid UsersRecordDto usersRecordDto){
        Optional<UsersModel>user0=usersRepository.findById(id);
        if (user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        var usersModel = user0.get();
        BeanUtils.copyProperties(usersRecordDto, usersModel) ;
        return ResponseEntity.status(HttpStatus.OK).body(usersRepository.save(usersModel));
    }

}

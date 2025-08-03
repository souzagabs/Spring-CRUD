package com.dia312.springcrud.repository;

import com.dia312.springcrud.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, UUID> {

}

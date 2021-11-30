package com.explosivepomegranate.rest.api.repository;

import com.explosivepomegranate.rest.api.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);

    User findByEmailAndIdNot(String email, int id);

}

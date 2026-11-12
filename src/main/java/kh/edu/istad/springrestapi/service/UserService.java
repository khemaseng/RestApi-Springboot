
package kh.edu.istad.springrestapi.service;

import kh.edu.istad.springrestapi.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAll();
    User getById(UUID id);
    User create(User user);
    void delete(UUID id);
}
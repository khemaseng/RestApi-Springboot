
package kh.edu.istad.springrestapi.service.impl;

import kh.edu.istad.springrestapi.model.User;
import kh.edu.istad.springrestapi.repository.UserRepository;
import kh.edu.istad.springrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.selectAll();
    }
    @Override
    public User getById(UUID id) {
        return userRepository.selectById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found: " + id));
    }
    @Override
    public User create(User user) {
        user.setId(UUID.randomUUID());
        userRepository.insert(user);
        return user;
    }
    @Override
    public void delete(UUID id) {
        boolean removed = userRepository.deleteById(id);
        if (!removed) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found: " + id);
        }
    }
}
package kh.edu.istad.springrestapi.repository;

import kh.edu.istad.springrestapi.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private final List<User> users;
    public UserRepository() {
        users = new ArrayList<>();
        User usrAdmin = new User(UUID.randomUUID(), "Administrator", "admin", "admin@istad.edu.kh", true);
        User usrEditor = new User(UUID.randomUUID(), "Editor", "editor", "editor@istad.edu.kh", false);
        User usrCustomer = new User(UUID.randomUUID(), "Khema Seng", "KMS", "khema@istad.edu.kh", true);
        User usrManager = new User(UUID.randomUUID(), "Kevin", "manager", "manager@istad.edu.kh", true);
        users.add(usrAdmin);
        users.add(usrEditor);
        users.add(usrCustomer);
        users.add(usrManager);
    }
    public List<User> selectAll() {
        return users;
    }
    public Optional<User> selectById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
    public void insert(User user) {
        users.add(user);
    }
    public boolean deleteById(UUID id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(int id) {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    public User get(int id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    public User getByEmail(String email) throws NotFoundException {
        return ExceptionUtil.checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll()
    {
        return repository.getAll().stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
    }

    public void update(User user) {
        repository.save(user);
    }
}

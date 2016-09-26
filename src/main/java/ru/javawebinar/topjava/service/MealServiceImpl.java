package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class MealServiceImpl implements MealService
{
    @Autowired
    private MealRepository repository;

    @Override
    public Meal save(Meal meal)
    {
        return repository.save(meal);
    }

    @Override
    public void delete(int id) throws NotFoundException
    {
        repository.delete(id);
    }

    @Override
    public Meal get(int id) throws NotFoundException
    {
        return repository.get(id);
    }

    @Override
    public List<Meal> getByUser(User user)
    {
        return repository.getByUser(user);
    }

    @Override
    public List<Meal> getAll()
    {
        return repository.getAll().stream()
                .sorted((o1, o2) -> o1.getDateTime().compareTo(o2.getDateTime()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Meal meal)
    {
        repository.save(meal);
    }
}

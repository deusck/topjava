package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.mock.InMemoryMealRepositoryImpl;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class MealRestController
{
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private InMemoryMealRepositoryImpl service;

    private User user;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public List<Meal> getAll()
    {
        LOG.info("getAll");
        return getByUser(user);
    }

    public Meal get(int id) {
        LOG.info("get " + id);
        return service.get(id);
    }

    public Meal create(Meal meal)
    {
        meal.setId(null);
        LOG.info("create " + meal);
        return service.save(meal);
    }

    public void delete(int id)
    {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(Meal meal, int id)
    {
        meal.setId(id);
        LOG.info("update " + meal);
        service.save(meal);
    }

    public List<Meal> getByUser(User user)
    {
        LOG.info("getByUser " + user);
        return service.getByUser(user);
    }

}

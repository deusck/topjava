package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Arrays;
/**
 * User: gkislin
 * Date: 22.08.2014
 */
public class SpringMain
{
    public static void main(String[] args)
    {

       /* AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
        adminUserController.create(new User(1, "userName", "email", "password", Role.ROLE_ADMIN));
        System.out.println();

        MealRestController mealController = appCtx.getBean(MealRestController.class);
        List<MealWithExceed> filteredMealsWithExceeded =
                mealController.getBetween(
                        LocalDate.of(2015, Month.MAY, 30), LocalTime.of(7, 0),
                        LocalDate.of(2015, Month.MAY, 31), LocalTime.of(11, 0));
        filteredMealsWithExceeded.forEach(System.out::println);*/
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml"))
        {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
          //  AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
          //  adminUserController.create(new User(1, "userName", "email", "password", Role.ROLE_ADMIN));
        }

    }

}

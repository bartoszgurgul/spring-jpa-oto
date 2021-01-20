package pl.javastart.springjpaoto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.springjpaoto.dao.UserDao;
import pl.javastart.springjpaoto.dao.UserDetailsDao;
import pl.javastart.springjpaoto.model.User;
import pl.javastart.springjpaoto.model.UserDetails;

@SpringBootApplication
public class SpringJpaOtoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtoApplication.class, args);

        UserDao userDao = ctx.getBean(UserDao.class);
        User user = new User("johnny234", "strongPass", "johnny@gmail.com");
        UserDetails userDetails = new UserDetails("John", "Kowalski", "Krakowska 55, Warszawa");
        user.setDetails(userDetails);
        userDao.save(user);

        UserDetailsDao userDetailsDao = ctx.getBean(UserDetailsDao.class);
        UserDetails getUserDetails = userDetailsDao.get(1L);
        System.out.println(getUserDetails.getUser());

        ctx.close();
    }

}

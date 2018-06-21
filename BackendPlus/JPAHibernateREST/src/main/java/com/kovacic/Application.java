package com.kovacic;

import com.kovacic.entity.Skill;
import com.kovacic.entity.SystemLogin;
import com.kovacic.entity.User;
import com.kovacic.repository.SkillRepository;
import com.kovacic.repository.SystemLoginRepository;
import com.kovacic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ikovacic.
 */
//@ActiveProfiles("dev")


@EntityScan(basePackages = "com.kovacic")
@SpringBootApplication
public class Application {

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SystemLoginRepository systemLoginRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @PostConstruct
    public void setupDbWithData() {

        List<Skill> skillList = new ArrayList<>(Arrays.asList(new Skill("Java"), new Skill("SQL")));
        for (Skill skill :skillList) {
            skillRepository.save(skill);
        }

        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("Ivan", "Kovacic", "ikovacic", DigestUtils.md5Digest("test123".getBytes()).toString(), "ivan@gmail.com"),
                new User("John", "Smithy", "smith", DigestUtils.md5Digest("123test".getBytes()).toString(), "smithy@gmail.com")
        ));

        for (User userItem : userList) {
            if (userRepository.findByEmail(userItem.getEmail()) == null) {
                userItem.setNote("Test");

                List<Skill> skillListFromRepo = skillRepository.findAll();

                userItem.setSkills(skillListFromRepo);
                userRepository.save(userItem);
            }
        }


        User user = userRepository.findByEmail("ivan@gmail.com");
        SystemLogin systemLogin = new SystemLogin(3, new Date(), false);
        user.setSystemLogin(systemLogin);
        systemLogin.setUser(user);
        userRepository.save(user);


    }
}







//
//        List<User> userList = new ArrayList<>(Arrays.asList(
//                new User("Ivan", "Kovacic", "ikovacic", DigestUtils.md5Digest("test123".getBytes()).toString(), "ivan@gmail.com"),
//                new User("John", "Smithy", "smith", DigestUtils.md5Digest("123test".getBytes()).toString(), "smithy@gmail.com")
//        ));
//
//        for (User userItem : userList) {
//            if (userRepository.findByEmail(userItem.getEmail()) == null) {
//                userItem.setNote("Test");
//
//                List<Skill> skillList = skillRepository.findAll();
//
//                userItem.setSkills(skillRepository.findAll());
//                userRepository.save(userItem);
//            }
//        }
//    }
//}
//        // initialize skills //
//        if (skillRepository.count()==0) {
//            List<Skill> skillList = new ArrayList<>(Arrays.asList(
//                    new Skill("Java"),
//                    new Skill("SQL"),
//                    new Skill("Backend")));
//            skillRepository.save(skillList);
//        }
//
//
//        // initialize users //
//        List<User> userList = new ArrayList<>(Arrays.asList(
//                new User("Ivan", "Kovacic", "ikovacic", DigestUtils.md5Digest("test123".getBytes()).toString(), "ivan@gmail.com"),
//                new User("John", "Smithy", "smith", DigestUtils.md5Digest("123test".getBytes()).toString(), "smithy@gmail.com")
//        ));
//
//        for (User userItem : userList) {
//            if (userRepository.findByEmail(userItem.getEmail()) == null) {
//                userItem.setNote("Test");
//
//                List<Skill> skillList = skillRepository.findAll();
//
//                userItem.setSkills(skillRepository.findAll());
//                userRepository.save(userItem);
//            }
//        }
//
//
//        User userB = userRepository.findByEmail("smithy@gmail.com");
//        System.err.println(userB.getEmail());
//        System.err.println(userB.getFirstName());
//        System.err.println(userB.getLastName());
//
//
//
//}

package com.kovacic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ikovacic.
 */
//@ActiveProfiles("dev")


@EntityScan(basePackages = "com.kovacic")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

//
//        SpringApplication application = new SpringApplication(Application.class);
////        application.setAdditionalProfiles("dev");
//        application.run(args);

    }
}


//    @PostConstruct
//    public void setupDbWithData() {
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

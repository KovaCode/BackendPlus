package com.kovacic;

import com.kovacic.entity.*;
import com.kovacic.enumerator.Country;
import com.kovacic.enumerator.Gender;
import com.kovacic.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ikovacic.
 */
//@ActiveProfiles("dev")


@EntityScan(basePackages = "com.kovacic.entity")
@ComponentScan //({"com.kovacic", "com.kovacic.configs"})
@SpringBootApplication
public class Application {

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    SystemLoginRepository systemLoginRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    PriviledgesRepository priviledgesRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @PostConstruct
    public void setupDbWithData() {
        byte[] data = new byte[0];

        Priviledges priviledges = new Priviledges();
        priviledges.setLevel(100);
        priviledges.setName("Admin");

        Priviledges priviledges2 = new Priviledges();
        priviledges2.setLevel(1);
        priviledges2.setName("Rookie");

        if(priviledgesRepository.count()==0) {
            priviledgesRepository.save(priviledges);
            priviledgesRepository.save(priviledges2);
        }


        List<Skill> skillList = new ArrayList<>(Arrays.asList(new Skill("Java"), new Skill("SQL")));

        if(skillRepository.count()==0) {
            // 1. add skills //

            for (Skill skill : skillList) {
                skillRepository.save(skill);
            }
        }

        try {
            java.io.File file = new ClassPathResource("robbie.jpg").getFile();


            byte [] fileBytes = Files.readAllBytes(file.toPath());
            char singleChar;
            for(byte b : fileBytes) {
                singleChar = (char) b;
                System.out.print(singleChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File();
        file.setDescription("test");
        file.setFile(data);
        file.setType("jpg");
        file.setName("robbie");
        fileRepository.save(file);


        // 2. add user //
        User user = new User("smith", DigestUtils.md5Digest("123test".getBytes()).toString(), "smithy@gmail.com");
        user.setSkills(skillList);
        user.setPriviledge(priviledges);
        user = userRepository.save(user);

        // 3. add user-profile //
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName("John");
        userProfile.setLastName("Smith");
        userProfile.setAddress1("Ulica Jablanova 11");
        userProfile.setMobileNumber("099999999");
        userProfile.setCountry(Country.CROATIA);

        LocalDate localDate = LocalDate.of(1985, 9, 11);
        userProfile.setBirthday(localDate);

        userProfile.setGender(Gender.MALE);
        userProfile.setEmail("john.smith@testing.co");
        userProfile.setUser(user);


        userProfile.setImage(file);
        userProfileRepository.save(userProfile);
//        userRepository.save(user);

//        for (User userItem : userList) {
        if (userRepository.findByEmail(user.getEmail()) == null) {
            user.setNote("Test");

            List<Skill> skillListFromRepo = skillRepository.findAll();

            user.setSkills(skillListFromRepo);
            userRepository.save(user);
        }
//        }

        SystemLogin systemLogin = new SystemLogin(3, new Date(), false);
        user.setSystemLogin(systemLogin);
        systemLogin.setUser(user);
        userRepository.save(user);


        Comment comment = new Comment();
        comment.setComment("This is my comment");
        comment.setUser(user);
        commentRepository.save(comment);

        Comment comment2 = new Comment();
        comment2.setComment("This is my comment no.2");
        comment2.setUser(user);
        commentRepository.save(comment2);


        Blog blog = new Blog();
        blog.setTitle("This is an title");
        blog.setContent("This is my new blog about how to handle all aspects of user...");
//        blog.setAttachment();
        blog.setUserId(user);
        blog.setComments(Arrays.asList(comment, comment2));
        blogRepository.save(blog);



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

package com.kovacic;

import com.kovacic.entity.*;
import com.kovacic.enumerator.Country;
import com.kovacic.enumerator.Gender;
import com.kovacic.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ikovacic.
 */
//@ActiveProfiles("dev")


@Configuration
//@EntityScan(basePackages = "com.kovacic.entity")
//@ComponentScan //({"com.kovacic", "com.kovacic.configs"})
@SpringBootApplication
public class Application {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
    ProfileRepository profileRepository;

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
        File file = new File();

//        File file = new File();
//        file.setDescription("test");
//        file.setFile(data);
//        file.setType("jpg");
//        file.setName("robbie");
//        fileRepository.save(file);

        try {
            /*
             *  images
             */
            ClassPathResource jsaCoverImgFile = new ClassPathResource("robbie.jpg");
            byte[] arrayData = new byte[0];

            arrayData = new byte[(int) jsaCoverImgFile.contentLength()];
            jsaCoverImgFile.getInputStream().read(arrayData);

            file.setDescription("test");
            file.setPic(arrayData);
            file.setType("jpg");
            file.setName("robbie");

            ClassPathResource jsaVisionImgFile = new ClassPathResource("robbie.jpg");
            arrayData = new byte[(int) jsaVisionImgFile.contentLength()];
            jsaVisionImgFile.getInputStream().read(arrayData);
            File file2 = new File();
            file2.setDescription("JSA-Vision");
            file2.setPic(arrayData);
            file2.setType("jpg");
            file2.setName("robbie2");

            // file .txt
            ClassPathResource jsaAboutFile = new ClassPathResource("data.sql");
            arrayData = new byte[(int) jsaAboutFile.contentLength()];
            jsaAboutFile.getInputStream().read(arrayData);
            File file3 = new File();
            file3.setDescription("JSA-Vision");
            file3.setPic(arrayData);
            file3.setType("jpg");
            file3.setName("robbie3");

            // store files to PostgreSQL via SpringJPA
            fileRepository.saveAll(Arrays.asList(file, file2, file3));


            for (File fileDownload : fileRepository.findAll()) {
                Files.write(Paths.get(fileDownload.getName() + "." + fileDownload.getType()), fileDownload.getPic());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }






        Priviledges priviledges = new Priviledges();
        priviledges.setLevel(100);
        priviledges.setName("Admin");

        Priviledges priviledges2 = new Priviledges();
        priviledges2.setLevel(1);
        priviledges2.setName("Rookie");

        if (priviledgesRepository.count() == 0) {
            priviledgesRepository.save(priviledges);
            priviledgesRepository.save(priviledges2);
        }


        List<Skill> skillList = new ArrayList<>();


        if (skillRepository.count() == 0) {

            Skill skill1 = new Skill("Java");
            Skill skill2 = new Skill("SQL");

            skillList.add(skill1);
            skillList.add(skill2);


            // 1. add skills //
            for (Skill skill : skillList) {
                skillRepository.save(skill);
            }
        } else {
            skillList.add(skillRepository.getOne(1L));
            skillList.add(skillRepository.getOne(2L));
        }


        User user;

        // 2. add user //
        if (userRepository.count() == 0) {
//            user = new User("smith", DigestUtils.md5Digest("123test".getBytes()).toString(), "smithy@gmail.com");

            user = new User();
            user.setEmail("smithy@gmail.com");
//            user.setPassword(bCryptPasswordEncoder.encode("test123"));
            user.setPassword("test555");
            user.setNote("testsasdasdasd");
            user.setUserName("johhny123");
            user.setActive(true);
            user.setPriviledges(priviledges);
//            priviledges.setUser(user);
            user = userRepository.save(user);
        } else {
            user = userRepository.findByEmail("smithy@gmail.com");
        }


        // 3. add user-profile //
        Profile userProfile = new Profile();
        userProfile.setFirstName("John");
        userProfile.setLastName("Smith");
        userProfile.setAddress1("Ulica Jablanova 11");
        userProfile.setMobileNumber("099999999");
        userProfile.setCountry(Country.CROATIA);
//        userProfile.setPriviledges(priviledges2);
        userProfile.setPostalCode("123122");
        userProfile.setPhoneNumber("1232312312");
        userProfile.setSkill(skillList);

        LocalDate localDate = LocalDate.of(1985, 9, 11);
        userProfile.setBirthday(localDate);

        userProfile.setGender(Gender.MALE);
        userProfile.setEmail("john.smith@testing.co");
        userProfile.setEmail2("john.smith@private.co");
        userProfile.setImage(file);
        profileRepository.save(userProfile);


        user.setProfile(userProfile);
        user = userRepository.save(user);

//        userRepository.save(user);

//        for (User userItem : userList) {
        if (userRepository.findByEmail(user.getEmail()) == null) {
            user.setNote("Test");

            List<Skill> skillListFromRepo = skillRepository.findAll();

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

package com.kovacic;

import com.kovacic.entity.dto.ProfileDto;
import com.kovacic.entity.dto.SkillDto;
import com.kovacic.entity.dto.UserDto;
import com.kovacic.enumerator.Country;
import com.kovacic.enumerator.Gender;
import com.kovacic.service.IProfileService;
import com.kovacic.service.ISkillService;
import com.kovacic.service.IUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "classpath:application-dev.properties")
public class LoginTest extends AbstractTestNGSpringContextTests {

    private String skillName = "Automation Testing";
    private String email = "test@tester.com";
    private Long userID = 0L;


    @Autowired
    private IUserService userService;

    @Autowired
    private IProfileService profileService;


    @Autowired
    private ISkillService skillService;


    @Test(priority = 10)
    public void testCreateUser() {


        SkillDto skill = new SkillDto("Tester/QA");
        skillService.saveSkill(skill);

        UserDto user = new UserDto();
        user.setUserName("Test101");
        user.setPassword("Test@101.");
        user.setEmail(email);
        user.setNote("notifications");

        ResponseEntity<UserDto> response = userService.saveUser(user);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);

        response = userService.getUserByEmail(email);
        userID = response.getBody().getID();
        System.err.println("ID: " + userID);


        ProfileDto userProfile = new ProfileDto();
        userProfile.setFirstName("Martina");
        userProfile.setLastName("Nemecova");
        userProfile.setAddress1("Ulica Jablanova 11");
        userProfile.setMobileNumber("099999999");
        userProfile.setCountry(Country.CZECH_REPUBLIC);
//        userProfile.setPriviledges();
        userProfile.setPostalCode("31000");
        userProfile.setPhoneNumber("16515361");
//        userProfile.setSkill(Arrays.asList(Arrays.asList(skill));

        LocalDate localDate = LocalDate.of(1985, 9, 11);
        userProfile.setBirthday(localDate);

        userProfile.setGender(Gender.FEMALE);
        userProfile.setEmail("nemcova@testing.co");
        userProfile.setEmail2("martinanemecova1@private.co");
//        userProfile.setUser(user);

//        userProfile.setImage(file);
        profileService.saveProfile(userProfile);


    }

//    @Test(priority = 20)
//    public void testReadUserByEmail() {
//        ResponseEntity<UserDto> response = userService.getUserByEmail(email);
//
//        System.err.println(response.getBody().getEmail());
//        System.err.println(response.getBody().getUserName());
//        System.err.println(response.getBody().getNote());
//
//        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK, "HTTP status should be " + HttpStatus.OK.toString());
//        Assert.assertTrue(response.getBody().getID() != null, "Should not be null!");
//    }

//
//    @Test(priority = 30)
//    public void testReadUser() {
//        List<UserDto> response = userService.getAllUsers().getBody();
//
//        for (UserDto user :response) {
//            System.err.println(user.getEmail());
//            System.err.println(user.getUserName());
//            System.err.println(user.getNote());
//        }
//    }
//
//
//    @Test(priority = 40, dependsOnMethods = "testCreateUser")
//    public void testReadUserById() {
//        ResponseEntity<UserDto> response = userService.getUserById(userID);
//
//        System.err.println(response.getBody().getEmail());
//        System.err.println(response.getBody().getUserName());
//        System.err.println(response.getBody().getNote());
//
//        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK, "HTTP status should be " + HttpStatus.OK.toString());
//        Assert.assertTrue(response.getBody().getID().equals(userID), "Should not be null!");
//    }
//
//
//
//
//
//    @Test(priority = 50)
//    public void testDeleteUser() {
//        UserDto userDto = userService.getUserByEmail(email).getBody();
//        ResponseEntity<UserDto> response = userService.deleteUser(userDto);
//        Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);
//    }
//



}

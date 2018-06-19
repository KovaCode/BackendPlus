package com.kovacic;

import com.kovacic.entity.dto.SkillDto;
import com.kovacic.service.ISkillService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by ikovacic.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "classpath:application-prod.properties")
public class SkillTest extends AbstractTestNGSpringContextTests  {

    private final String skillName = "Hibernate";
    private final String skillNameUpdate = "Java/Hibernate/JPA";

    @Autowired
    private ISkillService skillService;

    @Test(priority = 10)
    public void testCreateSkill(){
        SkillDto skillDto = new SkillDto();
        skillDto.setName(skillName);

        ResponseEntity<SkillDto> response =  skillService.saveSkill(skillDto);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);
    }

    @Test(priority = 20)
    public void testReadSkills(){
        ResponseEntity<List<SkillDto>> response =  skillService.getSkills();
        for (SkillDto skillDto :response.getBody()) {
            System.err.println(skillDto.getName());
            Assert.assertEquals(skillDto.getName(), skillName);
        }
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test(priority = 30)
    public void testUpdateSkills(){

        SkillDto skillDto = skillService.getSkillByName(skillName).getBody();

        skillDto.setName(skillNameUpdate);

        ResponseEntity<SkillDto> response = skillService.updateSkill(skillDto);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);
        Assert.assertEquals(response.getBody().getName(), skillNameUpdate);
    }

    @Test(priority = 40)
    public void testDeleteSkills(){
        SkillDto skillDto = skillService.getSkillByName(skillNameUpdate).getBody();
        ResponseEntity<SkillDto> response = skillService.deleteSkill(skillDto);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);

    }




}

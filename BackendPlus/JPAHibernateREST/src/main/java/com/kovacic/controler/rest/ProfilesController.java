package com.kovacic.controler.rest;

import com.kovacic.entity.dto.ProfileDto;
import com.kovacic.service.IProfileService;
import com.kovacic.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ikovacic
 */
@RequestMapping("/profiles")
@RestController
public class ProfilesController {

    @Autowired
    private IProfileService profileService;

    @RequestMapping(value = "/profiles" , method = RequestMethod.GET)
    public List<ProfileDto> getProfiles() {
        return profileService.getAll();
    }

    @RequestMapping(Constants.GET_PROFILE_BY_ID)
    public ResponseEntity<ProfileDto> getProfileById(@PathVariable Long id) {
        return profileService.getProfileById(id);
    }

    @PutMapping(Constants.UPDATE_PROFILE)
    public ResponseEntity<ProfileDto> updateProfile(@RequestBody ProfileDto userProfileDto) {
        return profileService.updateProfile(userProfileDto);
    }

    @PostMapping(value = Constants.SAVE_PROFILE)
    public ResponseEntity saveProfile(@RequestBody ProfileDto userDto) {
        return profileService.saveProfile(userDto);
    }

    @DeleteMapping(value = Constants.DELETE_PROFILE)
    public ResponseEntity deleteProfile(@RequestBody ProfileDto userDto) {
        return profileService.deleteProfile(userDto);
    }


}

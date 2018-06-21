package com.kovacic.controler;

import com.kovacic.entity.dto.UserProfileDto;
import com.kovacic.service.IUserProfileService;
import com.kovacic.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ikovacic
 */
@RequestMapping("/userProfile")
@RestController
public class UserProfileController {

    @Autowired
    private IUserProfileService userProfileService;

    @RequestMapping(Constants.GET_USER_PROFILE_BY_ID)
    public ResponseEntity<UserProfileDto> getUserProfileById(@PathVariable Long id) {
        return userProfileService.getUserProfileById(id);
    }

    @PutMapping(Constants.UPDATE_USER_PROFILE)
    public ResponseEntity<UserProfileDto> updateUser(@RequestBody UserProfileDto userProfileDto) {
        return userProfileService.updateUserProfile(userProfileDto);
    }

    @PostMapping(value = Constants.SAVE_USER_PROFILE)
    public ResponseEntity saveUserProfile(@RequestBody UserProfileDto userDto) {
        return userProfileService.saveUserProfile(userDto);
    }

    @DeleteMapping(value = Constants.DELETE_USER_PROFILE)
    public ResponseEntity deleteUserProfile(@RequestBody UserProfileDto userDto) {
        return userProfileService.deleteUserProfile(userDto);
    }


}

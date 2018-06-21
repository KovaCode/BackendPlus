package com.kovacic.controler;

import com.kovacic.entity.dto.SystemLoginDto;
import com.kovacic.service.ISystemLoginService;
import com.kovacic.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ikovacic
 */
@RequestMapping("/systemLogin")
@RestController
public class SystemLoginController {

    @Autowired
    private ISystemLoginService systemLoginService;

    @RequestMapping(Constants.SET_LOGGED)
    public ResponseEntity<List<SystemLoginDto>> setLogin(@PathVariable boolean login, @PathVariable Long loginId) {
        return systemLoginService.setLogged(login, loginId);
    }


    @RequestMapping(Constants.GET_ALL_LOGINS)
    public ResponseEntity<List<SystemLoginDto>> getAllSytemLogins() {
        return systemLoginService.getAllSystemLogins();
    }


    @RequestMapping(Constants.GET_LOGIN_BY_ID)
    public ResponseEntity<SystemLoginDto> getSystemLoginById(@PathVariable Long loginId) {
        return systemLoginService.getSystemLoginById(loginId);
    }


    @PutMapping(Constants.UPDATE_LOGIN)
    public ResponseEntity<SystemLoginDto> updateSystemLogin(@Valid @RequestBody SystemLoginDto systemLoginDto) {
        return systemLoginService.updateSystemLogin(systemLoginDto);
    }

    @PostMapping(value = Constants.SAVE_LOGIN)
    public ResponseEntity saveSystemLogin(@RequestBody SystemLoginDto systemLoginDto) {
        return systemLoginService.saveSystemLogin(systemLoginDto);
    }

}

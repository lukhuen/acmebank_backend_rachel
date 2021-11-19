package com.acmebank_rachel.api;

import com.acmebank_rachel.domain.User;
import com.acmebank_rachel.domain.dto.UserDetailsResponseDto;
import com.acmebank_rachel.service.UserService;
import com.acmebank_rachel.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @PatchMapping("/payee/{payeeUid}/amount/{amount}")
    public UserDetailsResponseDto transferBetweenUsers(
            Principal principal,
            @PathVariable("payeeUid") Long payeeUid,
            @PathVariable("amount")BigDecimal amount
    ){
        User payer = SecurityUtil.getUser(principal);
        return new UserDetailsResponseDto(userService.transferBetweenUsers(payer.getUid(),payeeUid,amount)) ;
    }

    @GetMapping("me/details")
    public UserDetailsResponseDto getMyUserDetails(Principal principal){
        User user = SecurityUtil.getUser(principal);
        if (user != null){
            return new UserDetailsResponseDto(user);
        }
        return null;
    }
}
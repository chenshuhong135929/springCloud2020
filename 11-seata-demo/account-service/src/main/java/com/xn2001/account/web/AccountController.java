package com.xn2001.account.web;

import com.xn2001.account.service.AccountTCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenshuhong
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountTCCService accountService;

    @PutMapping("/{userId}/{money}")
    public ResponseEntity<Void> deduct(@PathVariable("userId") String userId, @PathVariable("money") Integer money){
        accountService.deduct(userId, money);
        return ResponseEntity.noContent().build();
    }
}
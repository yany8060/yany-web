package com.yany.authorization.oauth2.controller;

import com.yany.authorization.oauth2.model.AuthorizationCodeModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanyong on 2018/5/8.
 */
@RestController
public class OAuth2AuthorizeController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public AuthorizationCodeModel requestCode(@RequestParam("redirect_uri") String redirectUri,
                                              @RequestParam(value = "state", required = false) String state,
                                              HttpServletRequest request) {

        return null;
    }
}

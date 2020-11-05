package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"com.example.demo.*"})
@RequestMapping(value = {"/demo"})
public class DemoController {

    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> getDemoData(JwtAuthenticationToken token) { // you could also just inject a simple 'Principal' here
        return new ResponseEntity<String>("Processed Request: "+ token.getTokenAttributes(), HttpStatus.OK);
    }
}

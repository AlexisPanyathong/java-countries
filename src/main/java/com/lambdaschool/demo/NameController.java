package com.lambdaschool.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;



    // Java Spring Rest APIs --> Java Back End
    @RestController
    @RequestMapping("/names")

    public class NameController {

        // Create an endpoint localhost:2019/names/allnames
        @GetMapping(value = "/allnames",
                produces = {"application/json"})
        public ResponseEntity<?> getAllCountries() {

            ArrayList<Country> rtnCountries = JavaCountriesApplication.ourCountryList.findCountries((c -> c.getName() != null));
            rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
            return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

        }


    }


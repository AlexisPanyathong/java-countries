package com.lambdaschool.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        // localhost: 2019/names/start/{letter}
        @GetMapping(value = "/start/{letter}",
                   produces = {"application/json"})
        public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter) {

            ArrayList<Country> rtnCountries = JavaCountriesApplication.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
            rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
            return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

        }

        // localhost: 2019/names/size/{number}
        @GetMapping(value = "/size/{number}",
                    produces = {"application/json"})
        public ResponseEntity<?> getCountriesByNameLength(@PathVariable int number) {

            ArrayList<Country> rtnCountries = JavaCountriesApplication.ourCountryList.findCountries(c -> c.getName().length() >= number);
            rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
            return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

        }

    }


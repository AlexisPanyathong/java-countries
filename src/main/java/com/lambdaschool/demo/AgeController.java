package com.lambdaschool.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/age")

public class AgeController {
//     * /age/age/{age}
//      * return the countries that have a median age equal to or greater than the given age
        @GetMapping(value = "/age",
                    produces = {"application/json"})
        public ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age) {

            ArrayList<Country> rtnCountries = JavaCountriesApplication.ourCountryList.findCountries(c -> c.getMedianAge() >= age);
            return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

        }

//    * /age/min
//      * return the country with the smallest median age
        @GetMapping(value ="/min",
                    produces = {"application/json"})
        public ResponseEntity<?> getCountriesByMinMedianAge() {

            Country minMedianAgeCountry = JavaCountriesApplication.ourCountryList.countryList.get(0);

            for (Country c: JavaCountriesApplication.ourCountryList.countryList) {

                if (c.getMedianAge() < minMedianAgeCountry.getPopulation()) {

                    minMedianAgeCountry = c;
                }
            }

            return new ResponseEntity<>(minMedianAgeCountry, HttpStatus.OK);
        }

//    * /age/max
//      * return the country the the greatest median age
        @GetMapping(value = "/max",
                    produces = {"application/json"})
        public ResponseEntity<?> getCountryByMaxMedianAge() {

            Country maxMedianAge = JavaCountriesApplication.ourCountryList.countryList.get(0);

            for (Country c: JavaCountriesApplication.ourCountryList.countryList) {

                if (c.getMedianAge() > maxMedianAge.getMedianAge()) {

                    maxMedianAge = c;
                }
            }

            return new ResponseEntity<>(maxMedianAge, HttpStatus.OK);
        }
//    * Stretch Goal
//      * /age/median
//      * return the country with the median median age
}

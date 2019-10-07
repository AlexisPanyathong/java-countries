package com.lambdaschool.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController {

//    * /population/size/{people}
//      * return the countries that have a population equal to or greater than the given population
        @GetMapping(value = "/size/{people}",
                    produces = {"application/json"})
        public ResponseEntity<?> getCountriesByPopulationSize(@PathVariable long people) {

            ArrayList<Country> rtnCountries = JavaCountriesApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people);
            return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

        }

//    * /population/min
//      * return the country with the smallest population
        @GetMapping(value = "/min",
                    produces = {"application/json"})
        public ResponseEntity<?> getCountryByMinPopulation() {

            Country minPopulationCountry = JavaCountriesApplication.ourCountryList.countryList.get(0);

            for (Country c: JavaCountriesApplication.ourCountryList.countryList) {

                if (c.getPopulation() < minPopulationCountry.getPopulation()) {

                    minPopulationCountry = c;
                }
            }

            return new ResponseEntity<>(minPopulationCountry, HttpStatus.OK);
        }

//    * /population/max
//      * return the country with the largest population
        @GetMapping(value = "/max",
                    produces = {"application/json"})
        public ResponseEntity<?> getCountryByMaxPopulation() {

            Country maxPopulationCountry = JavaCountriesApplication.ourCountryList.countryList.get(0);

            for (Country c: JavaCountriesApplication.ourCountryList.countryList) {

                if (c.getPopulation() > maxPopulationCountry.getPopulation()) {

                    maxPopulationCountry = c;
                }
            }

            return new ResponseEntity<>(maxPopulationCountry, HttpStatus.OK);
        }

//    * Stretch Goal
//      * /population/median
//      * return the country with the median population

}

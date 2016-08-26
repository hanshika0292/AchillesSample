package org.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanshika on 25/8/16.
 */

@RestController
@EnableAutoConfiguration
@ComponentScan
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/findAllByLimit/{limit}", method = RequestMethod.GET)
    public String findAll(@PathVariable int limit){
        return carService.findCarsByLimit(limit).toArray().toString();
    }

    @RequestMapping(value = "/findAllById/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable String id){
        return carService.findCarById(id).toString();
    }
}

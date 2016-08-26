package org.sample;

/**
 * Created by hanshika on 25/8/16.
 */

import info.archinnov.achilles.generated.ManagerFactory;
import info.archinnov.achilles.generated.manager.Car_Manager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

@Configuration
@ComponentScan
public class AchillesConfiguration {

    @Inject
    ManagerFactory managerFactory;

    @Bean
    public Car_Manager carManager() {
        Car_Manager car_manager = managerFactory.forCar();
        return car_manager;
    }

}

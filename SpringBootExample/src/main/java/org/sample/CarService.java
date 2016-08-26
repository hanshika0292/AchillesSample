package org.sample;

import info.archinnov.achilles.generated.manager.Car_Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by hanshika on 25/8/16.
 */

@Service
@ComponentScan
public class CarService {

    @Autowired
    private final Car_Manager manager;

//    @Inject
    public CarService(Car_Manager manager){
        this.manager = manager;
    }

    public void createCar(@Valid Car car){
        manager.crud()
                .insert(car)
                .execute();
    }

    public Car findCarById(String  id){
        final Car car = manager.crud().findById(id).get();
        if(car==null){
            System.out.println("Cannot find user with id '%s'");
        }
        return car;
    }

    public List<Car> findCarsByLimit(int limit){
        List<Car> cars = manager.dsl().select().allColumns_FromBaseTable().without_WHERE_Clause()
                .limit(limit).getList();
        if(cars.isEmpty()){
            System.out.println("Cannot find any users");
        }
        return cars;
    }
}

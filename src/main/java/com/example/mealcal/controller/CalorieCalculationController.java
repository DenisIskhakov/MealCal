package com.example.mealcal.controller;

import com.example.mealcal.model.CalorieCalculation;
import com.example.mealcal.repository.CalorieCalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calories")
public class CalorieCalculationController {
    @Autowired
    private CalorieCalculationRepository calorieCalculationRepository;

    @PostMapping("/add")
    public Double savePerson(@RequestBody CalorieCalculation calorieCalculation){
//        Integer a = ((calorieCalculation.getWeight() / (calorieCalculation.getHeight() + calorieCalculation.getAge())))*100;
        //(6.25*рост)+(10*вес)-(5*возраст)
        Double a = (6.25*calorieCalculation.getHeight())+ (10*calorieCalculation.getWeight())-(5*calorieCalculation.getAge());


//        System.out.println(a);
        return a;
    }
}

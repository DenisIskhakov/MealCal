package com.example.mealcal.controller;

import com.example.mealcal.model.AbstractFormula;
import com.example.mealcal.model.CalorieCalculation;
import com.example.mealcal.model.FormulaMifflinSanGeora;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FormulaMifflinSanGeora")
@AllArgsConstructor
public class FormulaMifflinSanGeoraController {


    @PostMapping
    public AbstractFormula getCal(@RequestBody CalorieCalculation calorieCalculation){
        FormulaMifflinSanGeora formulaMifflinSanGeora = new FormulaMifflinSanGeora(calorieCalculation);
        return formulaMifflinSanGeora;
    }
}

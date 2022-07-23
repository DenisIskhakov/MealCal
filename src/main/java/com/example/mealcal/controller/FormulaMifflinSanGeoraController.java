package com.example.mealcal.controller;

import com.example.mealcal.model.AbstractFormula;
import com.example.mealcal.model.CalorieCalculation;
import com.example.mealcal.model.FormulaMifflinSanGeora;
import com.example.mealcal.service.FormulaMifflinSanGeoraService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/FormulaMifflinSanGeora")
@AllArgsConstructor
public class FormulaMifflinSanGeoraController {

    private FormulaMifflinSanGeoraService formulaMifflinSanGeoraService;
    @PostMapping
    public AbstractFormula coridor(@RequestBody CalorieCalculation calorieCalculation){
        FormulaMifflinSanGeora formulaMifflinSanGeora = new FormulaMifflinSanGeora(calorieCalculation);
        formulaMifflinSanGeoraService.calculation(formulaMifflinSanGeora);
        return formulaMifflinSanGeora;
    }

    @PostMapping
    public AbstractFormula getCal(@RequestBody CalorieCalculation calorieCalculation){
        FormulaMifflinSanGeora formulaMifflinSanGeora = new FormulaMifflinSanGeora(calorieCalculation);
        return formulaMifflinSanGeora;
    }
    @PostMapping
    public List<AbstractFormula> getCals(@RequestBody CalorieCalculation calorieCalculation){
        FormulaMifflinSanGeora formulaMifflinSanGeora = new FormulaMifflinSanGeora(calorieCalculation);
        //Formula Hahisona
        List<AbstractFormula> listFormula = new ArrayList<>();
        listFormula.add(formulaMifflinSanGeora);
//        listFormula.add(2formu);
        return listFormula;
    }
}

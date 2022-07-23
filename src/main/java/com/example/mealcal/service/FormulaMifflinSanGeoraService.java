package com.example.mealcal.service;

import com.example.mealcal.model.FormulaMifflinSanGeora;
import com.example.mealcal.model.PermissibleСalorieСorridor;
import org.springframework.stereotype.Service;

@Service
public class FormulaMifflinSanGeoraService {
    //расчет
    public PermissibleСalorieСorridor calculation(FormulaMifflinSanGeora formulaMifflinSanGeora){
        //прописать формулу
        return new PermissibleСalorieСorridor(); // высчитаю коридор
    }

}

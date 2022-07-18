package com.example.mealcal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
public class FormulaHarrisBenedict extends AbstractFormula {

    @Override
    // Основной уровень метаболизма
    public void basalMetabolicRateBenedict(CalorieCalculation calorieCalculation){
        this.setBasal_metabolic_rate(665.1+(9.563*calorieCalculation.getWeight())
                +(1.85*calorieCalculation.getHeight()
                -(4.676*calorieCalculation.getAge())));
    }
    @Override
    //Поддержка(Сохранение веса)
    public void supportBenedict(CalorieCalculation calorieCalculation){
        if(this.getBasal_metabolic_rate()*calorieCalculation.getCoefficientActivity().getActivity()<1200){
            this.setSupport(1200.0);
        }else{
            this.setSupport(this.getBasal_metabolic_rate()*calorieCalculation.getCoefficientActivity().getActivity());
        }
    }
    @Override
    //Дефицит калорий (похудение)
    //Нужно указать в переменную процент дефецита/профицита(10-15-20)
    public void calorieDeficitBenedict(CalorieCalculation calorieCalculation){
        //=ЕСЛИ(($B$25-$B$25*B11)<1200;1200;$B$25-$B$25*B11)
        if((this.getSupport()-this.getSupport()*0.1)<1200){
            this.setSupport(1200.0);
        }else{
            this.setSupport(this.getSupport()-this.getSupport()*0.1);
        }
    }
    @Override
    //Профицит калорий (набор веса)
    //Нужно указать в переменную процент дефецита/профицита(10-15-20)
    public void calorieSurplusBenedict(CalorieCalculation calorieCalculation){
        this.setCalorie_surplus(this.getSupport()+this.getSupport()*0.1);
    }
}

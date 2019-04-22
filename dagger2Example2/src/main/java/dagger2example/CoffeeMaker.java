package dagger2example;

import javax.inject.Inject;

/**
 * Created by chihacker on 2017. 7. 27..
 */

public class CoffeeMaker{
    private Heater heater;

    @Inject
    public CoffeeMaker(Heater heater){
        this.heater = heater;

    }

    public void brew(CoffeeBean coffeeBean){
        System.out.println("CoffeeBeen("+coffeeBean.toString()+") [_]P coffee! [_]P ");
    }

}

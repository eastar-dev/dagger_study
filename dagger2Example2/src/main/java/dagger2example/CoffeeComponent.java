package dagger2example;


import dagger.Subcomponent;

import java.util.Map;

@CoffeeScope
@Subcomponent(modules = {
        CoffeeModule.class
        ,CoffeeBeanModule.class
})
public interface CoffeeComponent {
    CoffeeMaker coffeeMaker();
    CoffeeBean coffeeBean();
    Map<String,CoffeeBean> coffeeBeanMap();

    @Subcomponent.Builder
    interface Builder{
        Builder coffeeModule(CoffeeModule coffeeModule);
        CoffeeComponent build();
    }
}

package dagger2example;

import dagger.Module;
import dagger.Provides;

@Module
public class CoffeeModule {

    @CoffeeScope
    @Provides
    CoffeeMaker provideCoffeeMaker(Heater heater){
        return new CoffeeMaker(heater);
    }

    @CoffeeScope
    @Provides
    Heater provideHeater(){
        return new Heater();
    }

    // 타입에 맞춰 생성될 객체가 명확할 때는 GuatemalaBean 처럼 @Inject 형태로도 가능. 그렇지 않으면 @Provide method를 만들어주어야 함.
    @Provides
    EthiopiaBean provideEthiopiaBean(){
        return new EthiopiaBean();
    }

}

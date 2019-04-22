package dagger2example;

import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class CoffeeBeanModule {

    @Binds
    abstract CoffeeBean provideCoffeeBean(EthiopiaBean ethiopiaBean);

    @Binds
    @IntoMap
    @StringKey("ethiopia")
    abstract CoffeeBean provideEthiopiaBean(EthiopiaBean ethiopiaBean);


    @Binds
    @IntoMap
    @StringKey("guatemala")
    abstract CoffeeBean provideGuatemalaBean(GuatemalaBean guatemalaBean);
    // EthiopiaBean 처럼 @Provide method 를 제공하지 않아도 @Inject annotation을 이용해 Injectable 한 객체로 정의해도 bind 가능.

}

package dagger2example;

import dagger.Module;
import dagger.Provides;

import javax.inject.Provider;
import javax.inject.Singleton;

@Module(subcomponents = CoffeeComponent.class)
public class CafeModule {

    private String name;

    public CafeModule(){

    }

    public CafeModule(String name){
        this.name = name;
    }

    @Singleton
    @Provides
    CafeInfo cafeInfo(){
        if(name == null || name.isEmpty())  return new CafeInfo();
        else    return new CafeInfo(name);
    }
}



package dagger2example;

public class CafeApp {

    public static void main(String[] args){

        //Subcomponent
        {
            // Scope
            CafeComponent cafeComponent = DaggerCafeComponent.create();
            CafeInfo cafeInfo1 = cafeComponent.cafeInfo(); // 동일한 singleton scope 이기 때문에 같은 객체가 리턴
            CafeInfo cafeInfo2 = cafeComponent.cafeInfo();
            System.out.println("Singleton scope CafeInfo is equal : " + cafeInfo1.equals(cafeInfo2));



            //CoffeeScope
            CoffeeComponent coffeeComponent1 = cafeComponent.coffeeComponent().build();
            CoffeeComponent coffeeComponent2 = cafeComponent.coffeeComponent().build();
            CoffeeMaker coffeeMaker1 = coffeeComponent1.coffeeMaker();
            CoffeeMaker coffeeMaker2 = coffeeComponent1.coffeeMaker();
            System.out.println("CoffeeScope / same component coffeeMaker is equal : " + coffeeMaker1.equals(coffeeMaker2));
            CoffeeMaker coffeeMaker3 = coffeeComponent2.coffeeMaker(); //MakerScopeMethod
            System.out.println("CoffeeScope / different component coffeeMaker is equal : " + coffeeMaker1.equals(coffeeMaker3));

            //Non-scope
            CoffeeBean coffeeBean1 = coffeeComponent1.coffeeBean();
            CoffeeBean coffeeBean2 = coffeeComponent1.coffeeBean();
            System.out.println("Non-scoped coffeebean is equal : " + coffeeBean1.equals(coffeeBean2));




            //Encapsulate
            //바로 CoffeeComponent 를 통해서 커피를 내릴수 없다.
            //CafeComponent 를 통해야만 CoffeeComponent에 접근 할 수 있다. 즉 카페 방문 없이 커피를 내리는 것을 방지 할 수 있다.
            CoffeeComponent coffeeComponent = DaggerCafeComponent.create().coffeeComponent().build();
            coffeeComponent.coffeeMaker().brew(coffeeComponent.coffeeBean());
        }


        //Builder 의 활용
        {
            CafeComponent cafeComponent = DaggerCafeComponent.builder()
                    .cafeModule(new CafeModule("example cafe"))
                    .build();
            cafeComponent.cafeInfo().welcome();
        }


        //IntoMap 활용
        {
            CoffeeComponent coffeeComponent = DaggerCafeComponent.create().coffeeComponent().build();
            coffeeComponent.coffeeBeanMap().get("guatemala").name();
        }

    }
}

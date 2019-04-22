package dagger2example;

public class Heater {

    boolean heating;

    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public void on() {
        System.out.println("A_Heater : ~ ~ ~ heating ~ ~ ~");
        this.heating = true;
    }

    public void off() {
        this.heating = false;

    }

    public boolean isHot() {
        return heating;
    }
}

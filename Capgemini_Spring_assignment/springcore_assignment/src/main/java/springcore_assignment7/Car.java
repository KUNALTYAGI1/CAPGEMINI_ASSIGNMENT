package springcore_assignment7;
public class Car {
    private String make;
    private int model;
    private Engine engine;
    private int horsePower;

    // Getters and setters

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model=" + model +
                ", engine=" + engine +
                ", horsePower=" + horsePower +
                '}';
    }
}


package domain;

/**
 * @author Yufei Yang
 */
public class Laptop implements Equipment {
    private String model;
    private String monitor;


    public Laptop() {
        super();
    }


    public Laptop(String model, String monitor) {
        super();
        this.model = model;
        this.monitor = monitor;
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public String getMonitor() {
        return monitor;
    }


    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }


    @Override
    public String getDescription() {
        return model + "(" + monitor + ")";
    }



}


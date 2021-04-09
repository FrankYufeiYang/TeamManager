package domain;

/**
 * @author Yufei Yang
 */
public class PC implements Equipment{
    private String model;
    private String monitor;

    @Override
    public String getDescription() {
        return model + "(" + monitor + ")";    }

    public PC() {
        super();
    }

    public PC(String model, String monitor) {
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

}

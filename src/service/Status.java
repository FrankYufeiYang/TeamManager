package service;

/**
 * @description Show the current status of an employee.
 * @author Yufei Yang
 */
public class Status {
    private final String STATUS;
    private Status(String STATUS) {
        this.STATUS = STATUS;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status VACATION = new Status("VACATION");
    public static final Status BUSY = new Status("BUSY");

    @Override
    public String toString() {
        return STATUS;
    }
}

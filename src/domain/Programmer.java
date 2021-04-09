package domain;

import service.Status;

/**
 * @author Yufei Yang
 */

public class Programmer extends Employee {
    private int teamID;
    //set default value as FREE(static final value in Status.java)
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age,
                      double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getTeamID() {
        return teamID;
    }


    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    protected String getMemberDetails() {
        return getTeamID() + "/" + getDetails();
    }

    public String getDetailsForTeam() {
        return getMemberDetails() + "\tProgrammer"+"\t" + status;
    }

    @Override
    public String toString() {
        return getDetails() + "\tProgrammer\t" + status + "\t\t\t\t\t" + equipment.getDescription() ;
    }
}

package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

/**@description Managing the Developer team; pick employees to form the team
 * @author Yufei Yang
 */
public class TeamService {
    private static int counter = 1;//team ID; for auto-increase purpose
    private final int MAX_MEMBER = 8;//Max number of team members
    private Programmer[] team = new Programmer[MAX_MEMBER];//Team list
    private int total = 0;//current number of members


    public TeamService() {

    }
    //@return the developer team
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];

        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER)
            throw new TeamException("Team is full");
        if (!(e instanceof Programmer))
            throw new TeamException("Please select a developer");

        Programmer p = (Programmer)e;

        if (isMember(p))
            throw new TeamException("The selected employee is a team member already.");

        if("BUSY".equals(p.getStatus().toString())) {
            throw new TeamException("The selected employee is busy");
        }else if("VACATION".equals(p.getStatus().toString())) {
            throw new TeamException("The selected employee is on vacation");
        }


        // get number of programmers, architects, designers
        int numOfArch = 0;
        int numOfDsgn = 0;
        int numOfPrgm = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) numOfArch++;
            else if (team[i] instanceof Designer) numOfDsgn++;
            else if (team[i] instanceof Programmer) numOfPrgm++;
        }

        //we set the team so it can only take one architects, two designers, 3 programmers
        // since architect is the an instance of programmer, we check on it first
        if (p instanceof Architect) {
            if (numOfArch >= 1) throw new TeamException("The team can only have one architect");
        } else if (p instanceof Designer) {
            if (numOfDsgn >= 2) throw new TeamException("The team can only have two designers");
        } else if (p instanceof Programmer) {
            if (numOfPrgm >= 3) throw new TeamException("The team can only have three programmers");
        }


        // add the selected employee into the  developer team
        p.setStatus(Status.BUSY);
        p.setTeamID(counter++);
        team[total++] = p;
    }

    // check whether the employee is already a team member
    private boolean isMember(Programmer p) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == p.getId())
                return true;
        }
        return false;
    }


    //remove the selected employee
    public void removeMember(int TID) throws TeamException {
        int n = 0;
        //find the selected employee
        for (; n < total; n++) {
            if (team[n].getTeamID() == TID) {
                team[n].setStatus(Status.FREE);
                break;
            }
        }

        if (n == total)
            throw new TeamException("Cannot find the selected employee");
        //move the array elements forward
        for (int i = n + 1; i < total; i++) {
            team[i - 1] = team[i];
        }
        team[--total] = null;
    }
}

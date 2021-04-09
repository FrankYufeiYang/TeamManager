package view;

import domain.Employee;
import domain.Programmer;
import service.ListService;
import service.TeamException;
import service.TeamService;

/**
 * @author Yufei Yang
 * @description a view to provide user interface

 */
public class TeamView {
    private ListService listSvc = new ListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {
        boolean flag = true;
        char key = 0;

        do {
            if (key != '1') {
                listAllEmployees();
            }
            System.out.print("1-Team List  2-Add Member  3-Remove Member  4-Exit  Choose(1-4)：");
            key = Utility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    listTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("Confirm on exit(Y/N)：");
                    char y = Utility.readConfirmSelection();
                    if (y == 'Y')
                        flag = false;
                    break;
            }
        } while (flag);
    }


    private void listAllEmployees() {
        System.out
                .println("\n-------------------------------Employee List--------------------------------\n");
        Employee[] emps = listSvc.getAllEmployees();
        if (emps == null || emps.length == 0) {
            System.out.println("No employee record in database!");
        } else {
            System.out.println("ID\tName\tAge\tSalary\tPosition\tStatus\tbonus\tstock\tequipment");
        }

        for (Employee e : emps) {
            System.out.println(" " + e);
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    //list the developer team
    private void listTeam() {
        System.out
                .println("\n--------------------Developer Team---------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if (team.length == 0) {
            System.out.println("Developer team currently have no member");
        } else {
            System.out.println("TID/ID\tName\tAge\tSalary\tPosition\tStatus\tbonus\tstock");
        }

        for (Programmer p : team) {
            System.out.println(" " + p.getDetailsForTeam());
        }
        System.out.println("-------------------------------------------------------");
    }

    // 添加成员到团队
    private void addMember() {
        System.out.println("---------------------Add member---------------------");
        System.out.print("Please input an employee ID: ");
        int id = Utility.readInt();

        try {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("Add member successfully!");
        } catch (TeamException e) {
            System.out.println("Failed：" + e.getMessage());
        }

        Utility.readReturn();
    }


    private void deleteMember() {
        System.out.println("---------------------Remove Member---------------------");
        System.out.print("Please input a team id(tid): ");
        int id = Utility.readInt();
        System.out.print("Confirm on removal(Y/N): ");
        char y = Utility.readConfirmSelection();
        if (y == 'N')
            return;

        try {
            teamSvc.removeMember(id);
            System.out.println("Removal successful!");
        } catch (TeamException e) {
            System.out.println("Failed：" + e.getMessage());
        }
        Utility.readReturn();
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}

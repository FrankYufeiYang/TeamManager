package service;

import domain.*;
import static service.Data.*;


/**
 * @author Yufei Yang
 */
public class ListService {
    private Employee[] employees;

    //use constructor to populate array
    public ListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            //universal properties
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);


            Equipment eq;
            double bonus;
            int stock;
            // case variables are defined as static final in Data.java
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    eq = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, eq);
                    break;
                case DESIGNER:
                    eq = createEquipment(i);
                    bonus = Integer.parseInt(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, eq, bonus);
                    break;
                case ARCHITECT:
                    eq = createEquipment(i);
                    bonus = Integer.parseInt(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, eq, bonus, stock);
                    break;
            }
        }
    }

    //This method is doing the same thing like above but for equipments
    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        String model = EQUIPMENTS[index][1];
        String monitor = EQUIPMENTS[index][2];
        switch (type) {
            //21
            case PC:
                return new PC(model, monitor);
            case LAPTOP:
                return new Laptop(model, monitor);
            case PRINTER:
                //here variable monitor actually stores the printer type
                return new Printer(model, monitor);
        }
        return null;
    }


    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     *
     * @param id
     * @return Employee
     * @throws TeamException
     */
    public Employee getEmployee(int id) throws TeamException {
        for (Employee e : employees) {
            if (e.getId() == id)
                return e;
        }
        throw new TeamException("The selected employee doesn't exist!");
    }
}

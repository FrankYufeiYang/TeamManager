package Junit;

import domain.Employee;
import org.junit.Test;
import service.ListService;
import service.TeamException;

/**
 * @author Yufei Yang
 */
public class ListServiceTest {
    @Test
    public void TestGetAllEmployees(){
        ListService listService = new ListService();
        Employee[] employees = listService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
            
        }


    }
    @Test
    public void testGetEmployee(){
        ListService listService = new ListService();

        int id = 15;
        try{
            Employee employee = listService.getEmployee(id);
            System.out.println(employee);
        }catch(TeamException e) {
            System.out.println(e.getMessage());
        }

    }

}

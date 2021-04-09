package service;


public class Data {

    //use these numbers to represent different types of workers
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int LAPTOP = 22;
    public static final int PRINTER = 23;

    // Architects have extra entries of bonus salary and stock

    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
        {"11", "1", "Mike", "22", "3000"},
        {"13", "2", "Frank", "32", "18000", "15000", "2000"},
        {"11", "3", "Jacob", "23", "7000"},
        {"11", "4", "Aaron", "24", "7300"},
        {"12", "5", "Liam", "28", "10000", "5000"},
        {"11", "6", "Noah", "22", "6800"},
        {"12", "7", "Olivia", "29", "10800","5200"},
        {"13", "8", "Young", "30", "19800", "15000", "2500"},
        {"12", "9", "William", "26", "9800", "5500"},
        {"11", "10", "David", "21", "6600"},
        {"11", "11", "Ethan", "25", "7100"},
        {"12", "12", "James", "27", "9600", "4800"}
    };
    
    //Programmers and above will be assigned an equipment
    //21 means the assigned equipment is a PC
    //PC      :21, model, monitor
    //Laptop:22, model, monitor
    //Printer :23, name, type 
    public static final String[][] EQUIPMENTS = {
        {"21", "iPAD", "7.9 Inch"},
        {"22", "Macbook", "15 Inch"},
        {"21", "DELL", "LG 17 Inch"},
        {"21", "DELL", "Samsung 17 Inch"},
        {"23", "Canon PIXMA", "Ink jet "},
        {"21", "Asus", "Samsung 17 Inch"},
        {"21", "Asus", "Samsung 17 Inch"},
        {"23", "Sharp 20K", "Leaser"},
        {"22", "HP m6", "13 Inch"},
        {"21", "Dell", "NEC 17 Inch"},
        {"21", "Lenovo","Acer 17 Inch"},
        {"22", "MSI GT70", "15 Inch"}
    };
}

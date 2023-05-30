package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.techelevator.Employee.DEFAULT_SALARY;
import static com.techelevator.Employee.salary;

public class Application {
    List<Department> departments = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    Map<String, Project> projects = new HashMap<>();

    /**
     * The main entry point in the application
     *
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();


        // create employees
        createEmployees();


        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();


        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        departments.add(new Department("Marketing", 1));
        departments.add(new Department("Sales", 2));
        departments.add(new Department("Engineering", 3));

    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department department : departments) {
            System.out.println(department.getName());
        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {

        Employee Dean = new Employee();
        Dean.setEmployeeId(1);
        Dean.setFirstName("Dean");
        Dean.setLastName("Johnson");
        Dean.setEmail("djohnson@teams.com");
        Dean.setDepartment(departments.get(2));
        Dean.setHireDate("08/21/2020");
        employees.add(Dean);
        employees.add(new Employee(2, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020"));
        employees.add(new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020"));


    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (int i = 0; i < employees.size(); i++) {
            if (i == 1) {
                String angie = employees.get(i).getFullName() + " (" + employees.get(1).raiseSalary(0.1) + ") " + employees.get(i).getDepartment().getName();
                System.out.println(angie);
            } else {
                String single = employees.get(i).getFullName() + " (" + DEFAULT_SALARY + ") " + employees.get(i).getDepartment().getName();
                System.out.println(single);
            }
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project TEams = new Project();
        TEams.setName("TEams");
        TEams.setDescription("Project Management Software");
        TEams.setStartDate("10/10/2020");
        TEams.setDueDate("11/10/2020");
        ArrayList<Employee> engineeringEmp = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getDepartment().getDepartmentId() == 2) {
                engineeringEmp.add(e);
            }
        }
        TEams.setTeamMembers(engineeringEmp);
        projects.put(TEams.getName(), TEams);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project MLP = new Project();
        MLP.setName("Marketing Landing Page");
        MLP.setDescription("Lead Capture Landing Page for Marketing");
        MLP.setStartDate("10/10/2020");
        MLP.setDueDate("10/17/2020");
        ArrayList<Employee> marketEmp = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getDepartment().getDepartmentId() == 0) {
                marketEmp.add(e);
            }
        }
        MLP.setTeamMembers(marketEmp);
        projects.put(MLP.getName(), MLP);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for (String p : projects.keySet()){
            int deptSize = Project.teamMembers.size();
            System.out.println(p+ " " + deptSize);

        }
    }

}

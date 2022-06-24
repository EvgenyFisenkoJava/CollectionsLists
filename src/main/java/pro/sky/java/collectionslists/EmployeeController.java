package pro.sky.java.collectionslists;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/find")
    public String findEmployeeInfo(@RequestParam(value = "firstName", required = false) String firstName,
                                   @RequestParam(value = "lastName", required = false) String lastName) {

        try {
            final String employee = employeeService.findEmployee(firstName, lastName);
            return employee.toString();
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }

    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam(value = "lastName", required = false) String lastName) {

        try {
            final String employee = employeeService.addEmployee(firstName, lastName);

            return employee.toString() + " has been added successfully";
        } catch (EmployeeStorageIsFullException exception) {
            throw new EmployeeStorageIsFullException();

        } catch (EmployeeAlreadyAddedException exception) {
            throw new EmployeeAlreadyAddedException();
        }
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName", required = false) String lastName) {

        try {
            final String employee = employeeService.removeEmployee(firstName, lastName);

            return employee.toString() + " has been removed successfully";

        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }
    }

    @GetMapping("/list")
    public String printList() {
        final String employees = employeeService.allEmployees();
        return employees;
    }

}

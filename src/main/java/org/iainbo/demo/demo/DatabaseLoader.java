package org.iainbo.demo.demo;

import org.iainbo.demo.demo.entities.Employee;
import org.iainbo.demo.demo.entities.Manager;
import org.iainbo.demo.demo.repositories.EmployeeRepository;
import org.iainbo.demo.demo.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner{

    private final EmployeeRepository employees;
    private final ManagerRepository managers;

    @Autowired
    public DatabaseLoader(EmployeeRepository employeeRepository, ManagerRepository managerRepository){
        this.employees = employeeRepository;
        this.managers = managerRepository;
    }

    @Override
    public void run(String... strings) throws Exception{

        Manager jock = this.managers.save(new Manager("Jock", "password", "ROLE_MANAGER"));
        Manager martin = this.managers.save(new Manager("admin", "password", "ROLE_MANAGER"));

        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken
                        ("admin", "doesn't matter",
                                AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

       //this.employees.save(new Employee("Henrik", "Larsson", "Striker", martin));
       //this.employees.save(new Employee("User", "To Delete", "Test User", martin));
       this.employees.save(new Employee("User", "To Delete", "1234 5678", "test1@email.com", "1 House, Somewhere", martin));
       this.employees.save(new Employee("User", "To Update", "5678 1234", "test2@email.com", "2 House, Somewhere", martin));

        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken
                        ("Jock", "doesn't matter",
                                AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

       this.employees.save(new Employee("User", "To Test", "5678 4321", "test3@email.com", "3 House, Somewhere", jock));
       //this.employees.save(new Employee("Ronnie", "Simpson", "Goalkeeper", jock));
       //this.employees.save(new Employee("Jim", "Craig", "Right Back", jock));
       //this.employees.save(new Employee("Tommy", "Gemmel", "Left Back", jock));
       //this.employees.save(new Employee("Bobby", "Murdoch", "Right Half", jock));
       //this.employees.save(new Employee("Billy", "McNeill", "Centre Half", jock));
       //this.employees.save(new Employee("John", "Clark", "Centre Half", jock));
       //this.employees.save(new Employee("Jimmy", "Johnstone", "Outside Right", jock));
       //this.employees.save(new Employee("Willie", "Wallace", "Centre Forward", jock));
       //this.employees.save(new Employee("Stevie", "Chalmers", "Centre Forward", jock));
       //this.employees.save(new Employee("Bertie", "Auld", "Left Half", jock));
       //this.employees.save(new Employee("Bobby", "Lennox", "Outside Left", jock));

       SecurityContextHolder.clearContext();

    }
}

package org.iainbo.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner{

    private final EmployeeRepository repository;

    @Autowired
    public DatabaseLoader(EmployeeRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception{
       this.repository.save(new Employee("Henrik", "Larsson", "God"));

       this.repository.save(new Employee("Jock", "Stein", "Manager"));
       this.repository.save(new Employee("Ronnie", "Simpson", "Goalkeeper"));
       this.repository.save(new Employee("Jim", "Craig", "Right Back"));
       this.repository.save(new Employee("Tommy", "Gemmel", "Left Back"));
       this.repository.save(new Employee("Bobby", "Murdoch", "Righ Half"));
       this.repository.save(new Employee("Billy", "McNeill", "Centre Half"));
       this.repository.save(new Employee("John", "Clark", "Centre Half"));
       this.repository.save(new Employee("Jimmy", "Johnstone", "Outside Right"));
       this.repository.save(new Employee("Willie", "Wallace", "Centre Forward"));
       this.repository.save(new Employee("Stevie", "Chalmers", "Centre Forward"));
       this.repository.save(new Employee("Bertie", "Auld", "Left Half"));
       this.repository.save(new Employee("Bobby", "Lennox", "Outside Left"));
    }
}

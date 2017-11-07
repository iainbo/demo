package org.iainbo.demo.demo;

import org.iainbo.demo.demo.entities.Employee;
import org.iainbo.demo.demo.entities.Manager;
import org.iainbo.demo.demo.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler({Employee.class})
public class SpringDataRestEventHandler {

    private final ManagerRepository managerRepository;

    @Autowired
    public SpringDataRestEventHandler(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }

    @HandleBeforeCreate
    public void applyUserInformationUsingSecurityContext(Employee employee){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Manager manager = this.managerRepository.findByName(name);
        if(manager == null){
            manager = createNewManager(name);
        }
        employee.setManager(manager);
    }

    @HandleBeforeSave
    public void applyUserInformationBeforeSave(Employee employee){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Manager manager = this.managerRepository.findByName(name);
        if(manager == null){
            manager = createNewManager(name);
        }
        employee.setManager(manager);
    }

    private Manager createNewManager(String name){
        Manager newManager = new Manager();
        newManager.setName(name);
        newManager.setRoles(new String[]{"ROLE_MANAGER"});
        return this.managerRepository.save(newManager);
    }
}

package org.iainbo.demo.demo.entities;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class EmployeeTest {

    @Mock
    Manager mockUserManager;


    @Test
    public void testCreateEmployee(){
        Long id = 1L;
        Long version = 1L;

        String firstName = "JUnit Test";
        String lastName = "User";
        String description  = "User for Test";

        Employee newEmployee = new Employee(firstName, lastName, description, mockUserManager);
        newEmployee.setId(id);
        newEmployee.setVersion(1L);

        Assert.assertEquals(newEmployee.getId(), id);
        Assert.assertEquals(newEmployee.getFirstName(), firstName);
        Assert.assertEquals(newEmployee.getLastName(), lastName);
        Assert.assertEquals(newEmployee.getDescription(), description);
        Assert.assertEquals(newEmployee.getManager(), mockUserManager);
        Assert.assertEquals(newEmployee.getVersion(), version);
    }
}

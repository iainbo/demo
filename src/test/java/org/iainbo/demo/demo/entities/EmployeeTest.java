package org.iainbo.demo.demo.entities;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class EmployeeTest {

    @Mock
    Manager mockUserManager;


    @Test
    public void testCreateEmployee(){
        String firstName = "Test";
        String lastName = "User";
        String description  = "User for Test";

        Employee newEmployee = new Employee(firstName, lastName, description, mockUserManager);

        Assert.assertEquals(newEmployee.getFirstName(), firstName);
        Assert.assertEquals(newEmployee.getLastName(), lastName);
        Assert.assertEquals(newEmployee.getDescription(), description);
        Assert.assertEquals(newEmployee.getManager(), mockUserManager);
    }
}

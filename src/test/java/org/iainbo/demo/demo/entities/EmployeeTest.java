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
        String phoneNumber  = "1234 5678";
        String emailAddress = "test@email.com";
        String address = "A House, Somewhere";

        Employee newEmployee = new Employee(firstName, lastName, phoneNumber, emailAddress, address, mockUserManager);
        newEmployee.setId(id);
        newEmployee.setVersion(1L);

        Assert.assertEquals(newEmployee.getId(), id);
        Assert.assertEquals(newEmployee.getFirstName(), firstName);
        Assert.assertEquals(newEmployee.getLastName(), lastName);
        Assert.assertEquals(newEmployee.getPhoneNumber(), phoneNumber);
        Assert.assertEquals(newEmployee.getEmailAddress(), emailAddress);
        Assert.assertEquals(newEmployee.getAddress(), address);
        Assert.assertEquals(newEmployee.getManager(), mockUserManager);
        Assert.assertEquals(newEmployee.getVersion(), version);
    }
}

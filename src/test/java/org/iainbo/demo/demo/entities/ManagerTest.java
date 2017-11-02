package org.iainbo.demo.demo.entities;

import org.junit.Assert;
import org.junit.Test;

public class ManagerTest {

    @Test
    public void testCreateManagerAndPasswordIsEncoded(){
        Long id = 1L;
        String managerName = "Test";
        String password = "password";
        String[] roles = {"ROLE_MANAGER"};

        Manager newManager = new Manager(managerName, password, roles);
        newManager.setId(id);

        Assert.assertEquals(newManager.getId(), id);
        Assert.assertEquals(newManager.getName(), managerName);
        Assert.assertNotEquals(newManager.getPassword(), password);
        Assert.assertArrayEquals(newManager.getRoles(), roles);
    }
}

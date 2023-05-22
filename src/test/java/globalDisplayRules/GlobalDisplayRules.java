package globalDisplayRules;

import assemblyPages.DisplayRules;
import assemblyPages.HomePage;
import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlobalDisplayRules extends BaseTest {
    @Test(priority = 1, dependsOnMethods = "validLoginTests")
    public void findDisplayRules(){
        homePage.clickKits();
        homePage.clickDisplayRules();
        System.out.println("Test 2: Found Display Rules");
    }
    @Test(priority = 2, dependsOnMethods = {"validLoginTests","findDisplayRules"})
    public void createNewItem(){
        DisplayRules displayRules = new DisplayRules(driver);
        displayRules.clickCreateButton();
        displayRules.clickNameItemPencil();
        displayRules.setItemName("[Test] item 1");
        System.out.println("Test 3: Created and saved an item");

    }
    @Test(priority = 3, dependsOnMethods = {"validLoginTests","findDisplayRules"})
    public void searchByNameItem(){
        DisplayRules displayRules = new DisplayRules(driver);
        displayRules.searchNameItem("[Test] item 1");
        displayRules.searchRes("[TEST] ITEM 1"); //check if search results corresponds to the request
        System.out.println("Test 4: Found an item");
    }
    @Test(priority = 4, dependsOnMethods = {"validLoginTests","findDisplayRules"})
    public void deleteSingleItem(){
        DisplayRules displayRules = new DisplayRules(driver);
        displayRules.searchNameItem("[Test] item 1");//add some checks after search results
        displayRules.selectToggle(); //need to add Assert.assertistrue(isSelected)
        displayRules.deleteAnItem();
        Assert.assertEquals(displayRules.getNoDataText(), "NO DATA AVAILABLE", "Wrong Message");
        System.out.println("Test 5: An item has been deleted");


    }



}

package pages.kitComponentsPages;

import com.google.common.collect.Comparators;
import com.google.common.collect.Ordering;
import elements.Table;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import static org.junit.Assert.*;


public abstract class V3Table {
    public WebDriver driver;
    public By xPathOfCreateButton;
    public By xPathOfDeleteButton;
    public By xPathOfToggleButton;
    public By xPathNoDataText;
    public Table tableV3 = new Table("V3 table", By.xpath("//table[@style!='display: none' and @class='v3-table']/tbody"), driver);
    public By xPathTable;
    public By xPathOfTable;
    public By xPathOfTableHeaders;
    public String xPathOfClickableHeader;

    public V3Table(WebDriver driver) {
        this.driver = driver;
    }


    public void clickCreateButton() {
        driver.findElement(xPathOfCreateButton).click();
    }

    public void clickDeleteButton() {
        driver.findElement(xPathOfDeleteButton).click();
    }

    public void selectToggleButton() {
        driver.findElement(xPathOfToggleButton).click();
    }

    public String getNoDataText() {
        return driver.findElement(xPathNoDataText).getText();
    }

    public void testColumnsSorting() {
        List<WebElement> sortableColumnHeaders = driver.findElements(By.xpath("//table[@style!='display: none' and @class='v3-table']/thead/tr/th[contains(@class, 'sortable')]/div"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        for (WebElement sortableColumn : sortableColumnHeaders) {
            for (int i = 0; i < sortableColumnHeaders.size(); i++) {
                WebElement element = sortableColumnHeaders.get(i);
                int index = sortableColumnHeaders.indexOf(element);
                int sortIndex = index + 1;
                List<String> sortingOptions = Arrays.asList("asc", "desc", "");
                for (int g = 0; g < sortingOptions.size(); g++) {
                    wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
                    List<WebElement> names = driver.findElements(By.xpath("//table[@style!='display: none' and @class='v3-table']/tbody/tr[@style!='display: none']/td[@class!='v3-text-col'][" + sortIndex + "]"));
                    String[] namesBeforeSort = new String[names.size()];
                    for (int j = 0; j < names.size(); j++) {
                        namesBeforeSort[j] = names.get(j).getText();
                    }
                    sortableColumn.click();
                    wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
                    String classValue = sortableColumn.getAttribute("class");
                    if (classValue.contains("asc")) {
                        Arrays.sort(namesBeforeSort);
                    } else if (classValue.contains("desc")) {
                        Arrays.sort(namesBeforeSort, Collections.reverseOrder());
                    }

                    List<WebElement> name = driver.findElements(By.xpath("//table[@style!='display: none' and @class='v3-table']/tbody/tr[@style!='display: none']/td[@class!='v3-text-col'][" + sortIndex + "]"));
                    String[] namesAfterSort = new String[names.size()];
                    for (int k = 0; k < name.size(); k++) {
                        namesAfterSort[k] = name.get(k).getText();
                    }
                    boolean arraysEqual = Arrays.equals(namesBeforeSort, namesAfterSort);
                    assertTrue(arraysEqual);
                }
            }
        }


    }


    public void method(String column) {
        List<String> columnAsc = tableV3.getAllColumnValues(column);
        tableV3.clickOnHeader(column);
        Assert.assertTrue("cортировка по возрт", Comparators.isInOrder(columnAsc, Ordering.natural()));
        tableV3.clickOnHeader(column);
        List<String> columnDesc = tableV3.getAllColumnValues(column);
        Assert.assertTrue("cортировка по убеабвыни", Comparators.isInOrder(columnDesc, Ordering.natural().reversed()));
    }

    public WebElement findTable(){return driver.findElement(xPathOfTable);}

    public void testSorting(){
        WebElement tableHeaders = findTable().findElement(xPathOfTableHeaders);
        List<WebElement> allTableHeaders = tableHeaders.findElements(By.tagName("th"));
        Map<Integer,WebElement> allTableHeadersPositions = new HashMap<>();
        for (int i = 0; i < allTableHeaders.size(); i++) {
                WebElement element = allTableHeaders.get(i);
                allTableHeadersPositions.put(i + 1, element);
            }
        Map<Integer, WebElement> sortableHeadersPositions = new HashMap<>();
        for(Map.Entry<Integer, WebElement> entry : allTableHeadersPositions.entrySet()){
            int key = entry.getKey();
            WebElement elementHeader = entry.getValue();
            String classValue  = elementHeader.getAttribute("class");
            if(classValue.contains("sortable")){
                sortableHeadersPositions.put(key,elementHeader);
            }
        }
        List<String> sortableOptions = Arrays.asList("asc","desc");
        for(Map.Entry<Integer, WebElement> entry : sortableHeadersPositions.entrySet()){
            int currentElementPosition = entry.getKey();
            //WebElement clickableHead = findTable().findElement(By.xpath(String.format(xPathOfClickableHeader,currentElementPosition))); //здесь заголовок был найден
            for(int j = 0; j < sortableOptions.size(); j++){
                //clickableHead.click();// однако при клике на найденный заголовок упала ошибка 'element not interactable'
                WebElement firstClassValue = driver.findElement(By.xpath("//table[ @data-global-balance-rules-id!='' and  @style!='display: none']//thead//th["+ currentElementPosition +"]/div"));
                String classValue = firstClassValue.getAttribute("class");
                List<WebElement> names = driver.findElements(By.xpath("//table[ @data-global-balance-rules-id!='' and  @style!='display: none']//tbody/tr[@style!='display: none']/td[" + currentElementPosition + "]"));
                List<Object> tableCellData = new ArrayList<>();
                for(int k = 0; k < names.size(); k++){
                    tableCellData.add(names.get(k).getText());

                }

                boolean tableCellDataIsFloat = true;
                for( Object obj : tableCellData){
                    if(!(obj instanceof Float)){
                        tableCellDataIsFloat = false;
                        break;
                    }
                }

                List<Float> tableCellDataFloat = new ArrayList<>();
                List<String> tableCellDataString = new ArrayList<>();

                if(tableCellDataIsFloat){
                    for( int n = 0; n<tableCellData.size(); n++){
                        tableCellDataFloat.add((Float) tableCellData.get(n));
                    }
                } else {
                    for(int f = 0; f < tableCellData.size(); f++){
                        tableCellDataString.add((String) tableCellData.get(f));
                    }
                }

                List<Float> copiedTableCellDataFloat = new ArrayList<>();
                List<String> copiedTableCellDataString = new ArrayList<>();

                if(tableCellDataIsFloat){
                    copiedTableCellDataFloat.addAll(tableCellDataFloat);
                } else {
                    copiedTableCellDataString.addAll(tableCellDataString);
                }

                boolean tableCellDataFloatIsNull = tableCellDataFloat.isEmpty();


                if(classValue.contains("asc") && tableCellDataFloatIsNull == true){
                    Collections.sort(tableCellDataString);
                } else if (classValue.contains("desc") && tableCellDataFloatIsNull == true){
                    Collections.sort(tableCellDataString, Collections.reverseOrder());
                } else if (classValue.contains("asc") && tableCellDataFloatIsNull == false){
                    Collections.sort(tableCellDataFloat);
                } else if (classValue.contains("desc") && tableCellDataFloatIsNull == false) {
                    Collections.sort(tableCellDataFloat, Collections.reverseOrder());
                }

                if(tableCellDataIsFloat == true){
                    Assert.assertEquals(tableCellDataFloat, copiedTableCellDataFloat);
                } else {
                    Assert.assertEquals(tableCellDataString, copiedTableCellDataString);
                }


            }
        }




    }

}







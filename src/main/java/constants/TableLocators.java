package constants;

public class TableLocators {
    public static final String HEADERS_LOCATOR = "//th[contains(@class, 'sortable') and contains(.,'%s')]";
    public static final String CELL_BY_VALUE_LOCATOR = "//td[contains(.,'%s')]";
    public static final String CELL_BY_COLUMN_LOCATOR = "//td[%d]";
    public static final String CELL_BY_ROW_LOCATOR = "/tr[not(contains(@style,'display: none')) and not(contains(@class,'row-spacer'))][%d]/td";

}

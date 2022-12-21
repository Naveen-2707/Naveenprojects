package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	Select select;
	
	
	
	
	//1. get browser
	public static void getbrowser(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
			default:
				break;
			
			}
		
}
	
	
	public static String getProjectPath() {
		String property = System.getProperty("user.dir");
		return property;

	}
	
	public static String getPropertyFileValue(String key) throws IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath()+"\\Config\\Config.properties"));
		return (String) properties.get(key);

	}
	
	public static void impliciWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	
	public static void elementVisibility(WebElement element) {
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(element));
	}
	


	//1	Browser Launch
	public void browser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	
	}
	
	public void maximize() {
		driver.manage().window().maximize();

	}
	//2 Find ID
	public WebElement findElementID(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	//3 Find Name	
	public WebElement findElementName(String name) {
		WebElement findElement = driver.findElement(By.id(name));
		return findElement;
	}
	
	// Find Element By ClassName
	public WebElement findElementClassName(String classname) {
		WebElement element = driver.findElement(By.className(classname));
		return element;
		}
    //4 Pass ID value with SendKeys
	public void sendvalues(WebElement element,String Data) {
		
		element.sendKeys(Data);
	}
	//5 Pass Name value with SendKeys	
	public void passvalues(WebElement element,String data) {
		elementVisibility(element);
		
		element.sendKeys(data);
	}
	//6 get Text   
	public String getText(WebElement element) {
		elementVisibility(element);
		String text = element.getText();
		return text;
		
	}
	
	
	//8 selectByIndex	
	public void selectByIndex(WebElement element, int index) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	//9 getAllOptions
	public List<WebElement> getAllOption(WebElement element) {
		elementVisibility(element);
		
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	//10 GET ATTRIBUTES
	public String getAttributes(WebElement element) {
		elementVisibility(element);
		String attribute = element.getAttribute("value");
		return attribute;

	}
	
	//Actions DoubleClick
	public void doubleClick(WebElement element) {
		elementVisibility(element);
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
}
	//Actions RightClick
	public void rightClick(WebElement element) {
		elementVisibility(element);
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}
	
	//Actions MouseOver
	public void ActionsMouseOver(WebElement element) {
		elementVisibility(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		}
	
	//Drag and Drop
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target);
		}
	
	 //KEY DOWN
	 public void keyDown (String key) {
		 Actions actions = new Actions(driver);
		 Actions keyDown= actions.keyDown(key);
		 keyDown.perform();
	 }
	 
	 //KEY UP
	 public void keyUp (String key) {
		 Actions actions = new Actions(driver);
		 Actions keyUp= actions.keyDown(key);
		 keyUp.perform();
	 }
	
	//AlertHandlingDismiss
	public void ActionsMouseOverDismiss() {
		driver.switchTo().alert().dismiss();

	}
	
	//AlertHandlingAccept
	public void ActionsMouseOverAccept() {
		driver.switchTo().alert().accept();
		}
	
	
	//Select GetOptions
	public List<WebElement> getOptions(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;

	}
	
	//SelectByIndex
	public void selectOptionByIndex(WebElement element, int index) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	//Select By Value
	public void selectByValue(WebElement element, String value) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByValue(value);
	}
	//SelectByVisibleText
	
	public void selectByVisibleText(WebElement element, String text) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
		}
	
	//deSelectAll
	public void deSelectAll(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectAll();
	}
	
	//getFirstSelectedOptions
	public void getFirstSelectedOptions(WebElement element) {
		elementVisibility(element);
		Select select = new Select (element);
		select.getFirstSelectedOption();
		}
	
	//getAllSelected Options
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		return selectedOptions;
		}
	
	//DropDown is multiple or not
	
	public boolean isMultiple(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
		}
	
	//deSelectByIndex
	
	public void deSelectOptionByIndex(WebElement element, int index) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	
	//deSelectByText
	public void deSelectOptionByAttribute(WebElement element, String value) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByVisibleText(value);

	}
	
	//Get Text
		public String elementGetText(WebElement element) {
			elementVisibility(element);
			String text = element.getText();
			return text;
		}
	
	//Navigate to
	public void navigateToUrl(String url) {
		driver.navigate().to(url);
	}

	//navigate back
	public void navigateBack() {
		driver.navigate().back();

	}
	
	//navigate Forward
	public void navigateForward() {
		driver.navigate().forward();

	}
	
	//navigate Refresh
	public void navigateRefresh() {
		driver.navigate().refresh();

	}
	
	//close
	public void closeWindow() {
		driver.close();
	}
	
	
	
	//quit
	public void quitWindow() {
		driver.quit();
	}
	
	//clear TextBox
	public void clear(WebElement element) {
		element.clear();
		}
	
	//Get Title
	 public String getTitle() {
		 String string= driver.getTitle();
		 return string;
	 }
	 
	 //Get the Entered url
	 public String getCurrentUrl() {
		 String string = driver.getCurrentUrl();
		 return string;
		  }
	 
	 //Get Window Handle
	 public  String getWindowhandle() {
		 String string = driver.getWindowHandle();
		 return string;
		 }
	 
	 //Get Window Handles
	 public  Set<String> getWindowhandles() {
		 Set<String> set = driver.getWindowHandles();
		 return set;
		 }
	
	
	//Switch to Child windows
	 public void switchWindow(int index) {
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> list = new ArrayList<String>();
		 list.addAll(windowHandles);
		 driver.switchTo().window(list.get(index));
	 }
	 
	 //Switch to frame byIndex
	 public void switchToFrame (int index) {
		 driver.switchTo().frame(index);
		 }
	 
	 //Switch to frame byId
	 public void switchToFramebyId (String name) {
		 driver.switchTo().frame(name);
		 }
	 
	 //javaScriptExecutorClickButton
	 public void elementClickButtonByJs (WebElement element) {
		 elementVisibility(element);
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].click()", element);
	 }
	 
	 //javaScriptScrollDown
	 public void javaScriptScrollDown(WebElement element) {
		 elementVisibility(element);
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeAsyncScript("arguments[0].ScrollIntoView(true)", element);
		 }
	 
	 
	 //javaScriptScrollUp
	 public void javaScriptScrollUp(WebElement element) {
		 elementVisibility(element);
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeAsyncScript("arguments[0].ScrollIntoView(false)", element);
		 }
	 
	 //DATA FROM EXCEL TO BROWSER
/*	 public static String getDataFromExcel(String pathName, String sheetName, int rowNumber, int cellNumber) throws IOException {
     String data = null;
     File file = new File(pathName);
     FileInputStream stream = new FileInputStream(file);
     Workbook workbook = new XSSFWorkbook(stream);
     Sheet sheet = workbook.getSheet(sheetName);
     Row row = sheet.getRow(rowNumber);
     org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellNumber);
     CellType cellType = cell.getCellType();
     if (cellType.toString().equals("String")) {
    	 data= cell.getStringCellValue();
     }
     if (cellType.toString().equals("NUMERIC")) {
   	 if (DateUtil.isCellDateFormatted(cell)) {
    		  Date dateCellValue = cell.getDateCellValue();
    		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    		  data = dateFormat.format(dateCellValue);
    		  }
    	 else 
    	 {
    		 double db = cell.getNumericCellValue();
    		 Long l = (long) db;
    		 data = String.valueOf(l);
    	 }
     }
	return data;
	} */
	 
	 //11
	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;

	}
	//12
	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
	//13
	public WebElement findElementByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		return element;
	}
	//14
	public WebElement findElementByCssSelector(String attributeValue) {
		WebElement element = driver.findElement(By.cssSelector(attributeValue));
		return element;
	}
	//15
	public WebElement findElementBylinkText(String attributeValue) {
		WebElement element = driver.findElement(By.linkText(attributeValue));
		return element;
	}
	//16
	public WebElement findElementByPartiallinkText(String attributeValue) {
		WebElement element = driver.findElement(By.partialLinkText(attributeValue));
		return element;
	}
	//17
	public WebElement findElementBytagName(String attributeValue) {
		WebElement element = driver.findElement(By.tagName(attributeValue));
		return element;
	}
	
	
	
	
	//22
	public String elementGetAttributeValue(WebElement element,String attributeName) {
		elementVisibility(element);
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}
	//23
	public void selectOptionByText(WebElement element, String text) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	//24
	public void selectOptionByAttribute(WebElement element, String text) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByValue(text);
	}
	
	//30
	public void deSelectOptionByText(WebElement element, String text) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByVisibleText(text);

	}

	
	//34
	public String elementGetText(WebElement element, String value) {
		elementVisibility(element);
		String text = element.getAttribute(value);
		return text;

	}

	//39
	public void acceptOkAlert(String data) {
		driver.switchTo().alert().sendKeys(data);
		driver.switchTo().alert().accept();

	}

	//42
	public void switchTomainPageFromFrame() {
		driver.switchTo().defaultContent();
	}
	//43
	public String GetParentWindowId() {
		String id = driver.getWindowHandle();
		return id;
	}
	//44
	public Set<String> getAllWindowsId() {
		Set<String> id = driver.getWindowHandles();
		return id;
	}
	//45
	public void switchToWindowByTitle(String title) {
		driver.switchTo().window(title);

	}
	//46
	public void switchToWindowByUrl(String Url) {
		driver.switchTo().window(Url);
	}

	
	//Robot class 
	public void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		}
	
	public void tab() throws AWTException {
		Robot t = new Robot();
		t.keyPress(KeyEvent.VK_TAB);
		t.keyRelease(KeyEvent.VK_TAB);
		}
	
	public void click(WebElement element) {
		elementVisibility(element);
		element.click();

	}
}












package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void enterText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void btnClick(WebElement element) {
		element.click();
	}

	public void screenShot(String data) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "\\target\\" + data + ".png");
		FileUtils.copyFile(srcFile, destFile);
	}

	public static void selectDropdown(WebElement dropdown, String text, String by) {
		Select sel = new Select(dropdown);
		if (by == "vt") {
			sel.selectByVisibleText(text);
		} else if (by == "val") {
			sel.selectByValue(text);
		} else {
			int indx = Integer.parseInt(text);
			sel.selectByIndex(indx);
		}
	}

	public String getAttributeText(WebElement element) {
		return element.getAttribute("value");
	}
	
	public void putExcelData(String pathName,String sheet,int row,int cell, String data) throws IOException {
		File file =new File(pathName);
		FileInputStream stream =new FileInputStream(file);
		Workbook wb=new XSSFWorkbook(stream);
		Sheet sheet1 = wb.getSheet(sheet);
		Row row1 = sheet1.createRow(row);
		Cell cell2 = row1.createCell(cell);
		cell2.setCellValue(data);
		
		FileOutputStream fs  = new FileOutputStream(file);
		wb.write(fs);
		}
		
}

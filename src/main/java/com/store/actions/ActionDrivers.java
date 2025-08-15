package com.store.actions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDrivers implements ActionDriver {

	@Override
	public void scrollByVisibilityOfElement‎(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView()", ele);

	}

	@Override
	public void click(WebDriver driver, WebElement ele) {

		Actions ac = new Actions(driver);
		ac.moveToElement(ele).click().build().perform();

	}

	@Override
	public boolean isDisplayed(WebDriver driver, WebElement ele) {

		boolean flag = false;
		flag = findElement(driver, ele);

		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("the element is dispalyed");
			} else {
				System.out.println("The element is not dispalyed ");
			}
		} else {
			System.out.println("Not Dispalyed");
		}

		return flag;

	}

	@Override
	public boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {

			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;

		} catch (Exception e) {
			System.out.println("Location not found");
			flag = false;

		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to  enter value");
			}
		}

		return flag;
	}

	@Override
	public boolean findElement(WebDriver ldriver, WebElement ele) {

		boolean flag = false;
		try {

			ele.isDisplayed();
			flag = true;

		} catch (Exception e) {
			// TODO: handle exception

			flag = false;

		} finally {
			if (flag) {
				System.out.println("Successfull found ele");
			} else {
				System.out.println("Unable to locate element");

			}
		}
		return flag;

	}

	@Override
	public boolean isSelected(WebDriver ldriver, WebElement ele) {

		boolean flag = false;
		flag = findElement(ldriver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is selected");
			} else {
				System.out.println("The element is not selected");

			}
		} else {
			System.out.println("Not Selected");
		}

		return flag;
	}

	@Override
	public boolean isEnabled(WebDriver ldriver, WebElement ele) {
		boolean flag = false;
		flag = findElement(ldriver, ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				System.out.println("The element is Enabled");
			} else {

				System.out.println("The element is not Enabled");
			}
		} else {
			System.out.println("Not Enabled ");
		}
		return flag;
	}

	@Override
	public boolean selectBySendkeys(String value, WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;

		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from drop down");
			} else {
				System.out.println("not selct valurefrom from drop down");
			}
		}

	}

	@Override
	public boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option not selected by Index");
			}
		}
	}

	@Override
	public boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}

	@Override
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}

	@Override
	public boolean mouseHoverByJavaScript(WebElement ele, WebDriver driver) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}

	}

	@Override
	public boolean JSClick(WebDriver driver, WebElement ele) {

		boolean flag = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
			flag = true;

		} catch (Exception e) {
			throw e;
		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;

	}

	@Override
	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;

		} catch (Exception e) {

			return false;

		} finally {
			if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}

		}

	}

	@Override
	public boolean switchToFrameById(WebDriver driver, String idValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Id \"" + idValue + "\" is selected");
			} else {
				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}

	@Override
	public boolean switchToFrameByName(WebDriver driver, String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}

	@Override
	public boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!flag) {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}

	}

	@Override
	public void mouseOverElement(WebDriver driver, WebElement element) {

		boolean flag = false;
		try {

			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on");
			}
		}

	}

	@Override
	public boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			WebElement elemnt = driver.findElement((By) ele);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions act = new Actions(driver);
			act.moveToElement(elemnt).build().perform();
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public boolean mouseover(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			/*
			 * if (flag) {
			 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
			 * +"\""); } else {
			 * failureReport("MouseOver","MouseOver action is not performed on \""
			 * +locatorName+"\""); }
			 */
		}
	}

	@Override
	public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		boolean flag = false;
		try {

			Actions act = new Actions(driver);
			act.dragAndDropBy(source, x, y).build().perform();
			flag = true;
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		} finally {
			if (flag) {
				System.out.println("Draggable Action is performed on \"" + source + "\"");
			} else if (!flag) {
				System.out.println("Draggable action is not performed on \"" + source + "\"");
			}

		}

	}

	@Override
	public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action is performed");
			} else if(!flag) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}

	@Override
	public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Slider Action is performed");
			} else {
				System.out.println("Slider Action is not performed");
			}
		}
	}

	@Override
	public boolean rightclick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}

	@Override
	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count-1]);

			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			//flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
	}

	@Override
	public boolean switchToNewWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToOldWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getColumncount(WebElement row) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount(WebElement table) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean Alert(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean launchUrl(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlertPresent(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCurrentURL(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean click1(WebElement locator, String locatorName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implicitWait(WebDriver driver, int timeOut) {
		// TODO Auto-generated method stub

	}

	@Override
	public void explicitWait(WebDriver driver, WebElement element, int timeOut) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		// TODO Auto-generated method stub

	}

	@Override
	public String screenShot(WebDriver driver, String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentTime() {
		// TODO Auto-generated method stub
		return null;
	}

}

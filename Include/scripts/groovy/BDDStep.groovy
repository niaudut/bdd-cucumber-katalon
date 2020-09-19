import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.OpenBrowserKeyword

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class BDDStep {
	@Given ("User navigates to login page")
	def navigateToUrl(){
		println("\n Navigate to Url")
		WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/')
	}

	@When ("User input (.*) and (.*)")
	def inputCredential(String username, String password){
		println("\n User input Credential")
		WebUI.setText(findTestObject('OrangeHRM/Txt_Username'), username)
		WebUI.setEncryptedText(findTestObject('OrangeHRM/Txt_Password'), password)
	}

	@And ("Click on login button")
	def clickLoginButton(){
		println("\n Click Login Button")
		WebUI.click(findTestObject('OrangeHRM/Btn_Login'))
	}

	@Then ("User is navigated to homepage")
	def successLogin(){
		println("\n User success Login")
		WebUI.verifyElementPresent(findTestObject('OrangeHRM/Ttl_Welcome'), 0)
	}
	
	@When ("Click on welcome button")
	def clickWelcomeButton(){
		WebUI.click(findTestObject('OrangeHRM/Btn_Welcome'))
	}
	
	@Then ("User should see about link")
	def seeAboutLink(){
		WebUI.verifyElementPresent(findTestObject('OrangeHRM/Ttl_About'), 0)
	}
	
	@When ("User click on admin tab menu")
	def clickAdminTabMenu(){
		WebUI.click(findTestObject('OrangeHRM/Btn_Admin'))
	}
	
	@And ("Click on nasionalities tab menu")
	def clickNationalitiesTabMenu(){
		WebUI.click(findTestObject('OrangeHRM/Btn_Nationalities'))
	}
	
	@And ("Click on add button")
	def clickAddButton(){
		WebUI.click(findTestObject('OrangeHRM/Btn_Add_Nationalities'))
	}
	
	@And ("User input nasionality name")
	def inputNationalityName(){
		WebUI.setText(findTestObject('OrangeHRM/Txt_Nationality_Name'), 'Aaa')
	}
	
	@And ("Click on save button")
	def clickSaveButton(){
		WebUI.click(findTestObject('OrangeHRM/Btn_Save_Add_Nationalities'))
	}
	
	@Then ("User should see new nationality")
	def successAddNationalities(){
		WebUI.verifyElementPresent(findTestObject('OrangeHRM/Ttl_Notif_Success_Added'), 0, FailureHandling.STOP_ON_FAILURE)
	}
	
	@When ("User delete new nationality")
	def clickDeleteButton(){
		WebUI.click(findTestObject('OrangeHRM/Chk_Aaa'))
		WebUI.click(findTestObject('OrangeHRM/Btn_Delete_Nationalities'))
		WebUI.click(findTestObject('OrangeHRM/Btn_Ok_Delete_Nationalities'))	
	}
	
	@Then ("User should see notif success deleted")
	def successDeleteNationalities(){
		WebUI.verifyElementPresent(findTestObject('OrangeHRM/Ttl_Notif_Success_Deleted'), 0)
	}
	
	@When ("Click on my info tab menu")
	def clickMyInfoTabMenu(){
		WebUI.click(findTestObject('OrangeHRM/Btn_My_Info'))
	}
	
	@And ("Click on edit personal detail button")
	def clickEditPersonalDetailButton(){
		WebUI.click(findTestObject('OrangeHRM/Btn_Edit_Personal_Details'))
	}
	
	@And ("User input middle name, license number, license expiry date, nationality")
	def inputEditData(){
		WebUI.setText(findTestObject('OrangeHRM/Txt_Middle_Name'), 'June')
		WebUI.setText(findTestObject('OrangeHRM/Txt_License_Number'), '0001 0002 0003')
		WebUI.setText(findTestObject('OrangeHRM/Txt_License_ExpDate'), '2025-06-05')
		WebUI.selectOptionByValue(findTestObject('OrangeHRM/Ddl_Nationality'), '4', false)
	}
	
	@And ("Click on save personal detail button")
	def clickSavePersonalDetailButton(){
		WebUI.click(findTestObject('OrangeHRM/Btn_Save_Personal_Details'))
	}
	
	@Then ("User should see notif success edited")
	def closeBrowser(){
		WebUI.verifyElementPresent(findTestObject('OrangeHRM/Ttl_Notif_Success_Edited'), 0)
		WebUI.closeBrowser()
	}
}
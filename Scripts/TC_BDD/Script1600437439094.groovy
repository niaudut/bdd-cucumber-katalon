import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('https://opensource-demo.orangehrmlive.com')

WebUI.setText(findTestObject('OrangeHRM/Txt_Username'), 'Admin')

WebUI.setEncryptedText(findTestObject('OrangeHRM/Txt_Password'), 'hUKwJTbofgPU9eVlw/CnDQ==')

WebUI.click(findTestObject('OrangeHRM/Btn_Login'))

WebUI.verifyElementPresent(findTestObject('OrangeHRM/Ttl_Welcome'), 0)

WebUI.click(findTestObject('OrangeHRM/Btn_Welcome'))

WebUI.verifyElementPresent(findTestObject('OrangeHRM/Ttl_About'), 0)

WebUI.click(findTestObject('OrangeHRM/Btn_Admin'))

WebUI.click(findTestObject('OrangeHRM/Btn_Nationalities'))

WebUI.click(findTestObject('OrangeHRM/Btn_Add_Nationalities'))

WebUI.setText(findTestObject('OrangeHRM/Txt_Nationality_Name'), 'Aaa')

WebUI.click(findTestObject('OrangeHRM/Btn_Save_Add_Nationalities'))

WebUI.verifyElementPresent(findTestObject('OrangeHRM/Ttl_Notif_Success_Added'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OrangeHRM/Chk_Aaa'))

WebUI.click(findTestObject('OrangeHRM/Btn_Delete_Nationalities'))

WebUI.click(findTestObject('OrangeHRM/Btn_Ok_Delete_Nationalities'))

WebUI.verifyElementPresent(findTestObject('OrangeHRM/Ttl_Notif_Success_Deleted'), 0)

WebUI.click(findTestObject('OrangeHRM/Btn_My_Info'))

WebUI.click(findTestObject('OrangeHRM/Btn_Edit_Personal_Details'))

WebUI.setText(findTestObject('OrangeHRM/Txt_Middle_Name'), 'June')

WebUI.setText(findTestObject('OrangeHRM/Txt_License_Number'), '0001 0002 0003')

WebUI.setText(findTestObject('OrangeHRM/Txt_License_ExpDate'), '2025-06-05')

WebUI.selectOptionByValue(findTestObject('OrangeHRM/Ddl_Nationality'), '4', false)

WebUI.click(findTestObject('OrangeHRM/Btn_Save_Personal_Details'))

WebUI.verifyElementPresent(findTestObject('OrangeHRM/Ttl_Notif_Success_Edited'), 0)

WebUI.closeBrowser()


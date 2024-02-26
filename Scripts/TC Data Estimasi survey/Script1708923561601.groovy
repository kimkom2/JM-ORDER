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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestData Hohendy = findTestData('Data Files/Data Pengajuan/Data pengajuan')

for (int baris = 1; baris <= Hohendy.getRowNumbers(); baris++)
	{
			if (Hohendy.getValue('Use', baris) == 'Yes')
			{
					
			//Mobile.startExistingApplication('id.co.jmpmf.jmo')
			
			Mobile.sendKeys(findTestObject('Object Repository/Survey/Tanggal Survey'), Hohendy.getValue('Tanggal Survey', baris), FailureHandling.STOP_ON_FAILURE)
			
			Mobile.sendKeys(findTestObject('Object Repository/Survey/Jam Survey'), Hohendy.getValue('Jam Survey', baris), FailureHandling.STOP_ON_FAILURE)
			
			if (Hohendy.getValue('Pekerjaan', baris)== 'Wiraswasta')
				{
					Mobile.sendKeys(findTestObject('Object Repository/Survey/Tanggal Survey Tempat Usaha'), Hohendy.getValue('Tanggal Survey usaha', baris), FailureHandling.STOP_ON_FAILURE)
			
					Mobile.sendKeys(findTestObject('Object Repository/Survey/Jam Survey Tempat Usaha'), Hohendy.getValue('Jam Survey Tmpt usaha', baris), FailureHandling.STOP_ON_FAILURE)
					
					Mobile.hideKeyboard()
				}
			Mobile.delay(2, FailureHandling.OPTIONAL)
						
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Button - Selanjutnya'), 0, FailureHandling.OPTIONAL)
			
			Mobile.delay(2, FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Survey/Button - Sumbit Form'), 0, FailureHandling.OPTIONAL)
			
			Mobile.delay(2, FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Survey/Button - Ya'), 0, FailureHandling.OPTIONAL)
						
			}		
	}
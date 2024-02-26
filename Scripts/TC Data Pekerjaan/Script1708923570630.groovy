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
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Data Pekerjaan/Spinner Pekerjaan'), 0, FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Data Pekerjaan/Pekerjaan ' + Hohendy.getValue('Pekerjaan', baris)), 0, FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Data Pekerjaan/Spinner Bulan'), 0, FailureHandling.OPTIONAL)

			Mobile.delay(2, FailureHandling.OPTIONAL)
			
			Mobile.scrollToText(Hohendy.getValue('Bulan Bekerja', baris), FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Data Pekerjaan/Bulan Berkerja/Bulan ' + Hohendy.getValue('Bulan Bekerja', baris)), 0, FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Data Pekerjaan/Spinner Tahun'), 0, FailureHandling.OPTIONAL)
			
			Mobile.delay(2, FailureHandling.OPTIONAL)
						
			Mobile.scrollToText(Hohendy.getValue('Tahun Bekerja', baris), FailureHandling.OPTIONAL)
						
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Data Pekerjaan/Tahun bekerja/Tahun ' + Hohendy.getValue('Tahun Bekerja', baris)), 0, FailureHandling.OPTIONAL)

			Mobile.delay(2, FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Data Pekerjaan/Button - Selanjutnya'), 0, FailureHandling.OPTIONAL)
		}
}




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
		while (true) 
		{
		    if (Mobile.verifyElementNotExist(findTestObject('Object Repository/Pasangan/NIK Pasangan'), 1, FailureHandling.OPTIONAL) == 
		    true) 
			{
		        Mobile.swipe(0, 250, 0, 0)
		    } 
			else 
			{
		        Mobile.tap(findTestObject('Object Repository/Pasangan/Button - Browse KTP Menikah'), 0)
		
		        Mobile.tap(findTestObject('Object Repository/Pasangan/Capture photo from camera Menikah'), 0)
		
		        Mobile.tap(findTestObject('Object Repository/Pasangan/Button camera'), 0)
		
		        Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		        Mobile.tapAtPosition(274, 879)
		
		        Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		        Mobile.tap(findTestObject('Object Repository/Pasangan/Button OK'), 0)
		
		        Mobile.hideKeyboard()
		
		        Mobile.tap(findTestObject('Object Repository/Pasangan/Pilih Kewarganegaraan'), 0)
		
		        Mobile.hideKeyboard()
		
				Mobile.tap(findTestObject('Object Repository/Pasangan/Warga ' + Hohendy.getValue('Warga negara pasangan', baris)), 0, FailureHandling.STOP_ON_FAILURE)
		
		        Mobile.hideKeyboard()
		
		        Mobile.setText(findTestObject('Pasangan/NIK Pasangan'), Hohendy.getValue('NIK PASANGAN', baris), 0)
				
				Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
				
				Mobile.tapAtPosition(435, 891, FailureHandling.STOP_ON_FAILURE)
				
				Mobile.hideKeyboard()
		
		        break
		    }   
		}
	
		while (true) 
		{
			if (Mobile.verifyElementNotExist(findTestObject('Object Repository/Pasangan/CheckBox - Alamat KTP sama dengan calon debitur'), 1, FailureHandling.OPTIONAL) ==
			true) 
			{
				Mobile.swipe(0, 250, 0, 0)
			} 
			else 
			{	
				
				Mobile.setText(findTestObject('Object Repository/Pasangan/EditText - Nama Pasangan'), Hohendy.getValue('Nama Pasangan', baris), 0)
				Mobile.hideKeyboard()
				
				Mobile.setText(findTestObject('Pasangan/EditText - Tempat Lahir Pasangan'), Hohendy.getValue('Tempat Lahir pasangan', baris), 0)
				
				Mobile.hideKeyboard()
				
				Mobile.sendKeys(findTestObject('Pasangan/EditText - Tanggal Lahir Pasangan'), Hohendy.getValue('Tanggal lahir pasangan', baris))
				
				Mobile.hideKeyboard()
				
				Mobile.tap(findTestObject('Object Repository/Pasangan/CheckBox - Alamat KTP sama dengan calon debitur'), 0)
				
				Mobile.hideKeyboard()
				
				break
			}
		}
	
		while (true) 
		{
			if (Mobile.verifyElementNotExist(findTestObject('Object Repository/Pasangan/Nama Ibu Kandung Pasangan'), 1, FailureHandling.OPTIONAL) ==
			true) 
			{
			Mobile.swipe(0, 250, 0, 0)
			} 
			else 
			{
				Mobile.setText(findTestObject('Object Repository/Pasangan/No Handphone Pasangan'), Hohendy.getValue('Nomor Hp Pasangan', baris), 0)
				Mobile.hideKeyboard()
				Mobile.setText(findTestObject('Object Repository/Pasangan/Nama Ibu Kandung Pasangan'), Hohendy.getValue('Nama Ibu Pasangan', baris), 0)
				Mobile.hideKeyboard()
				break
			}
		}
  }
}			

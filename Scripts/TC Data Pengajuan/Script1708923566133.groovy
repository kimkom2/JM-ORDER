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
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Spinner Nama Supplier'), 0, FailureHandling.OPTIONAL)
			
			Mobile.setText(findTestObject('Object Repository/Data Pengajuan/Search EditText'), Hohendy.getValue('Supplier', baris), 0)
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Pilih index 0'), 0, FailureHandling.OPTIONAL)
			
			Mobile.hideKeyboard()
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Spinner Tipe Product'), 0, FailureHandling.OPTIONAL)
				
			Mobile.delay(2, FailureHandling.OPTIONAL)
			
			Mobile.scrollToText(Hohendy.getValue('Product', baris), FailureHandling.OPTIONAL)
			
			Mobile.delay(2, FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Tipe Product/Product ' + Hohendy.getValue('Product', baris)), 0, FailureHandling.OPTIONAL)
			
			Mobile.hideKeyboard()
			
			if (
				Hohendy.getValue('Product', baris)== 'Dahsyat - Multipurpose 4W'||
				Hohendy.getValue('Product', baris)== 'Dahsyat - Multipurpose 2W'
			   )
				{
					Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Spinner Jaminan BPKB'), 0, FailureHandling.OPTIONAL)
					
					Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Jaminan BPKB/BPKB ' + Hohendy.getValue('BPKB Atas nama', baris)), 0, FailureHandling.OPTIONAL)
					
					Mobile.hideKeyboard()
				}
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Spinner Source of application'), 0, FailureHandling.OPTIONAL)
			
			Mobile.delay(2, FailureHandling.OPTIONAL)
			
			Mobile.scrollToText(Hohendy.getValue('Source application', baris), FailureHandling.OPTIONAL)
			
			Mobile.delay(2, FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Source application/Source ' +  Hohendy.getValue('Source application', baris)), 0, FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Spinner Jenis asset'), 0, FailureHandling.OPTIONAL)
			
			Mobile.delay(2, FailureHandling.OPTIONAL)
			
			Mobile.setText(findTestObject('Object Repository/Data Pengajuan/Search EditText'), Hohendy.getValue('Jenis Asset', baris), 0)
			
			Mobile.delay(2, FailureHandling.OPTIONAL)
			
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Pilih index 0'), 0, FailureHandling.OPTIONAL)
			
			while (true)
				{
				if (Mobile.verifyElementNotExist(findTestObject('Object Repository/Data Pengajuan/Button - Selanjutnya'), 1, FailureHandling.OPTIONAL) == true) // step 1
					{
						Mobile.swipe(0, 220, 0, 0) // scroll lambat2 220 minimal nya. // step 2
					}
					else
					{
						Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Spinner Tahun pembuatan'), 0, FailureHandling.OPTIONAL)
						
						Mobile.delay(2, FailureHandling.OPTIONAL)
						
						Mobile.scrollToText(Hohendy.getValue('Tahun Pembuatan', baris), FailureHandling.OPTIONAL)
						
						Mobile.delay(2, FailureHandling.OPTIONAL)
						
						Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Tahun Pembuatan/Tahun ' +  Hohendy.getValue('Tahun Pembuatan', baris)), 0, FailureHandling.OPTIONAL)
						
						Mobile.setText(findTestObject('Object Repository/Data Pengajuan/Text Harga Kendaraan'), Hohendy.getValue('Harga Kendaraan', baris), 0)
						
						Mobile.hideKeyboard()
						
						if (
						Hohendy.getValue('Product', baris)== 'Used Car'|| 
						Hohendy.getValue('Product', baris)== 'New Car' ||
						Hohendy.getValue('Product', baris)== 'COP' ||
						Hohendy.getValue('Product', baris)== 'Electronic' ||
						Hohendy.getValue('Product', baris)== 'New Bike' ||
						Hohendy.getValue('Product', baris)== 'Pembiayaan Korporasi' ||
						Hohendy.getValue('Product', baris)== 'Pembiayaan Multiproduk' ||
						Hohendy.getValue('Product', baris)== 'Used Bike' ||
						Hohendy.getValue('Product', baris)== 'Used Car' ||
						Hohendy.getValue('Product', baris)== 'White Goods')
						{
							Mobile.setText(findTestObject('Object Repository/Data Pengajuan/Text DP'), Hohendy.getValue('DP Kendaraan', baris), 0)
							
							Mobile.hideKeyboard()
						}
						else
							{
								Mobile.setText(findTestObject('Object Repository/Data Pengajuan/Text NTF Murni'), Hohendy.getValue('NTF Murni', baris), 0)
								
								Mobile.hideKeyboard()
							}												
						Mobile.setText(findTestObject('Object Repository/Data Pengajuan/Text Jangka Waktu Pembiayaan'), Hohendy.getValue('Jangka waktu', baris), 0)
						
						Mobile.hideKeyboard()
												
						break
					 }
				}
				
			Mobile.tap(findTestObject('Object Repository/Data Pengajuan/Button - Selanjutnya'), 0, FailureHandling.OPTIONAL)
			}		
	}
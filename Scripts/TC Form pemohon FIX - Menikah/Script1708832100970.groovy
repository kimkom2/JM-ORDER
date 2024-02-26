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
		
		Mobile.tap(findTestObject('Object Repository/Form Order - Pengajuan - Status pernikahan/Pilih Status pernikahan'), 0, FailureHandling.STOP_ON_FAILURE)
			
		Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		// kondisi dimana button TAP/list/ bisa di combine dengan + Excel ya. jadi status (Menikah sampai single,duda dari object repositori di bandingin dengan excel)	start
		Mobile.tap(findTestObject('Object Repository/Form Order - Pengajuan - Status pernikahan/Status pernikahan/Status ' + Hohendy.getValue('Status pernikahan', baris)), 0, FailureHandling.STOP_ON_FAILURE)
		// kondisi dimana button TAP/list/ bisa di combine dengan + Excel ya. jadi status (Menikah sampai single,duda dari object repositori di bandingin dengan excel)	start
		
		Mobile.tap(findTestObject('Form Order - Pengajuan - Status pernikahan/Button - Selanjutnya'), 0, FailureHandling.STOP_ON_FAILURE)
		
		
		Mobile.setText(findTestObject('Form data Pemohon/EditText - NIK'), Hohendy.getValue('NIK', baris), 0)
		
		Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		'Beda HP beda posisi button tab'
		Mobile.tapAtPosition(435, 891, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.tap(findTestObject('Form data Pemohon/Button Foto after select kamera/Browse (2)'), 0)
		
		Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.tap(findTestObject('Form data Pemohon/Button Foto after select kamera/Capture photo from camera (2)'), 0)
		
		Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		'beda hp beda kondisi lokasi'
		Mobile.tap(findTestObject('Form data Pemohon/Button Foto after select kamera/Button Foto (J2Prime samsung)'), 0, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		'beda hp beda kondisi lokasi\r\n'
		Mobile.tap(findTestObject('Form data Pemohon/Button Foto after select kamera/Button OK (J2Prime samsung)'), 0, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
	
		// kondisi dimana dia baca RO / NON RO di bandiing dari inputan nama ktp dengan fungsi contains yang ada di excel./ parameter pantekan.
		if (Mobile.getText(findTestObject('Form data Pemohon/EditText - Nama'), 0).contains(Hohendy.getValue('Nama konsumen', baris))) 
			{
				// cara gabungin atau manggil test case yang beda di panggil dlm test case ini.
			if (Hohendy.getValue('Status pernikahan', baris)== 'Menikah') // kondisi dimana kalau dia menikah akan panggil test case ini.
			{
				Mobile.callTestCase(findTestCase('Test Cases/TC Menikah'), null)
			}
			
			while (true) 
			{
			if (Mobile.verifyElementNotExist(findTestObject('Object Repository/Form data Pemohon/Button - Selanjutnya'), 1, FailureHandling.OPTIONAL) == true) // step 1
				{
					Mobile.swipe(0, 400, 0, 0) // scroll lambat2 220 minimal nya. // step 2
				} 
				else
				{
					//Mobile.scrollToText('Tahun Menempati', FailureHandling.CONTINUE_ON_FAILURE)
						
					Mobile.setText(findTestObject('Form data Pemohon/Jumlah Tanggungan'), Hohendy.getValue('Jumlah tanggunan', baris), 0)
						
					Mobile.hideKeyboard()
						
					Mobile.tap(findTestObject('Object Repository/Form data Pemohon/Pilih Status Rumah'), 0)
						
					Mobile.setText(findTestObject('Object Repository/Form data Pemohon/Search'), Hohendy.getValue('Status Rumah', baris) , 0)
						
					Mobile.tap(findTestObject('Object Repository/Kepemilikan Rumah/TextView - Pilih test'), 0)
						
					Mobile.hideKeyboard()
						
					Mobile.tap(findTestObject('Object Repository/Form data Pemohon/Pilih tahun menempati'), 0)
						
					Mobile.setText(findTestObject('Object Repository/Form data Pemohon/Search'), Hohendy.getValue('Tahun Menempati', baris) , 0)
						
					Mobile.tap(findTestObject('Object Repository/Kepemilikan Rumah/TextView - Pilih test'), 0)
							
					Mobile.tap(findTestObject('Object Repository/Form data Pemohon/Button - Selanjutnya'), 0)	
											
					break
				 }
			}		
		} 
		else 
		{
			Mobile.setText(findTestObject('Form data Pemohon/EditText - Nama'), Hohendy.getValue('Nama konsumen', baris), 0)
	
			Mobile.hideKeyboard()	
		
			while (true) 
			{
				if (Mobile.verifyElementNotExist(findTestObject('Object Repository/Form data Pemohon/EditText - RW (1)'), 1, FailureHandling.OPTIONAL) ==
				true) // step 1
				 {
					Mobile.swipe(0, 400, 0, 0) // scroll lambat2 220 minimal nya. // step 2
				 } else
					{
						//Mobile.scrollToText('Tanggal Lahir', FailureHandling.CONTINUE_ON_FAILURE)
						
						Mobile.setText(findTestObject('Form data Pemohon/EditText - Tempat Lahir'), Hohendy.getValue('Tempat Lahir', baris), 0)
						
						Mobile.hideKeyboard()
						
						Mobile.sendKeys(findTestObject('Form data Pemohon/EditText - Tanggal Lahir'), Hohendy.getValue('Tanggal lahir', baris), FailureHandling.STOP_ON_FAILURE)
						
						Mobile.hideKeyboard()
						
						Mobile.setText(findTestObject('Form data Pemohon/EditText - Alamat New'), Hohendy.getValue('Alamat Rumah', baris), 0)
						
						Mobile.hideKeyboard()
						
						Mobile.setText(findTestObject('Form data Pemohon/EditText - RT (1)'), Hohendy.getValue('RT', baris), 0)
						
						Mobile.hideKeyboard()
						
						Mobile.setText(findTestObject('Form data Pemohon/EditText - RW (1)'), Hohendy.getValue('RW', baris), 0)
						
						Mobile.hideKeyboard()
						break
					}
			  }
	    
		// Logic perulangan
		// di tampung dulu nilai true nya
		// Jika kalau tidak di temukan si pilih kota, maka di jalan kan dulu dari step 1 sampai ketemu si pilih kota.
		    while (true) 
			{
		        if (Mobile.verifyElementNotExist(findTestObject('Object Repository/Form data Pemohon/Pilih kelurahan'), 1, FailureHandling.OPTIONAL) == 
		        true) // step 1
				 {
		            Mobile.swipe(0, 400, 0, 0) // scroll lambat2 220 minimal nya. // step 2
		         } else 
					{
		            Mobile.tap(findTestObject('Object Repository/Form data Pemohon/Pilih Kota'), 0)
		
		            Mobile.setText(findTestObject('Object Repository/Form data Pemohon/Search'), Hohendy.getValue('Kota', baris), 0)
		
		            Mobile.tap(findTestObject('Object Repository/Kepemilikan Rumah/TextView - Pilih test'), 0)
		
		            Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		            Mobile.tap(findTestObject('Object Repository/Form data Pemohon/Pilih Kecamatan'), 0)
		
		            Mobile.setText(findTestObject('Object Repository/Form data Pemohon/Search'), Hohendy.getValue('Kecamatan', baris), 0)
		
		            Mobile.tap(findTestObject('Object Repository/Kepemilikan Rumah/TextView - Pilih test'), 0)
		
		            Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		            Mobile.tap(findTestObject('Object Repository/Form data Pemohon/Pilih kelurahan'), 0)
		
		            Mobile.setText(findTestObject('Object Repository/Form data Pemohon/Search'), Hohendy.getValue('Kelurahan', baris), 0)
		
		            Mobile.tap(findTestObject('Object Repository/Kepemilikan Rumah/TextView - Pilih test'), 0)
		
		            Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
					
					// step 3
					// step baru ketemuu pilih kelurahan, habis itu langsung di pilih komponen di dalam nya.
					// keluar dari perulangan nya.
		            break
		        }
		    }
	    
		    while (true) 
			{
		        if (Mobile.verifyElementNotExist(findTestObject('Object Repository/Form data Pemohon/EditText - Nama Ibu Kandung'), 1, FailureHandling.OPTIONAL) == 
		        true) // step 1
				 {
		            Mobile.swipe(0, 250, 0, 0) // scroll lambat2 220 minimal nya. // step 2
		         } else 
					{
		
						Mobile.setText(findTestObject('Form data Pemohon/No Handphone'), Hohendy.getValue('Nomor Hp', baris), 0)
						
						Mobile.hideKeyboard()
						
						Mobile.setText(findTestObject('Form data Pemohon/Nama Ibu Kandung'), Hohendy.getValue('Nama Ibu', baris), 0)
						
						Mobile.hideKeyboard()
					
					// step 3
					// step baru ketemuu pilih kelurahan, habis itu langsung di pilih komponen di dalam nya.
					// keluar dari perulangan nya.
		            break
		        }
		    }
		
			// cara gabungin atau manggil test case yang beda di panggil dlm test case ini.
			if (Hohendy.getValue('Status pernikahan', baris)== 'Menikah') // kondisi dimana kalau dia menikah akan panggil test case ini.
			{
				Mobile.callTestCase(findTestCase('Test Cases/TC Menikah'), null)// memang null belakgnnya.
			}
		
			while (true) 
			{
				if (Mobile.verifyElementNotExist(findTestObject('Object Repository/Form data Pemohon/Button - Selanjutnya'), 1, FailureHandling.OPTIONAL) ==
				true) // step 1
				 {
					Mobile.swipe(0, 250, 0, 0) // scroll lambat2 220 minimal nya. // step 2
				 } else
					{
		
						Mobile.setText(findTestObject('Form data Pemohon/Jumlah Tanggungan'), Hohendy.getValue('Jumlah tanggunan', baris), 0)
		
						Mobile.hideKeyboard()
			
						Mobile.tap(findTestObject('Form data Pemohon/Pilih Status Rumah'), 0)
		
						Mobile.setText(findTestObject('Form data Pemohon/Search'), Hohendy.getValue('Status Rumah', baris), 0)
				
						Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
						Mobile.tap(findTestObject('Object Repository/Kepemilikan Rumah/TextView - Pilih test'), 0)
		
						Mobile.hideKeyboard()
		
						Mobile.tap(findTestObject('Form data Pemohon/Pilih tahun menempati'), 0)
		
						Mobile.setText(findTestObject('Form data Pemohon/Search'), Hohendy.getValue('Tahun Menempati', baris), 0)
			
						Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
						Mobile.tap(findTestObject('Object Repository/Kepemilikan Rumah/TextView - Pilih test'), 0)
			
						Mobile.hideKeyboard()
						
						//Mobile.swipe(0, 1500, 0, 0) // scroll lambat2 220 minimal nya. // step 2
						
						Mobile.tap(findTestObject('Object Repository/Form data Pemohon/Button - Selanjutnya'), 0)
					
					// step 3
					// step baru ketemuu pilih kelurahan, habis itu langsung di pilih komponen di dalam nya.
					// keluar dari perulangan nya.
					break
					}
			}	
				
		}
	  }
}



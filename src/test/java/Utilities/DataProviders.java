package Utilities;
import org.testng.annotations.DataProvider;
import java.io.IOException;


public class DataProviders {

	String path=".\\TestData\\SpotifyTestData.xlsx";
	public String [][] getData(String SheetName) throws IOException
	{	
		ExcelUtility xlutil=new ExcelUtility(path);		
		int totalrows=xlutil.getRowCount(SheetName);	
		int totalcols=xlutil.getCellCount(SheetName,1);
		String data[][]=new String[totalrows][totalcols];	
		for(int i=1;i<=totalrows;i++)
		{		
			for(int j=0;j<totalcols;j++)
			{
				data[i-1][j]= xlutil.getCellData(SheetName,i, j);
			}
		}
	return data;
				
	}

	@DataProvider(name="LoginData")
	public String [][] getLoginData() throws IOException
	{
		return getData("Login");

	}

	@DataProvider(name="AlbumsData")
	public String [][] getAlbumsData() throws IOException
	{
		return getData("Albums");

	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

// TODO: MAKE THIS MORE OBJECT ORIENTED CONSTRUCTOR ETC NEEDS TO BE FIXED
// TODO: CONSULT AXEL

public class GetCases {
	public static int x;
	public static String caseSwe;
	public static void readFromWeb(String webURL) throws IOException {
		URL url = new URL(webURL);
		
		char[] cases = new char[10];
		InputStream is = url.openStream();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("Coronavirus:")) {
					
					//System.out.println(line);			//DEBUGGING
					//System.out.println("STOPPED");	//DEBUGGING
					//System.out.println("CASES");		//DEBUGGING
					
					cases = getCases(line);
					break;		
				}
			}
			
			caseSwe = new String(cases);
			x = str2int(caseSwe);
			System.out.println(x);
			
			// EXCEPTIONS
			} catch (MalformedURLException e) 	{e.printStackTrace();	throw new MalformedURLException("URL is malformed!!");
			} catch (IOException e) 			{ e.printStackTrace();	throw new IOException();}


}
	

	private static int str2int(String str) {
		str = str.replaceAll(",", "").replaceAll(" ","");
		int	casesINT = Integer.parseInt(str.trim());
		return casesINT;
	}

	private static char[] getCases(String line) {
		char[] caseChar = new char[10];
		line.getChars(27, 33, caseChar, 0);
		return caseChar;
	}
}

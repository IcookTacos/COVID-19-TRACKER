import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// GETS CASES FROM WORLDMETERS.INFO
		GetCases.readFromWeb("https://www.worldometers.info/coronavirus/country/sweden/");
		
		// SHOW GUI
		Window w1 = new Window();
		w1.setVisible(true);
	}

}

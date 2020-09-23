package service;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.jupiter.api.Test;

public class ProblemSolver765Test {
	@Test
	public void execute() {
		String path= "test/resources/";
		String[] testCases = {"tc1_input.txt", "tc2_input.txt", "tc3_input.txt", "tc4_input.txt", "tc5_input.txt"};
		int[] outputs = {3, 4, 2500, 4000, 10};
		for(int i = 0; i< testCases.length; i++) {
			try (BufferedReader reader = new BufferedReader(new FileReader(path + testCases[i]))){
				String city = reader.readLine();
				String streetNumbr = reader.readLine();
				String[] streets = new String[Integer.valueOf(streetNumbr)];
				String street = "";
				int counter = 0;
				while ((street = reader.readLine()) != null) {
					streets[counter] = street;
					counter++;
				}
				reader.close();
				int result = ProblemSolver765.execute(streets);
				System.out.println("result: " + result + " -- real: " + outputs[i]);
			}
			catch(Exception e) {
				System.out.println("Something wrong");
			}
		}
	}
}

package jsonSimpleExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ToParser {
	public static void test() {
		JSONParser parser = new JSONParser();
		String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		try {
			Object obj = parser.parse(s);
			JSONArray array = (JSONArray) obj;
			System.out.println("The 2nd element of array");
			System.out.println(array.get(1));
			System.out.println();

			JSONObject obj2 = (JSONObject) array.get(1);
			System.out.println("Field \"1\"");
			System.out.println(obj2.get("1"));

			s = "{}";
			obj = parser.parse(s);
			System.out.println(obj);

			s = "[5,]";
			obj = parser.parse(s);
			System.out.println(obj);

			s = "[5,,2]";
			obj = parser.parse(s);
			System.out.println(obj);
		} catch (ParseException pe) {
			System.out.println("position: " + pe.getPosition());
			System.out.println(pe);
		}
	}

	public static void test2() {
		JSONParser parser = new JSONParser();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("CountryGSON.json")));
			String jsonText = br.readLine();

			Object obj = parser.parse(jsonText);

			JSONArray jsArray = (JSONArray) obj;

			System.out.println(jsArray.get(1));

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (ParseException pe) {
			System.out.println("position: " + pe.getPosition());
			System.out.println(pe);
		}

	}

	public static void test3() {
		JSONParser parser = new JSONParser();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("Claas.json")));
			br.readLine();
			br.readLine();
			String jsonText = br.readLine();

			Object obj = parser.parse(jsonText);

			JSONArray jsArray = (JSONArray) obj;

			System.out.println(jsArray.get(0));

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (ParseException pe) {
			System.out.println("position: " + pe.getPosition());

			System.out.println(pe);
		}

	}

	public static void test4() {
		try {
			FileReader fr = new FileReader(new File("Claas2.json"));
			BufferedReader br = new BufferedReader(fr);

			int cha = br.read();
			StringBuilder sb = new StringBuilder();
			while (cha != -1) {
				sb.append((char)cha);
				cha = br.read();
			}
			
			String csv = sb.toString();

			
			
			
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static void main(String[] args) {
		test4();

	}

}

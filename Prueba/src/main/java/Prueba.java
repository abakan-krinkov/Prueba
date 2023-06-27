import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


public class Prueba {

	public static void main(String[] args) {
			int contador = 0;
			String res = "";
			String ur = "https://hp-api.onrender.com/api/characters";
			try {
			      URL url = new URL(ur);
			      HttpURLConnection con = (HttpURLConnection) url.openConnection();
			      con.setRequestMethod("GET");			      
			      con.connect();		      
			      StringBuilder resultado = new StringBuilder();
			      Scanner scan = new Scanner(con.getInputStream());
			      
			      while(scan.hasNext()) {
			    	  resultado.append(scan.nextLine());
			      }
			      
			      scan.close();			      
			      //System.out.println(resultado);
			      
			      JSONArray array = new JSONArray(resultado.toString());
			      JSONObject object = array.getJSONObject(0);
			      System.out.println(object.getString("name"));
			      System.out.println("");


			} catch (Exception e) { 
			      res = e.toString();
			} 
			      System.out.println(res);
			}

	}

//		9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8
//		9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8
//		9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8



package ejercicios;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Pokemon {
	
	public static void main(String[] args) throws IOException {
		
		
		String res = "";
		String ur = "https://pokeapi.co/api/v2/pokemon/1";
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
		      System.out.println(resultado);
		      
		      /*JSONArray array = new JSONArray(resultado.toString());
		      JSONObject object = array.getJSONObject(1);
		      System.out.println(object.getString("name"));		*/      
		      



		} catch (Exception e) { 
		      res = e.toString();
		} 
		      System.out.println(res);

}
}

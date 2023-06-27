package ejercicios;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class MenuHarryPotter extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelSubtitulo, imagen;
    private JButton btnRegistro,btnSalir;
   	private String actor, name, dateOfBirth, house, image; 
   
    public MenuHarryPotter() throws IOException{

        componentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Ejercicio 1");
   
     }
   
    public void componentes() throws IOException{
		
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
		      //System.out.println(object.getString("name"));
		      
		      actor = object.getString("actor");
		      name = object.getString("name");
		      dateOfBirth = object.getString("dateOfBirth");
		      house = object.getString("house");
		      image = object.getString("image");


		} catch (Exception e) { 
		      res = e.toString();
		} 
		      System.out.println(res);
    	
		      
    		Image im = null;
            URL url = new URL(image);
    		im = ImageIO.read(url);        
    		imagen=new JLabel(new ImageIcon(im));
    		imagen.setBounds(40, 0, 180, 200);
            add(imagen);

            labelSubtitulo=new JLabel();
            labelSubtitulo.setBounds(40, 200, 300, 20);
            labelSubtitulo.setText("Actor: " + actor);
            add(labelSubtitulo);
            
            labelSubtitulo=new JLabel();
            labelSubtitulo.setBounds(40, 220, 300, 20);
            labelSubtitulo.setText("Nombre: " +name);
            add(labelSubtitulo);
            
            labelSubtitulo=new JLabel();
            labelSubtitulo.setBounds(40, 240, 300, 20);
            labelSubtitulo.setText("Fecha de Nacimiento: " +dateOfBirth);
            add(labelSubtitulo);
            
            labelSubtitulo=new JLabel();
            labelSubtitulo.setBounds(40, 260, 300, 20);
            labelSubtitulo.setText("Casa a la que pertenece: " +house);
            add(labelSubtitulo);
           
            /*btnRegistro=new JButton();
            btnRegistro.setBounds(120, 50, 150, 20);
            btnRegistro.setText("Registrar");
            add(btnRegistro);
            btnRegistro.addActionListener(this);*/
            



       
     }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


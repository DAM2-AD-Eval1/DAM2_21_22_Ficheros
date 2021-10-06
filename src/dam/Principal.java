package dam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		/*File fich_alumnos = new File("D:\\PRUEBAS\\alumnos.txt");

		FileReader fr = new FileReader(fich_alumnos);
		BufferedReader br = new BufferedReader(fr);*/
        
        BufferedReader br = new BufferedReader(new FileReader("D:\\PRUEBAS\\alumnos.txt"));
        
        BufferedWriter bwDAM1 = new BufferedWriter(new FileWriter("D:\\PRUEBAS\\dam1.txt"));
        BufferedWriter bwDAM2 = new BufferedWriter(new FileWriter("D:\\PRUEBAS\\dam2.txt"));
        
        String linea_alumno;
        String[] linea_separada;
        //linea_alumno = "Pepito 981111111 DAM1"
        while((linea_alumno = br.readLine()) != null) {
        	
        	//linea_separada[0]="Pepito"; linea_separada[1]="981111111"; linea_separada[2]="DAM1";  
        	linea_separada = linea_alumno.split(" ");
        	
        	if (linea_separada[2].equals("DAM1"))
        		bwDAM1.write(linea_separada[0] + " " + linea_separada[1] + "\r");
        	else
        		bwDAM2.write(linea_separada[0] + " " + linea_separada[1] + "\r");
        }
        
        bwDAM1.flush();
        bwDAM2.flush();
        bwDAM1.close();
        bwDAM2.close();
        //fr.close();
	
	}

}

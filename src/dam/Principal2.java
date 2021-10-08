package dam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Principal2 {

	public static void main(String[] args) throws IOException {
		
		//Adaptación a NIO.2
		
		//Generar los Paths
		Path fichAlumnos = Paths.get("D:\\PRUEBAS\\alumnos.txt");
		Path fichDAM1 = Paths.get("D:\\PRUEBAS\\dam1.txt");
		Path fichDAM2 = Paths.get("D:\\PRUEBAS\\dam2.txt");
		
		//Creamos los buffers
		BufferedReader br = Files.newBufferedReader(fichAlumnos);
		BufferedWriter bwDAM1 = Files.newBufferedWriter(fichDAM1);
		BufferedWriter bwDAM2 = Files.newBufferedWriter(fichDAM2);

        //Recorrer las líneas de los alumnos
		Stream<String> lineasAlumno = br.lines();
		lineasAlumno.forEach(l -> {
			String[] linea_separada;
			linea_separada = l.split(" ");
			
			if (linea_separada[2].equals("DAM1")) {
				try {
					bwDAM1.write(linea_separada[0] + " " + linea_separada[1] + "\r");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					bwDAM2.write(linea_separada[0] + " " + linea_separada[1] + "\r");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
         
        
        bwDAM1.flush();
        bwDAM2.flush();
        br.close();
        bwDAM1.close();
        bwDAM2.close();

	
	}

}

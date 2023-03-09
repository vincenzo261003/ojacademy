import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

public class Gestorefile {

	private String path = "C:\\Users\\SI Academy\\Desktop\\ojacademy\\Week2\\Giorno4\\";
	
	public boolean scriviFileNormale (String nomeFile, String contenuto) {
		try {
			File file = new File( path.concat(nomeFile) );
			FileWriter fw = new FileWriter(file);
			
			fw.write(contenuto);
			
			fw.flush();
			fw.close();
			
			return true;
			
		} catch (Exception e) {
			System.out.println("[ERR] Errore: " + e.getMessage());
		}
		return false;
	}
	
	public boolean scriviFileBuffer (String nomeFile, String contenuto) {
		try {
			File file = new File( path.concat(nomeFile) );
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(contenuto);
			
			bw.flush();
			bw.close();
			
			return true;
			
		} catch (Exception e) {
			System.out.println("[ERR] Errore: " + e.getMessage());
		}
		return false;
	}
	
	public String leggiFile (String nomeFile) {
		String res = "";
		
		try {
			File file = new File( path.concat(nomeFile) );
			FileReader fr = new FileReader(file);
			
			char[] in = new char[1000];
			
			int lunghezza = fr.read(in);
			
			for (int i = 0; i < lunghezza; i++)
				res += in[i];
			
			
		} catch (Exception e) {
			System.out.println("[ERR] Errore: " + e.getMessage());
		}
		return res;
	}
	
}

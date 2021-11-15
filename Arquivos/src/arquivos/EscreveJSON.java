package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJSON {

	public static void main(String[] args) throws Exception {
		
		Usuarios usuario1 = new Usuarios();
		usuario1.setCpf("033.281.567.44");
		usuario1.setLogin("Godofredo-chavoso");
		usuario1.setNome("Godofredo");
		usuario1.setSenha("ABC1234");
		
		Usuarios usuario2 = new Usuarios();
		usuario2.setCpf("654.253.458.21");
		usuario2.setLogin("pipoquinha-chavosinha");
		usuario2.setNome("Pipoquinha");
		usuario2.setSenha("ABCDF");
		
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = 
				new FileWriter("C:\\Users\\bruno\\git\\repository5\\Arquivos\\src\\arquivos\\filejson.json");
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		// ---------------------------- LENDO ARQUIVO JSON ----------------------------
		
		FileReader fileReader = new FileReader("C:\\Users\\bruno\\git\\repository5\\Arquivos\\src\\arquivos\\filejson.json");
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuarios> listUsuarios = new ArrayList<Usuarios>();
		
		for (JsonElement jsonElement : jsonArray) {
			
			Usuarios usuario = new Gson().fromJson(jsonElement, Usuarios.class);
			listUsuarios.add(usuario);
		}
		System.out.println("Leitura arquivo JSON: " + listUsuarios);
	}

}

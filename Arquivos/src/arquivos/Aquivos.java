package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Aquivos {

	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pipoquero1@gmail.com");
		pessoa1.setNome("Pipoqueiro");
		pessoa1.setIdade(19);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("prur1@gmail.com");
		pessoa2.setNome("Pru");
		pessoa2.setIdade(129);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("heman1@gmail.com");
		pessoa3.setNome("He-Man");
		pessoa3.setIdade(35);
		
		// Pode vir do Banco de Dados ou de qualquer fonte de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		File arquivo = new File("C:\\workspace-curso-java\\Arquivos\\src\\arquivos\\arquivo.txt");
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}

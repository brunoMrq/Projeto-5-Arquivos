package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		
		
		File file = new File("C:\\Users\\bruno\\git\\repository5\\Arquivos\\src\\arquivos\\arquivo_execel.xls");
	
		if (!file.exists()) {
			file.createNewFile();
		}
		
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
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setEmail("jurubeba11@gmail.com");
		pessoa4.setNome("Jurubebiano");
		pessoa4.setIdade(65);
		
		// Pode vir do Banco de Dados ou de qualquer fonte de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		HSSFWorkbook hssfworkbook = new HSSFWorkbook(); /*Usado para escrever na planilha*/
		HSSFSheet linhaPessoa = hssfworkbook.createSheet("Planilha de Pessoas");/*Criar a planilha*/
		
		int numLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhaPessoa.createRow(numLinha ++); /*Criando Linha na Planilha*/
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula ++); /*Criando Celula 1*/
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula ++); /*Criando Celula 2*/
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++); /*Criando Celula 3*/
			celIdade.setCellValue(p.getIdade());
		}
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfworkbook.write(saida); /*Escreve planilha em arquivo*/
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada");
		
		
	}
	
}

package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream entrada =
				new FileInputStream(new File("C:\\Users\\bruno\\git\\repository5\\Arquivos\\src\\arquivos\\arquivo_execel.xls"));
		HSSFWorkbook hssfworkbook = new HSSFWorkbook(entrada); /*Prepara a entrada do arquivo Excel para ler */
		HSSFSheet planilha = hssfworkbook.getSheetAt(0); /*Pega a primeira planilha*/
		
		Iterator<Row> linhaIterator  = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (linhaIterator.hasNext()) { /*Enquanto tiver linha no arquivo Excel*/
			
			Row linha = linhaIterator.next(); /*Dados da pessoa na linha*/
			
			Iterator<Cell> celula = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while (celula.hasNext()) {
			
				Cell cell = celula.next();
				
				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1: 
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				}
				
			}
			pessoas.add(pessoa);
			
		}
		entrada.close(); /*Terminou de ler o aquivo*/
		
		for (Pessoa p : pessoas) {
			System.out.println(p);
		}
		
	}
	
}

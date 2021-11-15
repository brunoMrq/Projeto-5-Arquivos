package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando2 {

	public static void main(String[] args) throws Exception {
		
		File file = new File("C:\\Users\\bruno\\git\\repository5\\Arquivos\\src\\arquivos\\arquivo_execel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfworkbook = new HSSFWorkbook(entrada);
		HSSFSheet planilha = hssfworkbook.getSheetAt(0);
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while (linhaIterator.hasNext()) { /*Enquanto tiver linha*/
			Row linha = linhaIterator.next(); /*Dados da pessoa na linha*/
			
			
			String valorCelular = linha.getCell(0).getStringCellValue();
			linha.getCell(0).setCellValue(valorCelular + "* valor gravado na aula");
			
		};
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfworkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha Atualizada");
	}

}

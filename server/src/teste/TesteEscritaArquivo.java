package teste;

import io.Arquivo;
import io.ArquivoImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class TesteEscritaArquivo {

	public static void main(String[] args) {
		String caminho = "/home/lucas/Documents/teste.txt";
		Arquivo arquivo = new ArquivoImpl(caminho);
		Collection<String> conteudo = Arrays.asList("Linha2.2", "Linha2.3", "Linha2.4");
		try {
			arquivo.escrever(conteudo, 2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

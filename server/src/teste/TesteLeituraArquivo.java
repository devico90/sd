package teste;

import io.Arquivo;
import io.ArquivoImpl;

import java.io.IOException;
import java.util.Collection;

public class TesteLeituraArquivo {
	public static void main(String[] args) {
		String caminho = "/home/lucas/Documents/teste.txt";
		Arquivo arquivo = new ArquivoImpl(caminho);
		try {
			Collection<String> conteudoArquivo = arquivo.ler(1, 50);
			System.out.println(conteudoArquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

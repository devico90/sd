package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public interface GerenciadorDeArquivos {
	
	Collection<String> ler(String caminho, int linhaInicial, int linhaFinal) throws FileNotFoundException, IOException;
	
	
	void escrever(String caminho, Collection<String> conteudo, int linha) throws FileNotFoundException, IOException;

}

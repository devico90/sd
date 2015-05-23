package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public interface Arquivo {
	
	String getCaminho();
	
	void setCaminho(String caminho);
	
	Collection<String> ler(int linhaInicial, int linhaFinal) throws FileNotFoundException, IOException;
	
	void escrever(Collection<String> conteudo, int linha) throws FileNotFoundException, IOException;

}

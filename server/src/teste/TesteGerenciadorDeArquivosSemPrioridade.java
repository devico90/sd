package teste;

import static org.junit.Assert.assertFalse;
import io.Arquivo;
import io.ArquivoImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import server.GerenciadorDeArquivos;
import server.GerenciadorDeArquivosImpl;

public class TesteGerenciadorDeArquivosSemPrioridade {

	/*
	private final static String caminho1 = "/home/lucas/Documents/teste.txt";
	private final static String caminho2 = "/home/lucas/Documents/teste2.txt";
	private final static String caminho3 = "/home/lucas/Documents/teste3.txt";
	
	public Collection<Arquivo> construirArquivosParaTeste(){
		Arquivo arquivo1 = new ArquivoImpl(caminho1);
		Arquivo arquivo2 = new ArquivoImpl(caminho2);
		Arquivo arquivo3 = new ArquivoImpl(caminho3);
		return Arrays.asList(arquivo1, arquivo2, arquivo3);
	}
	
	private Collection<Arquivo> arquivos = construirArquivosParaTeste();
	//private GerenciadorDeArquivos gerenciador = new GerenciadorDeArquivosImpl(arquivos); 

	@Test
	public void testeLeitura() throws FileNotFoundException, IOException{
			
		//Collection<String> conteudoLido = gerenciador.ler(caminho1, 1, 50);
		
		assertFalse("O arquivo nao deveria estar vazio", conteudoLido.isEmpty());
	}
	
	@Test
	public void testeEscrita() throws FileNotFoundException, IOException{
		
		Collection<String> novoConteudo = Arrays.asList("LinhaTeste", "LinhaTeste2");
		
		//gerenciador.escrever(caminho2, novoConteudo, 1);
	
	}
	*/
}

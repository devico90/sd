package server;

import io.Arquivo;
import io.ArquivoImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import concorrencia.ControladorLeitorEscritor;

public class GerenciadorDeArquivosImpl implements GerenciadorDeArquivos{
	
	private Collection<Arquivo> arquivos;
	private ControladorLeitorEscritor controlador;
	
	public GerenciadorDeArquivosImpl(ControladorLeitorEscritor controlador) {
		this.controlador = controlador;
		Arquivo a1 = new ArquivoImpl(NomeArquivos.ARQUIVO_1);
		Arquivo a2 = new ArquivoImpl(NomeArquivos.ARQUIVO_2);
		Arquivo a3 = new ArquivoImpl(NomeArquivos.ARQUIVO_3);
		arquivos = Arrays.asList(a1, a2, a3);
	}

	@Override
	public Collection<String> ler(String caminho, int linhaInicial, int linhaFinal) throws FileNotFoundException, IOException {
		Arquivo arquivo = buscarArquivo(caminho);
		controlador.lockRead(arquivo);
		Collection<String> conteudoLido = arquivo.ler(linhaInicial, linhaFinal);
		controlador.unlockRead(arquivo);
		return conteudoLido;
	}

	@Override
	public void escrever(String caminho, Collection<String> conteudo, int linha) throws FileNotFoundException, IOException {
		Arquivo arquivo = buscarArquivo(caminho);
		controlador.lockWrite(arquivo);
		arquivo.escrever(conteudo, linha);
		controlador.unlockWrite(arquivo);
		
	}

	private Arquivo buscarArquivo(String caminho) throws FileNotFoundException{
		for(Arquivo arquivo: arquivos){
			if(arquivo.getCaminho().equals(caminho)){
				return arquivo;
			}
		}
		throw new FileNotFoundException();
	}


	public Collection<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(Collection<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}
	
	
}

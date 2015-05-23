package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;

public class ServidorImpl extends UnicastRemoteObject implements Servidor{
	
	private static final long serialVersionUID = 1L;
	private GerenciadorDeArquivos gerenciadorArquivos;

	public ServidorImpl(GerenciadorDeArquivos gerenciadorArquivos) throws RemoteException {
		this.gerenciadorArquivos = gerenciadorArquivos;
	}

	@Override
	public Collection<String> ler(String caminho, int linhaInicial, int linhaFinal) throws FileNotFoundException, IOException,  RemoteException {
		return gerenciadorArquivos.ler(caminho, linhaInicial, linhaFinal);
	}

	@Override
	public void escrever(String caminho, Collection<String> conteudo, int linha) throws FileNotFoundException, IOException, RemoteException {
		gerenciadorArquivos.escrever(caminho, conteudo, linha);
	}

}

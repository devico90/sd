package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface Servidor extends Remote{

	Collection<String> ler(String caminho, int linhaInicial, int linhaFinal) throws FileNotFoundException, IOException, RemoteException;
	
	void escrever(String caminho, Collection<String> conteudo, int linha) throws FileNotFoundException, IOException, RemoteException;
}

package cliente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collection;

import server.NomeArquivos;
import server.Servidor;

public class MainCliente3 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try {
			Servidor servidor = (Servidor) Naming.lookup("rmi://localhost/servidor");
			System.out.println("Cliente3 Ok");
			Collection<String> conteudo = Arrays.asList("Add outra linha3", "add outra linha4");
			servidor.escrever(NomeArquivos.ARQUIVO_1, conteudo, 2);
			System.out.println("Acabou cliente3");
		} 
		catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}

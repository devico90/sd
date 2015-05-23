package cliente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.NomeArquivos;
import server.Servidor;

public class MainCliente {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try {
			Servidor servidor = (Servidor) Naming.lookup("rmi://localhost/servidor");
			System.out.println("Cliente Ok");
			System.out.println(servidor.ler(NomeArquivos.ARQUIVO_1, 1, 50));
			System.out.println("Acabou cliente");
		} 
		catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

}

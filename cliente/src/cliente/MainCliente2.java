package cliente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.NomeArquivos;
import server.Servidor;

public class MainCliente2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try {
			Servidor servidor = (Servidor) Naming.lookup("rmi://localhost/servidor");
			System.out.println("Cliente2 Ok");
			System.out.println(servidor.ler(NomeArquivos.ARQUIVO_2, 1, 50));
			System.out.println("Acabou cliente2");
		} 
		catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}

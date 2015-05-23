package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.GerenciadorDeArquivos;
import server.GerenciadorDeArquivosImpl;
import server.Servidor;
import server.ServidorImpl;
import concorrencia.ControladorLeitorEscritor;
import concorrencia.ControladorPrioridadeEscrita;

public class MainPrioridadeEscrita {
	public static void main(String[] args) {
		try {
			ControladorLeitorEscritor controlador = new ControladorPrioridadeEscrita();
			GerenciadorDeArquivos gerenciador = new GerenciadorDeArquivosImpl(controlador);
			Servidor servidor = new ServidorImpl(gerenciador);
			LocateRegistry.createRegistry(1099);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("servidor", servidor);
			System.out.println("Servidor com prioridade de escrita na porta 1099!");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

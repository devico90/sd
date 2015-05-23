package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;

public class ArquivoImpl implements Arquivo{
	
	private String caminho;

	public ArquivoImpl(String caminho) {
		this.caminho = caminho;
	}

	@Override
	public Collection<String> ler(int linhaInicial, int linhaFinal) throws FileNotFoundException, IOException {
		if(linhaInicial <= 0){
			throw new IllegalArgumentException("Linha inicial deve ser maior que 0");
		}
		InputStream is = new FileInputStream(getCaminho());
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		Collection<String> linhas = new ArrayList<String>();
		
		int contadorLinhas = 0;
		String conteudoLinha = br.readLine();
		while(conteudoLinha != null){
			contadorLinhas++;
			if(isValuebetween(contadorLinhas, linhaInicial, linhaFinal)){
				linhas.add(conteudoLinha);
			}
			conteudoLinha = br.readLine();
		}
		br.close();
		return linhas;
	}

	@Override
	public void escrever(Collection<String> conteudo, int linha) throws FileNotFoundException, IOException {
		if(linha <= 0){
			throw new IllegalArgumentException("Linha inicial deve ser maior que 0");
		}
		if(conteudo == null || conteudo.isEmpty()){
			throw new IllegalArgumentException("O conteudo a ser gravado nao pode ser nulo/vazio");
		}
		InputStream is = new FileInputStream(getCaminho());
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		Collection<String> linhas = new ArrayList<String>();
		
		int contadorLinha = 0;
		String conteudoLinha = br.readLine();
		while(conteudoLinha != null){
			contadorLinha++;
			if(contadorLinha == linha){
				linhas.addAll(conteudo);
			}
			
			linhas.add(conteudoLinha);

			conteudoLinha = br.readLine();
		}
		if(contadorLinha == 0){
			linhas.addAll(conteudo);
		}
		
		br.close();
		
		OutputStream os = new FileOutputStream(getCaminho());
		OutputStreamWriter ows = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(ows);
		
		for (String str: linhas) {
			bw.write(str);
			bw.newLine();
		}
		
		bw.close();
		
	}
	
	/*
	 * Verifica se o valor está entre o inicio e o fim
	 */
	private boolean isValuebetween(int valor, int inicio, int fim){
		return ((valor >= inicio) && (valor <= fim));
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	

	

}

package concorrencia;

import io.Arquivo;

public class ControladorSemPrioridade implements ControladorLeitorEscritor{
	
	private Object lock = new Object();
	private int cemSegundos = 1000 * 100;

	@Override
	public void lockRead(Arquivo arquivo) {
		try {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + "lock read");
				lock.wait(cemSegundos);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void unlockRead(Arquivo arquivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lockWrite(Arquivo arquivo) {
		try {
			synchronized (arquivo) {
				System.out.println(Thread.currentThread().getName() + "lock write");
				arquivo.wait(cemSegundos);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void unlockWrite(Arquivo arquivo) {
		// TODO Auto-generated method stub
		
	}

}

package concorrencia;

import io.Arquivo;

public interface ControladorLeitorEscritor {
	
	void lockRead(Arquivo arquivo);
	
	void unlockRead(Arquivo arquivo);
	
	void lockWrite(Arquivo arquivo);
	
	void unlockWrite(Arquivo arquivo);

}

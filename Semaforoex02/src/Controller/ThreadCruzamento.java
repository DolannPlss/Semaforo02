package Controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {
	private int idCarro;
	private Semaphore semaforo;
	private String sentido;

	public ThreadCruzamento(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	public void run() {
		direcao();
		try {
		semaforo.acquire();
		cruzando();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		cruzou();
		semaforo.release();
	}



	private void direcao() {
		if (idCarro==0) {
			sentido="norte";
		}else if (idCarro==1) {
			sentido="sul";
		}else if (idCarro==2) {
			sentido="leste";
		}else if (idCarro==3) {
			sentido="oeste";
		}

	}

	private void cruzando() {
		System.out.println("Carro "+idCarro+ " esta cruzando em direção ao "+sentido);
		try {
			sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception	
		}
		
	}
	private void cruzou() {
		System.out.println("carro"+idCarro+ "cruzou para o "+sentido);
	}
}

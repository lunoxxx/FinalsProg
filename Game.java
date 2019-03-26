import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

	// private static final long serialVersionUID
	public boolean running = false;
	private Thread thread;

	public synchronized void start(){
		if(running)
			return;

		running = true;
		Thread = new Thread(this);
		thread.start();
	}

	public void run(){
		System.out.println("");
	}

	public static void main(String args[]){
		new Window(800, 600, "Neon Platform Game Prototype", new Game());
	}
}
import java.awt.event.KeyAdapter;

public class KeyInput extends KeyAdapter{

	Handler handler;

	public KeyInput(Handler handler){
		this.handler = handler;
	}

	public void keyPressed(keyEvent e){

		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ObjectId.Player){
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
			}
		}

		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
	}

	public void keyReleased(keyEvent e)
}
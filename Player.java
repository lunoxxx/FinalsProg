import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Player extends GameObject{

	private float x;
	private float y;
	private float width = 40, height = 96;

	private float gravity = 0.05f;
	private final float MAX_SPEED = 10;

	private Handler handler;

	public Player(float x, float y, Handler handler, ObjectId id){
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object){
		x += VelX;
		y += VelY;

		if(falling || jumping){
			velY += gravity;

			if(velY > MAX_SPEED)
				velY = MAX_SPEED;
		}
	}


	private void Collision(LinkedList<GameObject> object){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId()== ObjectId.Block){
				if(getBounds().intersects(tempObject.getBounds())){
					
					y = tempObject.getY() - height;
					velY= 0;
					falling = false;
					jumping = false;
				}
			}
		}
	}

	public void render(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect((int)x, (int)y, (int)width, (int)height);

		Graphics2D g2d = new (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeftt());
		g2d.draw(getBoundsTop());
	}

	public Rectangle getBounds(){
		return new Rectangle((int)((int)x+(width/2)-((width/2)/2)), (int)((int)y+(height/2)), (int)width/2, (int)height/2);
	}

	public Rectangle getBoundsTop(){
		return new Rectangle((int)((int)x+(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}

	public Rectangle getBoundsRight(){
		return new Rectangle((int)(int)x+(width-5), (int)y+5, (int)5, (int)height-10);
	}

	public Rectangle getBoundsLeft(){
		return new Rectangle((int)x, (int)y+5, (int)width, (int)height-10);
	}

}
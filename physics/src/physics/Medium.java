package physics;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
public class Medium extends TimerTask {
	// All objects in this system
	private ArrayList<PhysObj> bodies = new ArrayList<PhysObj>() ;
	public void run() {
		// time complexity of (n^2+n)/2 ...or maybe just n^2. need to find a way to account for all force
		// force: every call, put in all 
		for (int i=0;i<bodies.size();i++) {
			// thousandth of a second has passed since previous call
			bodies.get(i).updatePosition(.001*bodies.get(i).getVelocityX(),.001*bodies.get(i).getVelocityY());
			for (int j=i+1;j<bodies.size(); j++) {
				// Gravity: force on each object = (m1*m2)/d^2, use pythag to calculate full distance then distribute based on taking (x/total)*force,(y/total)*force)
				double centerX1 = bodies.get(i).getX()+0.5*bodies.get(i).getWidth();
				double centerY1 = bodies.get(i).getY()+0.5*bodies.get(i).getHeight();
				double centerX2 = bodies.get(j).getX()+0.5*bodies.get(j).getWidth();
				double centerY2 = bodies.get(j).getY()+0.5*bodies.get(j).getHeight();
				double xDist = Math.abs(centerX2-centerX1);
				double yDist = Math.abs(centerY2-centerY1);
				double totalDist = Math.sqrt(xDist*xDist+yDist*yDist);
				double gForce = (bodies.get(i).getMass()*bodies.get(i).getMass())/totalDist*totalDist;
				double xForce = (xDist/totalDist)*gForce;
				double yForce = (yDist/totalDist)*gForce;
				if (bodies.get(i).isTouching(bodies.get(j))) {
					// collisions 
					bodies.get(i).setVel((bodies.get(i).getMass()-bodies.get(j).getMass())/(bodies.get(i).getMass()+bodies.get(j).getMass())*bodies.get(i).getVelocityX()+bodies.get(i).getVelocityX()*2*bodies.get(j).getMass()/(bodies.get(i).getMass()+bodies.get(j).getMass()),(bodies.get(i).getMass()-bodies.get(j).getMass())/(bodies.get(i).getMass()+bodies.get(j).getMass())*bodies.get(i).getVelocityY()+bodies.get(i).getVelocityY()*2*bodies.get(j).getMass()/(bodies.get(i).getMass()+bodies.get(j).getMass()));
					bodies.get(j).setVel((bodies.get(j).getMass()-bodies.get(i).getMass())/(bodies.get(j).getMass()+bodies.get(i).getMass())*bodies.get(j).getVelocityX()+bodies.get(j).getVelocityX()*2*bodies.get(i).getMass()/(bodies.get(j).getMass()+bodies.get(i).getMass()),(bodies.get(j).getMass()-bodies.get(i).getMass())/(bodies.get(j).getMass()+bodies.get(i).getMass())*bodies.get(j).getVelocityY()+bodies.get(j).getVelocityY()*2*bodies.get(i).getMass()/(bodies.get(j).getMass()+bodies.get(i).getMass()));
				}
				
			}
		}
	}
}

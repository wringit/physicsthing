package physics;

public class PhysObj {
	private double mass; // in e20 kg
	private double width;
	private double height;
	private double x;
	private double y;
	private double velocityX;
	private double velocityY;
	private double forceX;
	private double forceY;
	
	public PhysObj(double lMass, double lWidth, double lHeight, double lX, double lY) {
		mass = lMass;
		width = lWidth;
		height = lHeight;
		x = lX;
		y = lY;
	}
	
	// setters
	
	public void addForce(double lForceX, double lForceY) {
		forceX += lForceX;
		forceY += lForceY;
	}
	
	public void updateVel (double lX, double lY) {
		velocityX += lX;
		velocityY += lY;
	}
	
	public void updatePosition (double lX, double lY) {
		x += lX;
		y += lY;
	}
	
	public void setVel (double lX, double lY) {
		velocityX = lX;
		velocityY = lY;
	}
	
	// getters
	
	public double getMass() {
		return mass;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public double getX () {
		return x;
	}
	public double getY () {
		return y;
	}
	public double getVelocityX () {
		return velocityX;
	}
	public double getVelocityY() {
		return velocityY;	
	}
	public double getForceX () {
		return forceX;
	}
	public double getForceY () {
		return forceY;
	}
	
	// check for collision-- compare coordinates and sizes, find 
	// return true if collision, false if none
	//there will be a separate method for actually colliding
	public boolean isTouching(PhysObj touch) {
		// top left of rectangle is x and y; if abs(distance) is less than the sum of two sizes on both axes, return true
		// actually middle? because in middle, subtracting gives distance beteen the middle, will only be touching if distance is less than or equal to 0.5 times each size on both axes
		double centerX1 = x+0.5*width;
		double centerY1 = y+0.5*height;
		double centerX2 = touch.x+0.5*touch.width;
		double centerY2 = touch.y+0.5*touch.height;
		double maxX = (touch.width+width)*0.5;
		double maxY = (touch.height+height)*0.5;
		if (Math.abs(centerX1-centerX2) <= maxX && Math.abs(centerY1-centerY2) <= maxY) {
			return true;
		}
		return false;
	}
}

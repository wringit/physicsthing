package physics;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
public class App {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new Medium();
		timer.schedule(task,1000,1);
	}

}

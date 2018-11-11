package _00_IntroToArrays;
import java.util.Random;
import javax.swing.JOptionPane;
import org.jointheleague.graphical.robot.Robot;
public class _01_RobotRace {
	public static void main(String[] args) {
		Robot rbts[] = new Robot[5];
		for(int i = 0; i<rbts.length; i++) {
			Random r = new Random();
			rbts[i] = new Robot();
			rbts[i].setSpeed(Integer.MAX_VALUE);
			rbts[i].setX(0);
			rbts[i].setY(500);
			rbts[i].move(i*100);
			rbts[i].turn(90);
			rbts[i].setSpeed(100);
			rbts[i].penDown();
			rbts[i].setPenColor(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		}	
		boolean finished = false;
		while(!finished) {
			for(int i = 0; i<rbts.length; i++) {
				Random r = new Random();
				rbts[i].move(r.nextInt(50));
				if(rbts[i].getX() >= 800) {
					finished = true;
					rbts[i].sparkle();
					JOptionPane.showMessageDialog(null, "And we have a winner!");
				}
			}
		}	
}
}

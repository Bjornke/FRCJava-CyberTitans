package com.bjornke.tester;
/**
 *
 * @author Brandon Ragland
 */
import edu.wpi.first.wpilibj.SimpleRobot;

public class Tester extends SimpleRobot {
    Controller controller = new Controller(0);
    public void autonomous() {
        
    }

    public void operatorControl() {
        controller.tick();
    }
}

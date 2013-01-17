/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bjornke.tester;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Brandon Ragland
 */
public class Controller {

    private Joystick leftJoy = new Joystick(0);
    private Joystick rightJoy = new Joystick(1);
    private Joystick auxiliary = new Joystick(2);
    private Jaguar tankLeftWheel;
    private Jaguar tankRightWheel;
    private Jaguar mecLeftFront;
    private Jaguar mecRightFront;
    private Jaguar mecLeftBack;
    private Jaguar mecRightBack;
    private Jaguar testJag1;
    private Jaguar testJag2;
    private Victor testVex1;
    private Victor testVex2;
    private int driveType;

    /**
     * A modular drive-train system that uses a left and right joystick with a
     * single auxiliary joystick. For int type: 0 = Test Drive | 1 = Standard
     * Tank | 2 = Mecanum Type
     */
    public Controller(int type) {
        driveType = type;
        initType(type);
    }
    /**
     * Used to setup the jaguar motor controllers
     */
    private void initType(int type) {
        switch (type) {
            case 0:
                testJag1 = new Jaguar(1);
                testJag2 = new Jaguar(2);
                testVex1 = new Victor(3);
                testVex2 = new Victor(4);
                break;
            case 1:
                tankLeftWheel = new Jaguar(1);
                tankRightWheel = new Jaguar(2);
                break;
            case 2:
                mecLeftFront = new Jaguar(1);
                mecRightFront = new Jaguar(2);
                mecLeftBack = new Jaguar(3);
                mecRightBack = new Jaguar(4);
                break;
        }
    }

    /**
     * Should be called in a loop to update the robot drive-train.
     */
    public void tick() {
        switch (driveType) {
            case 0:
                testDrive();
                break;
            case 1:
                tankDriveStandard();
                break;
            case 2:
                mecanumDrive();
                break;
        }
    }

    private void testDrive() {
        if(Math.abs(leftJoy.getX()) > 0.1){
            testJag1.set(leftJoy.getX());
        }
        if(Math.abs(leftJoy.getY()) > 0.1){
            testJag2.set(leftJoy.getY());
        }
        if(Math.abs(rightJoy.getX()) > 0.1){
            testVex1.set(rightJoy.getX());
        }
        if(Math.abs(rightJoy.getY()) > 0.1){
            testVex2.set(rightJoy.getY());
        }
    }

    private void tankDriveStandard() {
        if(Math.abs(leftJoy.getY()) > 0.1){
            tankLeftWheel.set(leftJoy.getY());
        }
        if(Math.abs(rightJoy.getY()) > 0.1){
            tankRightWheel.set(rightJoy.getY());
        }
    }

    private void mecanumDrive() {
    }
}

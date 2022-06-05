package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;

public class Launcher {

    private static final double ARM_POWER = 1.0;
    private static final double SERVO_FIRE_POSITION = 0.5;
    private static final double SERVO_RESET_POSITION = 0.25;

    private DcMotor armMotor;
    private Servo triggerServo;
    private DigitalChannel lowerArmTouchSensor;
    private DigitalChannel upperArmTouchSensor;

    public Launcher (DcMotor armMotor, Servo triggerServo, DigitalChannel lowerArmTouchSensor, DigitalChannel upperArmTouchSensor){
        this.armMotor = armMotor;
        this.triggerServo = triggerServo;
        this.lowerArmTouchSensor = lowerArmTouchSensor;
        this.upperArmTouchSensor = upperArmTouchSensor;
    }

    public void resetPosition(){
        //resetTrigger();
        lowerArm();
        raiseArm();
    }

    public void launch(){
        fire();
    }

    private void lowerArm(){
        while(lowerArmTouchSensor.getState()){
            armMotor.setPower(ARM_POWER);
        }
        armMotor.setPower(0.0);
    }

    private void raiseArm(){
        while(upperArmTouchSensor.getState()){
            armMotor.setPower(-ARM_POWER);
        }
        armMotor.setPower(0.0);
    }

    private void fire(){
        triggerServo.setPosition(SERVO_FIRE_POSITION);
    }

    private void resetTrigger(){
        triggerServo.setPosition(SERVO_RESET_POSITION);
    }
}

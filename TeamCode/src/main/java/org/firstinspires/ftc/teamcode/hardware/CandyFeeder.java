package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.CRServo;

public class CandyFeeder {

    CRServo candyFeederServo = null;

    public CandyFeeder(CRServo candyFeederServo){
        this.candyFeederServo = candyFeederServo;
    }

    public void on(){
        candyFeederServo.setPower(-0.5);
    }

    public void off(){
        candyFeederServo.setPower(0);
    }
}

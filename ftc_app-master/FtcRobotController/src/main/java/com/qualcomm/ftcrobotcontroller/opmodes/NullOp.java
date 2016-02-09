package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class NullOp extends OpMode {

    Servo thisServo;
    double position;
    double newPos;

    @Override
    public void init() {
        thisServo = hardwareMap.servo.get("servo_1");


    }

    @Override
    public void loop() {

        position = thisServo.getPosition();

        if (gamepad1.x) {
            newPos = 1.0;
        }
        if (gamepad1.a) {
            newPos = .5;
        }
        if (gamepad1.b) {
            newPos = 0.0;
        }
        if (gamepad1.right_bumper) {
            newPos = position + .1;
        }
        if (gamepad1.left_bumper) {
            newPos = position - .1;
        }
        newPos = Range.clip(newPos, 0.0000, 1.0000);
        thisServo.setPosition(newPos);
        telemetry.addData("Position", position);
        telemetry.addData("Left Bumper", gamepad1.left_bumper);
        telemetry.addData("Right Bumper", gamepad1.right_bumper);


    }
}
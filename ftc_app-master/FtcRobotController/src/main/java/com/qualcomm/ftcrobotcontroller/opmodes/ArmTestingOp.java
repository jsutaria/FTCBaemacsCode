package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class ArmTestingOp extends OpMode {
/*
    Servo pulldownServo;
    double position;
    double newPos = .5;
*/
    DcMotor armAngling;
    double anglingPower = 0.0;

    DcMotor armPulling;
    double pullingPower = 0.0;

    @Override
    public void init() {

        //pulldownServo = hardwareMap.servo.get("pulldown");

        armAngling = hardwareMap.dcMotor.get("angling");

        armPulling = hardwareMap.dcMotor.get("pulling");

    }

    @Override
    public void loop() {
/*
        if (gamepad1.left_trigger > 0) {
            newPos = newPos - (gamepad1.left_trigger / 100);
        }
        if (gamepad1.right_trigger > 0) {
            newPos = newPos + (gamepad1.right_trigger / 100);
        }
        if (gamepad1.right_trigger + gamepad1.left_trigger == 0) {
            newPos = .5;
        }

        position = pulldownServo.getPosition();
        pulldownServo.setPosition(newPos);
        telemetry.addData("Position", position);
*/
        anglingPower = gamepad1.left_stick_y/5.0;
        armAngling.setPower(anglingPower);
        telemetry.addData("Angling Power", anglingPower);

        pullingPower = gamepad1.right_stick_y/1.0;
        armPulling.setPower(pullingPower);
        telemetry.addData("Pulling Power", pullingPower);

        telemetry.addData("GamePad1 Values:", "");
        telemetry.addData("Left Stick", gamepad1.left_stick_y);
        telemetry.addData("Right Stick", gamepad1.right_stick_y);
        telemetry.addData("Left Trigger", gamepad1.left_trigger);
        telemetry.addData("Right Bumper", gamepad1.right_trigger);


    }
}
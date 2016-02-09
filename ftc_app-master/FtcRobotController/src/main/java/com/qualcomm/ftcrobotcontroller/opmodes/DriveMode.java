package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
/**
 * Created by jainilsutaria on 1/25/16.
 */
public class DriveMode extends OpMode
{

    Servo servo_1;
    Servo servo_2;
    Servo servo_3;

    DcMotor motor_1;

    public void init()
    {

        //Map all hardware to respective ports
        //motor_1 = hardwareMap.dcMotor.get("motor_1");
        servo_1 = hardwareMap.servo.get("servo_1");
        servo_2 = hardwareMap.servo.get("servo_2");
        servo_3 = hardwareMap.servo.get("servo_3");
        motor_1 = hardwareMap.dcMotor.get("motor_1");
        servo_1.setPosition(.6);
        servo_2.setPosition(1);
    }
    public void loop() {

        telemetry.addData("Servo 1", servo_1.getPosition());
        telemetry.addData("Servo 2", servo_2.getPosition());
        telemetry.addData("Servo 3", servo_3.getPosition());
        //motor_1.setPower(gamepad1.left_stick_x/4);
        servo_1.setPosition(Range.clip(servo_1.getPosition() + gamepad1.right_stick_y /100, .5, 1));
        servo_2.setPosition(Range.clip(servo_2.getPosition()+ gamepad1.left_stick_y/200, 0, 1));
        servo_3.setPosition(Range.clip(1 - gamepad1.right_trigger, 0, 1));
        if (gamepad1.right_bumper) {
            motor_1.setPower(.2);
        } else if (gamepad1.left_bumper) {
            motor_1.setPower(-.2);
        } else {
            motor_1.setPower(0);
        }
    }

}

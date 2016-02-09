package com.qualcomm.ftcrobotcontroller.opmodes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;

import com.qualcomm.ftcrobotcontroller.FtcRobotControllerActivity;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Benjamin on 1/1/2016.
 */
public class DistanceTest extends OpMode {

    int initEncoder_r;
    int initEncoder_l;

    int revVal;

    boolean right = false;
    boolean left = false;

    DcMotor motor_r;
    DcMotor motor_l;

    @Override
    public void init() {
        motor_r = hardwareMap.dcMotor.get("motor_1");
        motor_l = hardwareMap.dcMotor.get("motor_2");

        initEncoder_r = motor_r.getCurrentPosition();
        initEncoder_l = motor_l.getCurrentPosition();
    }

    @Override
    public void loop() {
        /*float throttle = -gamepad1.left_stick_y;

        throttle = Range.clip(throttle, -1, 1f);

        motor_r.setPower(-throttle);
        motor_l.setPower(throttle);

        int currentEncoder_r = motor_r.getCurrentPosition();
        int currentEncoder_l = motor_l.getCurrentPosition();

        float avgEncoder = (currentEncoder_l + currentEncoder_r)/2;

        telemetry.addData("Speed", throttle);
        telemetry.addData("Distance - Continuous", EncoderDistanceContinuous(avgEncoder));
        telemetry.addData("Distance - Loop", EncoderDistanceLoop(avgEncoder));
        telemetry.addData("Right Encoder", currentEncoder_r);
        telemetry.addData("Left Encoder", currentEncoder_l);*/

        if (gamepad1.a)
        {
            right = true;
            left = true;
            motor_l.setPower(.1);
            motor_r.setPower(-.1);
            revVal = 1120;
        }

        if (right || left)
        {
            int currentEncoder_r = motor_r.getCurrentPosition();
            int currentEncoder_l = motor_l.getCurrentPosition();

            //Control right motor
            if (Math.abs(currentEncoder_r-initEncoder_r) >= revVal && right)
            {
                right = false;
                motor_r.setPower(0);
                initEncoder_r = currentEncoder_r;
            }

            //Control left motor
            if (Math.abs(currentEncoder_l-initEncoder_l) >= revVal && left)
            {
                left = false;
                motor_l.setPower(0);
                initEncoder_l = currentEncoder_l;
            }

            telemetry.addData("Right Encoder Difference", Math.abs(currentEncoder_r-initEncoder_r));
            telemetry.addData("Left Encoder Difference", Math.abs(currentEncoder_l-initEncoder_l));
        }

        telemetry.addData("Right Encoder", motor_r.getCurrentPosition());
        telemetry.addData("Left Encoder", motor_l.getCurrentPosition());
    }

    float EncoderDistanceLoop(float currentEncoder)
    {
        while (currentEncoder >= 0){currentEncoder -= 360;}
        if (currentEncoder < 0){currentEncoder = currentEncoder*-1;}
        return EncoderDistanceContinuous(currentEncoder);
    }

    float EncoderDistanceContinuous(float currentEncoder)
    {return (currentEncoder/360)*9.61f;}
}


package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by jainilsutaria on 1/13/16.
 */
public class stopResetMotor extends OpMode  {

    DcMotor thisMotor;
    int currentEncValue;


    public void init() {
        thisMotor = hardwareMap.dcMotor.get("motor");


    }

    public void loop() {
        telemetry.addData("Location", thisMotor.getCurrentPosition());
        thisMotor.setPower(gamepad1.left_stick_y/3);
    }
}

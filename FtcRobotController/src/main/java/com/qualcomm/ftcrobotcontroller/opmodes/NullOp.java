package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class NullOp extends OpMode {

  DcMotor motorone;
  DcMotor motortwo;

  @Override
  public void init() {
    motorone = hardwareMap.dcMotor.get("motor_1");
    motortwo = hardwareMap.dcMotor.get("motor_2");
  }

  @Override
  public void loop() {

    motorone.setPower(gamepad1.left_stick_y);
    motortwo.setPower(gamepad1.left_stick_y);
    telemetry.addData("Left Bumper", gamepad1.left_bumper);
    telemetry.addData("Right Bumper", gamepad1.right_bumper);


  }
}
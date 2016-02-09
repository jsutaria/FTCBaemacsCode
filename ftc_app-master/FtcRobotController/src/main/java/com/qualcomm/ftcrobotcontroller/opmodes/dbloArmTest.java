package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftcrobotcontroller.opmodes.GamePadLocation;

public class dbloArmTest extends OpMode
{
    private DcMotor motor_arm;
    private int startEncVal;
    private int currentEncVal;
    private int desiredEncVal;
    private double i;

    private boolean arm = false;

    private boolean goingUp;

    private double power = .4;

    private float gamepadLocation;

    private GamePadLocation gamepadLocation2;
    private GamePadLocation lastClicked;


    @Override
    public void init()
    {

        motor_arm = hardwareMap.dcMotor.get("motor_arm");
        startEncVal = motor_arm.getCurrentPosition();
    }

    @Override
    public void loop() {
        gamepadLocation = gamepad1.left_stick_y;
        telemetry.addData("Gamepad1 Left Joystick Y", gamepadLocation);
        telemetry.addData("Current Arm Position", currentEncVal);
        telemetry.addData("Desired Arm Position", desiredEncVal);
        telemetry.addData("Going Up", goingUp);
        telemetry.addData("Arm", arm);
        telemetry.addData("i", i);

        currentEncVal = motor_arm.getCurrentPosition() - startEncVal;
        gamepadLocation2 = GamePadLocation.getLocation(Math.round(gamepadLocation*10));


        if (!gamepadLocation2.equals(lastClicked)) {
            arm = true;
            desiredEncVal = gamepadLocation2.getFactor();
            if (currentEncVal < desiredEncVal) {
                goingUp = true;
                i = power;
                motor_arm.setPower(i);
            }
            if (currentEncVal > desiredEncVal) {
                goingUp = false;
                i = -power;
                motor_arm.setPower(i);
            }
        }

        if (arm) {
            if (goingUp) {
                if (currentEncVal >= desiredEncVal) {
                    arm = false;
                    motor_arm.setPower(0);
                }
            }
            if (!goingUp) {
                if (currentEncVal <= desiredEncVal) {
                    arm = false;
                    motor_arm.setPower(0);
                }
            }
            lastClicked = gamepadLocation2;
        }
    }
}
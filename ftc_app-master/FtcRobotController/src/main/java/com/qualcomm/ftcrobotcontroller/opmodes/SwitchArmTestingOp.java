package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class SwitchArmTestingOp extends OpMode
{
    private DcMotor motor_arm;
    private int startEncVal;
    private int currentEncVal;
    private int desiredEncVal;
    private double i;

    private boolean arm = false;

    private boolean goingUp;

    private double power = .4;

    private int lastClicked;

    private float gamepadLocation;

    private int gamepadLocationInt;
    private int checkpoints = 5;
    private int ten = 560;
    private int nine = 504;
    private int eight = 448;
    private int seven = 392;
    private int six = 336;
    private int five = 280;
    private int four = 224;
    private int three = 168;
    private int two = 112;
    private int one = 56;
    private int zero = 0;


    @Override
    public void init()
    {

        motor_arm = hardwareMap.dcMotor.get("motor_arm");
        startEncVal = motor_arm.getCurrentPosition();
    }

    @Override
    public void loop() {
        gamepadLocation = gamepad1.left_stick_y;
        telemetry.addData("Gamepad1 Left Joystick Y", gamepadLocationInt);
        telemetry.addData("Current Arm Position", currentEncVal);
        telemetry.addData("Desired Arm Position", desiredEncVal);
        telemetry.addData("Going Up", goingUp);
        telemetry.addData("Arm", arm);
        telemetry.addData("i", i);

        currentEncVal = motor_arm.getCurrentPosition() - startEncVal;
        gamepadLocationInt = Math.round(gamepadLocation*checkpoints);



        switch (gamepadLocationInt) {
            case -10:
                if (lastClicked != -ten) {
                    arm = true;
                    desiredEncVal = -ten;
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
                break;
            case -9:
                if (lastClicked != -nine) {
                    arm = true;
                    desiredEncVal = -nine;
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
                break;
            case -8:
                if (lastClicked != -eight) {
                    arm = true;
                    desiredEncVal = -eight;
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
                break;
            case -7:
                if (lastClicked != -seven) {
                    arm = true;
                    desiredEncVal = -seven;
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
            case -6:
                if (lastClicked != -six) {
                    arm = true;
                    desiredEncVal = -six;
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
                break;
            case -5:
                if (lastClicked != -five) {
                    arm = true;
                    desiredEncVal = -five;
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
                break;
            case -4:
                if (lastClicked != -four) {
                    arm = true;
                    desiredEncVal = -four;
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
                break;
            case -3:
                if (lastClicked != -three) {
                    arm = true;
                    desiredEncVal = -three;
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
                break;
            case -2:
                if (lastClicked != -two) {
                    arm = true;
                    desiredEncVal = -two;
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
                break;
            case -1:
                if (lastClicked != -one) {
                    arm = true;
                    desiredEncVal = -one;
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
                break;
            case 0:
                if (lastClicked !=zero) {
                    arm = true;
                    desiredEncVal = zero;
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
                break;
            case 1:
                if (lastClicked != one) {
                    arm = true;
                    desiredEncVal = one;
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
                break;
            case 2:
                if (lastClicked != two) {
                    arm = true;
                    desiredEncVal = two;
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
                break;
            case 3:
                if (lastClicked != three) {
                    arm = true;
                    desiredEncVal = three;
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
                break;
            case 4:
                if (lastClicked != four) {
                    arm = true;
                    desiredEncVal = four;
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
                break;
            case 5:
                if (lastClicked != five) {
                    arm = true;
                    desiredEncVal = five;
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
                break;
            case 6:
                if (lastClicked != six) {
                    arm = true;
                    desiredEncVal = six;
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
                break;
            case 7:
                if (lastClicked != seven) {
                    arm = true;
                    desiredEncVal = seven;
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
                break;
            case 8:
                if (lastClicked != eight) {
                    arm = true;
                    desiredEncVal = eight;
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
                break;
            case 9:
                if (lastClicked != nine) {
                    arm = true;
                    desiredEncVal = nine;
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
                break;
            case 10:
                if (lastClicked != ten) {
                    arm = true;
                    desiredEncVal = ten;
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
                break;
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
            lastClicked = desiredEncVal;
        }
    }
}


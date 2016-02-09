package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class NewArmTestingOp extends OpMode
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

    private boolean ten, nine, eight, seven, six, five, four, three, two, one, zero, negone, negtwo, negthree, negfour, negfive, negsix, negseven, negeight, negnine, negten;

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
        gamepadLocationInt = Math.round(gamepadLocation*10);

        ten = false;
        nine = false;
        eight = false;
        seven = false;
        six = false;
        five = false;
        four = false;
        three = false;
        two = false;
        one = false;
        zero = false;
        negone = false;
        negtwo = false;
        negthree = false;
        negfour = false;
        negfive = false;
        negsix = false;
        negseven = false;
        negeight = false;
        negnine = false;
        negten = false;


        switch (gamepadLocationInt) {
            case -10:
                negten = true;
                break;
            case -9:
                negnine = true;
                break;
            case -8:
                negeight = true;
                break;
            case -7:
                negseven = true;
                break;
            case -6:
                negsix = true;
                break;
            case -5:
                negfive = true;
                break;
            case -4:
                negfour = true;
                break;
            case -3:
                negthree = true;
                break;
            case -2:
                negtwo = true;
                break;
            case -1:
                negone = true;
                break;
            case 0:
                zero = true;
                break;
            case 1:
                one = true;
                break;
            case 2:
                two = true;
                break;
            case 3:
                three = true;
                break;
            case 4:
                four = true;
                break;
            case 5:
                five = true;
                break;
            case 10:
                ten = true;
                break;
            case 9:
                nine = true;
                break;
            case 8:
                eight = true;
                break;
            case 7:
                seven = true;
                break;
            case 6:
                six = true;
                break;
        }

        if (zero && lastClicked !=0) {
            arm = true;
            desiredEncVal = 0;
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

        if (one && lastClicked != 56) {
            arm = true;
            desiredEncVal = 56;
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

        if (two && lastClicked != 112) {
            arm = true;
            desiredEncVal = 112;
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
        if (three && lastClicked != 168) {
            arm = true;
            desiredEncVal = 168;
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
        if (four && lastClicked != 224) {
            arm = true;
            desiredEncVal = 224;
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
        if (five && lastClicked != 280) {
            arm = true;
            desiredEncVal = 280;
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

        if (negone && lastClicked != -56) {
            arm = true;
            desiredEncVal = -56;
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

        if (negtwo && lastClicked != -112) {
            arm = true;
            desiredEncVal = -112;
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
        if (negthree && lastClicked != -168) {
            arm = true;
            desiredEncVal = -168;
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
        if (negfour && lastClicked != -224) {
            arm = true;
            desiredEncVal = -224;
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
        if (negfive && lastClicked != -280) {
            arm = true;
            desiredEncVal = -280;
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

        if (six && lastClicked != 336) {
            arm = true;
            desiredEncVal = 336;
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

        if (seven && lastClicked != 392) {
            arm = true;
            desiredEncVal = 392;
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
        if (eight && lastClicked != 448) {
            arm = true;
            desiredEncVal = 448;
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
        if (nine && lastClicked != 504) {
            arm = true;
            desiredEncVal = 504;
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
        if (ten && lastClicked != 560) {
            arm = true;
            desiredEncVal = 560;
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

        if (negsix && lastClicked != -336) {
            arm = true;
            desiredEncVal = -336;
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

        if (negseven && lastClicked != -392) {
            arm = true;
            desiredEncVal = -392;
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
        if (negeight && lastClicked != -448) {
            arm = true;
            desiredEncVal = -448;
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
        if (negnine && lastClicked != -504) {
            arm = true;
            desiredEncVal = -504;
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
        if (negten && lastClicked != -560) {
            arm = true;
            desiredEncVal = -560;
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
            lastClicked = desiredEncVal;
        }
    }
}


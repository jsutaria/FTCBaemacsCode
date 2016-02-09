package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class AIOpBlue extends OpMode
{

    private int inch = 140;
    private int degree = 32;

    private boolean right;
    private boolean left;

    //private float turnPower = .6f;

    private long startTimer;

    private DcMotor motor_r;
    private DcMotor motor_l;
    private DcMotor motor_hook_l;
    private DcMotor motor_hook_r;

    private Servo sweep;

    private int aiState;

    private int rotationDeadZone;

    private int motorPosInit_l;
    private int motorPosInit_r;

    private float i = .5f;
    private int target;
    private boolean arm = false;

    @Override
    public void init()
    {
        aiState = -1;

        motor_r = hardwareMap.dcMotor.get("motor_1");
        motor_l = hardwareMap.dcMotor.get("motor_2");
        //motor_hook_l = hardwareMap.dcMotor.get("hook_1");
        //motor_hook_r = hardwareMap.dcMotor.get("hook_2");

        //sweep = hardwareMap.servo.get("sweep");

        motorPosInit_l = motor_l.getCurrentPosition();
        motorPosInit_r = motor_r.getCurrentPosition();
    }

    @Override
    public void loop()
    {
        switch (aiState)
        {

            case -1:
                LinearTravel(2, 1);
                break;
            case 0:
                //Single motor 45* rotation
                SingleMotorRotation(45, .6f);
                break;

            case 1:
                //Moves to climber drop point (6*sqrt(2) feet)
                LinearTravel(6 * Math.sqrt(2) * 9.4, 1);
                break;

            case 2:
                //extend the arm
                ArmExtend();
                break;
            case 3:
                //Deposits climbers
                DepositClimbers();
                break;

            case 4:
                //Moves backwards to poise for the mountain
                LinearTravel(10 * Math.sqrt(2) * 1.3, -.6f);
                break;

            case 5:
                //Single motor 90* rotation
                DualMotorRotation(.6f, 45);
                break;

            case 6:
                //Move to mountain
                //This should put us in the mountain low zone, if not adjust the distance traveled
                LinearTravel(150, 1);
                break;

            case 7:
                //Extend hooks
                //Change the second value to adjust how many milliseconds the motors are moving for
                //ExtendHooks(.5f, 5000);
                aiState++;
                break;

            case 8:
                //Start retracting the hooks
                //The value sets the speed that the hooks retract at
                //IMPORTANT: This does not stop the hooks.  They will be stopped at a later time.
                //BeginRetractingHooks(.3f);
                break;

            case 9:
                //Continue moving up the mountain
                //This distance is probably wrong, change it
                //Change the power of the motors to match the speed of the hooks, or the other way around
                //LinearTravel(30,1);
                break;
/*
            case 11:
                //Stop the hooks
                StopRetractingHooks();
                break;
*/
            case 12:
                break;


            default:
                telemetry.addData("Error", "AI State not found - " + aiState);
                break;
        }

        telemetry.addData("AI State", aiState);
    }

    private void SingleMotorRotation(float degrees, float turnPower)
    {
        motor_l.setPower(turnPower);
        //rotate 45 degrees to the right
        //by pushing the left tread 8.64"
        //which is equivalent to a rotation of 324°
        int motorPos_l = motor_l.getCurrentPosition();
        int motorChange_l = motorPos_l - motorPosInit_l;
        if (Math.abs(motorChange_l) >= degree*degrees)
        {

            motor_l.setPower(0);
            motorPosInit_l = motorPos_l;
            right = true;
            left = true;
            aiState++;
        }
    }

    private void LinearTravel(double distance, float motorPower)
    {
        //move forward 2.24' = 50.91"
        //which is equivalent to a rotation of 2543°

        int currentEncoder_r = motor_r.getCurrentPosition();
        int currentEncoder_l = motor_l.getCurrentPosition();

        if (left)  { motor_l.setPower(motorPower); }
        if (right) { motor_r.setPower(-motorPower); }

        //Control right motor
        if (Math.abs(currentEncoder_r-motorPosInit_r) >= inch*distance && right)
        {
            right = false;
            motor_r.setPower(0);
            motorPosInit_r = currentEncoder_r;
        }

        //Control left motor
        if (Math.abs(currentEncoder_l-motorPosInit_l) >= inch*distance && left)
        {

            left = false;
            motor_l.setPower(0);
            motorPosInit_l = currentEncoder_l;
        }

        if (!right && !left)
        {
            right = true;
            left = true;
            aiState++;
            startTimer = System.currentTimeMillis();
        }

        telemetry.addData("Left Encoder Change", Math.abs(currentEncoder_l-motorPosInit_l) - inch*distance);
        telemetry.addData("Left?", left);
        telemetry.addData("Right Encoder Change", Math.abs(currentEncoder_r-motorPosInit_r));
    }

    private void DualMotorRotation(float pow, float angle)
    {
        //if pow is positive, clockwise rotation
        //if pow is negative, counterclockwise rotation
        if (left)  { motor_l.setPower(pow); }
        if (right) { motor_r.setPower(pow); }
        int motorPos_l = motor_l.getCurrentPosition();
        int motorChange_l = motorPos_l - motorPosInit_l;

        int motorPos_r = motor_r.getCurrentPosition();
        int motorChange_r = motorPos_r - motorPosInit_r;
        if (Math.abs(motorChange_l) >= degree*angle && left)
        {
            motor_l.setPower(0);
            motorPosInit_l = motorPos_l;
            left = false;
            aiState++;
        }
        if (Math.abs(motorChange_r) >= degree*angle && right)
        {
            motor_r.setPower(0);
            motorPosInit_r = motorPos_r;
            right = false;
            aiState++;
        }

        if (!left && !right)
        {
            left = true;
            right = true;
            aiState++;
            //Starts timer for next AIState
            startTimer = System.currentTimeMillis();
        }
    }

    private void DepositClimbers() {
        /*
        //Drop climbers
        //value needs to be tinkered with
        sweep.setPosition(.6f);
        //Checks if 1000 milliseconds have passed
        if (System.currentTimeMillis() - startTimer >= 1000)
        {
            sweep.setPosition(.5f);
            aiState++;
        }
        */
        aiState++;
        //take out line above after writing aiState 3
    }

    private void ArmExtend() {

        aiState++;
    }


    private void ExtendHooks(float power, float maxTime)

    {
        //These might be switched, if the hooks go in the wrong direction then flip them
        motor_hook_r.setPower(power);
        motor_hook_l.setPower(-power);
        if (System.currentTimeMillis() - startTimer >= maxTime)
        {
            motor_hook_l.setPower(0);
            motor_hook_r.setPower(0);
            aiState++;
        }
    }

    private void BeginRetractingHooks(float power)
    {
        //These might be switched, if the hooks go in the wrong direction then flip them
        motor_hook_r.setPower(power);
        motor_hook_l.setPower(-power);
        aiState++;
    }

    private void StopRetractingHooks()
    {
        motor_hook_r.setPower(0);
        motor_hook_l.setPower(0);
        aiState++;
    }

}
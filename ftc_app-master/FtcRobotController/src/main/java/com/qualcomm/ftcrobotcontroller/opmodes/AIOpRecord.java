package com.qualcomm.ftcrobotcontroller.opmodes;

import android.content.SharedPreferences;

import com.qualcomm.ftcrobotcontroller.FtcRobotControllerActivity;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import java.util.List;

/**
 * Created by Benjamin on 1/20/2016.
 */
public class AIOpRecord extends OpMode
{
    SharedPreferences sharedPreferences;

    List<Double> list_motor_1;
    //List<Double> list_motor_2;
    //List<Double> list_motor_arm_extend;
    //List<Double> list_motor_arm_angle;
    List<Double> list_servo_1;
    //List<Double> list_servo_2;

    DcMotor motor_1;
    //DcMotor motor_2;
    //DcMotor motor_arm_extend;
    //DcMotor motor_arm_angle;

    Servo servo_1;
    //Servo servo_2;

    //double arm_extend_speed = 1;
    double servo_change_speed = .01;

    @Override
    public void init()
    {
        FtcRobotControllerActivity ftcRobotControllerActivity = new FtcRobotControllerActivity();
        sharedPreferences = ftcRobotControllerActivity.GetSharedPreferences();
        sharedPreferences.edit().clear();
        sharedPreferences.edit().apply();

        motor_1 = hardwareMap.dcMotor.get("motor_1");
        //motor_2 = hardwareMap.dcMotor.get("motor_2");
        //motor_arm_extend = hardwareMap.dcMotor.get("motor_arm_extend");
        //motor_arm_angle = hardwareMap.dcMotor.get("motor_arm_angle");
        servo_1 = hardwareMap.servo.get("servo_1");
        //servo_2 = hardwareMap.servo.get("servo_2");
    }

    @Override
    public void loop()
    {
        //Execute every .1 seconds
        if (getRuntime() >= .1)
        {
            //Add current values of the motor to their respective list
            list_motor_1.add(motor_1.getPower());
            //list_motor_2.add(motor_2.getPower());
            //list_motor_arm_extend.add(motor_arm_extend.getPower());
            //list_motor_arm_angle.add(motor_arm_angle.getPower());
            list_servo_1.add(servo_1.getPosition());
            //list_servo_2.add(servo_2.getPosition());

            //Reset the timer
            resetStartTime();
        }

        Movement();

        if (gamepad1.x || gamepad2.x)
        {
            //RetractArm();
            servo_1.setPosition(Range.clip(servo_1.getPosition()+servo_change_speed,0,1));
        }
        else if (gamepad1.b || gamepad2.b)
        {
            //ExtendArm();
            servo_1.setPosition(Range.clip(servo_1.getPosition()-servo_change_speed,0,1));
        }
        /*else
        {
            motor_arm_extend.setPower(0);
            //    motor_arm_extend_2.setPower(0);
        }*/

        if (gamepad1.y || gamepad2.y)
        {
            //motor_arm_angle.setPower(-.25);
            //servo_2.setPosition(Range.clip(servo_2.getPosition()+servo_change_speed,0,1));
        }
        else if (gamepad1.a || gamepad2.a)
        {
            //motor_arm_angle.setPower(.25 );
            //servo_2.setPosition(Range.clip(servo_2.getPosition()-servo_change_speed,0,1));
        }
        /*else
        {
            motor_arm_angle.setPower(0);
        }*/

        //telemetry.addData("Arm Angle Encoder", motor_arm_angle.getCurrentPosition());
        //telemetry.addData("Gamepad Right Stick Y", gamepad1.right_stick_y);
    }

    private void Movement()
    {
        // throttle: left_stick_y ranges from -1 to 1, where -1 is full up, and
        // 1 is full down
        // direction: left_stick_x ranges from -1 to 1, where -1 is full left
        // and 1 is full right
        float throttle = gamepad1.left_stick_x;
        float direction = -gamepad1.left_stick_y;
        float right = throttle - direction;
        float left = throttle + direction;

        // clip the right/left values so that the values never exceed +/- 1
        right = Range.clip(gamepad1.left_stick_x, -1, 1);
        left = Range.clip(gamepad1.right_stick_y, -1, 1);

        //motor_2.setPower(left);
        motor_1.setPower(right);
    }

    /*private void ExtendArm()
    {
        //Extends the arm
        motor_arm_extend.setPower(-arm_extend_speed);
        //motor_arm_extend_2.setPower(arm_extend_speed);
    }

    private void RetractArm()
    {
        //Retracts the arm
        motor_arm_extend.setPower(arm_extend_speed);
        //motor_arm_extend_2.setPower(-arm_extend_speed);
    }*/

    @Override
    public void stop() {
        int current_r=0;
        int current_l=0;
        int current_arm_extend=0;
        int current_arm_angle=0;
        int current_servo_1 = 0;
        int current_servo_2 = 0;

        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (Double x : list_motor_1)
        {
            edit.putLong("motor_r_" + Integer.toString(current_r), Double.doubleToRawLongBits(x));
            current_r++;
        }

        /*for (Double x : list_motor_2)
        {
            edit.putLong("motor_l_" + Integer.toString(current_l), Double.doubleToRawLongBits(x));
            current_r++;
        }*/

        /*for (Double x : list_motor_arm_extend)
        {
            edit.putLong("motor_arm_extend_" + Integer.toString(current_arm_extend), Double.doubleToRawLongBits(x));
            current_r++;
        }

        for (Double x : list_motor_arm_angle)
        {
            edit.putLong("motor_arm_angle_" + Integer.toString(current_arm_angle), Double.doubleToRawLongBits(x));
            current_r++;
        }*/

        for (Double x : list_servo_1)
        {
            edit.putLong("servo_1_" + Integer.toString(current_servo_1), Double.doubleToRawLongBits(x));
            current_servo_1++;
        }

        /*for (Double x : list_servo_2)
        {
            edit.putLong("servo_2_" + Integer.toString(current_servo_2), Double.doubleToRawLongBits(x));
            current_servo_2++;
        }*/

        edit.apply();
    }
}
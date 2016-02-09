package com.qualcomm.ftcrobotcontroller.opmodes;

import android.content.SharedPreferences;

import com.qualcomm.ftcrobotcontroller.FtcRobotControllerActivity;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.List;


public class AIOp extends OpMode
{
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

    int step;
    //Number of milliseconds for the program to run
    int runLength = 1801;

    @Override
    public void init()
    {
        FtcRobotControllerActivity ftcRobotControllerActivity = new FtcRobotControllerActivity();
        SharedPreferences sharedPreferences = ftcRobotControllerActivity.GetSharedPreferences();

        motor_1 = hardwareMap.dcMotor.get("motor_1");
        //motor_2 = hardwareMap.dcMotor.get("motor_2");
        //motor_arm_extend = hardwareMap.dcMotor.get("motor_arm_extend");
        //motor_arm_angle = hardwareMap.dcMotor.get("motor_arm_angle");
        servo_1 = hardwareMap.servo.get("servo_1");
        //servo_2 = hardwareMap.servo.get("servo_2");

        for (int i = 0; i < runLength; i++)
        {
            String key = "motor_r_" + Integer.toString(i);
            if (sharedPreferences.contains(key))
            {
                list_motor_1.add((double) sharedPreferences.getLong(key, 0));
            }
            else
            {
                list_motor_1.add(0.0);
            }
        }

        for (int i = 0; i < runLength; i++)
        {
            String key = "motor_l_" + Integer.toString(i);
            if (sharedPreferences.contains(key))
            {
                //list_motor_2.add((double) sharedPreferences.getLong(key, 0));
            }
            else
            {
                //list_motor_2.add(0.0);
            }
        }

        /*for (int i = 0; i < 301; i++)
        {
            String key = "motor_arm_extend_" + Integer.toString(i);
            if (sharedPreferences.contains(key))
            {
                list_motor_arm_extend.add((double) sharedPreferences.getLong(key, 0));
            }
            else
            {
                list_motor_arm_extend.add(0.0);
            }
        }

        for (int i = 0; i < 301; i++)
        {
            String key = "motor_arm_angle_" + Integer.toString(i);
            if (sharedPreferences.contains(key))
            {
                list_motor_arm_angle.add((double) sharedPreferences.getLong(key, 0));
            }
            else
            {
                list_motor_arm_angle.add(0.0);
            }
        }*/

        for (int i = 0; i < runLength; i++)
        {
            String key = "servo_1_" + Integer.toString(i);
            if (sharedPreferences.contains(key))
            {
                list_servo_1.add((double) sharedPreferences.getLong(key, 0));
            }
            else
            {
                list_servo_1.add(0.0);
            }
        }

        for (int i = 0; i < 1801; i++)
        {
            String key = "servo_2_" + Integer.toString(i);
            if (sharedPreferences.contains(key))
            {
                //list_servo_2.add((double) sharedPreferences.getLong(key, 0));
            }
            else
            {
                //list_servo_2.add(0.0);
            }
        }

        step = 0;
    }

    @Override
    public void loop()
    {
        if (getRuntime() >= .1 && step < runLength)
        {
            motor_1.setPower(list_motor_1.get(step));
            //motor_2.setPower(list_motor_2.get(step));
            //motor_arm_extend.setPower(list_motor_arm_extend.get(step));
            //motor_arm_angle.setPower(list_motor_arm_angle.get(step));
            servo_1.setPosition(list_servo_1.get(step));
            //servo_2.setPosition(list_servo_2.get(step));
            step++;
            resetStartTime();
        }
        else
        {
            motor_1.setPower(0);
            //motor_2.setPower(0);
            servo_1.setPosition(0);
            //servo_2.setPosition(0);
        }
    }
}
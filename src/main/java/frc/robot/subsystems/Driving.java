/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
 
/* So to make the robot drive we need input from the driver
to tell it where to go. As of the year I am making this we are 
using tank drive and use two joysticks to control the robots
motion. Now if we think more about what is happening here we can 
see that the left joystick should control the left side of the 
drive and vice versa, therefor we need 2 motors(or motor groups)
and 2 joysticks. Driving is the most important part of the robot
and also one of the more confusing ones to code as a starter.
all of driving will be done between this class, its commands,
and the robot container/robot classes. To keep things tidy ill be
placing "\d" after the driving sections in the robot classes.*/

public class DrivingSubsystem extends SubsystemBase {








	
  /*First we need to declare the talons that we will be using so that we can assign them their outputs. We also
  need to creat a differential drive obj so that both talons work at the same time and not one after the other*/


  	public static DifferentialDrive drive;
	public static WPI_TalonSRX leftDriveTalon = new WPI_TalonSRX(Constants.LeftDriveTalonPort);
	public static WPI_TalonSRX rightDriveTalon = new WPI_TalonSRX(Constants.RightDriveTalonPort);










/*This part is the part that actually make the robot move and out of context it seems strange but
the basic knowledge you need is that the robot is moving acording to 2 doubles that are given to us 
by the joysticks. Then after some min/maxing to make sure the robot dosent shoot of into the sunset
without us we give the 2 modified doubles to the differential drive obj so we can drive*/

	public void drive(double leftSpeed, double rightSpeed) {

		if (Math.abs(leftSpeed) > 1.0)
		  leftSpeed = Math.abs(leftSpeed) / leftSpeed; // if the value given was too high, set it to the max
		leftSpeed *= Constants.baseDriveSpeed; // scale down the speed

		if (Math.abs(rightSpeed) > 1)
			rightSpeed = Math.abs(rightSpeed) / rightSpeed; // if the value given was too high, set it to the max
		rightSpeed *= Constants.baseDriveSpeed; // scale down the speed

		drive.tankDrive(leftSpeed, rightSpeed);
	}







/*These are initializations that are used to make sure the robot dosent go off the rails*/
	public static void initDrive() {


    //These commands just make sure that when the robot isnt moving its well... not moving because it has the brakes on.
		leftDriveTalon.setNeutralMode(NeutralMode.Brake);
		rightDriveTalon.setNeutralMode(NeutralMode.Brake);


    /*these just make sure that the robot uses the right loop so
    that it does not get feedback when we are telling it what to do*/
		leftDriveTalon.configOpenloopRamp(1.0);
		leftDriveTalon.configClosedloopRamp(0.0);
		rightDriveTalon.configOpenloopRamp(1.0);
    rightDriveTalon.configClosedloopRamp(0.0);
    
		drive = new DifferentialDrive(leftDriveTalon, rightDriveTalon);

		drive.setDeadband(0.02);
	}


  /*This is just a stop moving command it manually ses talons to 0
  but if a command is still functioning this will not work*/
	public void stop() {
		leftFrontDriveTalon.set(0);
		rightFrontDriveTalon.set(0);
  }


  //IF SOMETHING NEEDS TO BE DONE ALL MATCH PUT IT IN PERIODIC
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

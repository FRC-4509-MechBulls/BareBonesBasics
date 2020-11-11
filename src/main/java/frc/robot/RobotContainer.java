/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Pistons;
import frc.robot.subsystems.Driving;
import frc.robot.commands.drivecommands.TankDrive;
import frc.robot.commands.pistoncommands.PistonExtending;
import frc.robot.commands.pistoncommands.PistonRetract;



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /* The robot's subsystems and commands are defined here...
  This is also where we give the inputs to the commands and map the buttons.*/

  Joystick righDriveJoystick = new Joystick(0);
  Joystick leftDriveJoystick = new Joystick(1);
  Joystick taskJoystick = new Joystick(2);
  DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
  Piston pistonSubsystem = new Piston();



  public RobotContainer() {
    configureButtonBindings();

    /* This is the drive. This is where we get the inputs from the joysticks
    and give em to the commands that give it to the motors.\d*/

    drivingSubsystem.setDefaultCommand(
      new DirectDriveCommand(
          drivingSubsystem,
          () -> getLeftDrive(),
          () -> getRightDrive()));
  }

  public double getRightDrive() {
    return righDriveJoystick.getY();
  }
  public double getLeftDrive() {
  return leftDriveJoystick.getY();
  }

 
  private void configureButtonBindings() {
    /*This is where you will be mapping all the buttons to the controllers.
    if you ever have questions about button ids, check the driver station.*/

    /* This makes a joystick button and relates it to a button in real life
    which is on a real life joystick*/
    final JoystickButton pistonExtendus = new JoystickButton(taskJoystick, 1);


    /*This relates the button we made to the commands. SO when we press the button it will preform the command.*/
    pistonExtendus.whenPressed(new PistonExtending(pistonSubsystem));
    pistonExtendus.whenReleased(new PistonRetractin(pistonSubsystem));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivecommands;
import frc.robot.subsystems.Driving;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDrive extends CommandBase {
  /*For this command we will need things called double suppliers that in essence retreive a double
  from a given source. In this instance the source is found in the robo class where we getour inputs from.*/
  
  private final DrivingSubsystem dSub;

	private final DoubleSupplier left;
	private final DoubleSupplier right;


	public DirectDriveCommand(DrivingSubsystem subsystem, DoubleSupplier left, DoubleSupplier right) {

    dSub = subsystem;
		this.left = left;
		this.right = right;

    addRequirements(dSub);
	}

  // Called when the command is initially scheduled. But we dont really need it here
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dSub.drive(left.getAsDouble(), right.getAsDouble()); // Use input directly from the controller
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

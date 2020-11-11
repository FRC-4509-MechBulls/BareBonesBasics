/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pistoncommands;

import frc.robot.subsystems.Pistons;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class PistonExtending extends CommandBase {
  private final PistonExtending subExtending;

  /**
   * Creates a new ExampleCommand.
   * @param subsystem The subsystem used by this command.
   */
  public PistonExtend(PistonExtending subsystem) {
    subExtending = subsystem;
    // Use addRequirements() here to declare subsystem dependencies ie. I need this subsystem to work.
    addRequirements(subsystem);
  }

  //THIS SECTION IS WHAT SETTS EVERYTHING UP TO CALL THE FUNCTION.
  @Override
  public void initialize() {
  }

  // THIS IS WHAT ACTUALLY CALLS THE FUNCTION AND MAKES ROBOT GO BRR.
  @Override
  public void execute() {
    subExtending.pistonExtend();
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

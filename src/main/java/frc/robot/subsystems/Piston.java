/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Piston extends SubsystemBase {
 
 
  /*To make a piston function we need a solenoid to fire it off and 
  thats pretty much it so we need to make a solenoid obj and make it work*/


  private Solenoid piston = new Solenoid(Constants.solenoidID);



  /*Now that we made and obj we need to use it so we are going to make our
  functions that our commands will call.*/



  //This function will be called by the PistonExtending command and will extend the piston.
  public void pistonExtend()
  {
    piston.set(true);
  }



  //This function will be called by the PistonRetract command and will Retract the piston.
  public void pistonRetract()
  {
    piston.set(false);
  }
  

  
  //IF SOMETHING NEEDS TO BE DONE ALL MATCH PUT IT IN PERIODIC
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

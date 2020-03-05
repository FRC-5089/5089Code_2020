/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Intake extends CommandBase 
{
  /**
   * Creates a new Intake.
   */
  public Intake() 
  {
    addRequirements(RobotContainer.mIntake_Motor);
    addRequirements(RobotContainer.m_Compressor_Pneumatics);
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    RobotContainer.mIntake_Motor.setRaw(-.9);
    RobotContainer.m_Compressor_Pneumatics.Extend();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    RobotContainer.mIntake_Motor.setRaw(0);
    RobotContainer.m_Compressor_Pneumatics.Retract();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

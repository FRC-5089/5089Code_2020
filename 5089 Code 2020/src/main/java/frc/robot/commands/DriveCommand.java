/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class DriveCommand extends CommandBase {
  /**
   * Creates a new DriveCommand.
   */
  public DriveCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveSetup);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double LeftStickY = (Robot.m_robotContainer.Get_Controller_LeftY());
    double RightStickY = (Robot.m_robotContainer.Get_Controller_RightY());


    RobotContainer.m_driveSetup.setLeftMotors(LeftStickY);        
    RobotContainer.m_driveSetup.setRightMotors(RightStickY);    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_driveSetup.setLeftMotors(0);
    RobotContainer.m_driveSetup.setRightMotors(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

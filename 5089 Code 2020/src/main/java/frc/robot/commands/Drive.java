/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;



public class Drive extends CommandBase 
{
  VictorSPX FRMotor, BRMotor, MRMotor, FLMotor, BLMotor, MLMotor;
  /**
   * Creates a new Drive.
   */
  public Drive() 
  {
    addRequirements(RobotContainer.m_Drivebase);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command isx initially scheduled.
  @Override
  public void initialize() 
  {
    FRMotor = new VictorSPX(Constants.Drive1);
    BRMotor = new VictorSPX(Constants.Drive2);
    MRMotor = new VictorSPX(Constants.Drive3);
    FLMotor = new VictorSPX(Constants.Drive4);
    BLMotor = new VictorSPX(Constants.Drive5);
    MLMotor = new VictorSPX(Constants.Drive6);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double Left = RobotContainer.Driver.getRawAxis(1);
    double Right = RobotContainer.Driver.getRawAxis(3);

    FRMotor.set(ControlMode.PercentOutput, -Right);
    BRMotor.set(ControlMode.PercentOutput, -Right);
    MRMotor.set(ControlMode.PercentOutput, -Right);
    FLMotor.set(ControlMode.PercentOutput, Left);
    BLMotor.set(ControlMode.PercentOutput, Left);
    MLMotor.set(ControlMode.PercentOutput, Left);

    /*
    System.out.print("FRMotor" + FRMotor.getMotorOutputVoltage());
    System.out.print("BRMotor" + BRMotor.getMotorOutputVoltage());
    System.out.print("MRMotor" + MRMotor.getMotorOutputVoltage());
    System.out.print("FLMotor" + FLMotor.getMotorOutputVoltage());
    System.out.print("BLMotor" + BLMotor.getMotorOutputVoltage());
    System.out.print("MLMotor" + MLMotor.getMotorOutputVoltage());
    */
    
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

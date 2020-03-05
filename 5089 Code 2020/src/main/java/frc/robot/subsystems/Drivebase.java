/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivebase extends SubsystemBase 
  {
    VictorSPX FRMotor, BRMotor, MRMotor, FLMotor, BLMotor, MLMotor;
  
  public Drivebase() 
  {
    FRMotor = new VictorSPX(Constants.Drive1);
    BRMotor = new VictorSPX(Constants.Drive2);
    MRMotor = new VictorSPX(Constants.Drive3);
    FLMotor = new VictorSPX(Constants.Drive4);
    BLMotor = new VictorSPX(Constants.Drive5);
    MLMotor = new VictorSPX(Constants.Drive6);
  }

  public void setRaw(double Left, double Right)
  {
    FRMotor.set(ControlMode.PercentOutput, -Right);
    BRMotor.set(ControlMode.PercentOutput, -Right);
    MRMotor.set(ControlMode.PercentOutput, -Right);
    FLMotor.set(ControlMode.PercentOutput, Left);
    BLMotor.set(ControlMode.PercentOutput, Left);
    MLMotor.set(ControlMode.PercentOutput, Left);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}

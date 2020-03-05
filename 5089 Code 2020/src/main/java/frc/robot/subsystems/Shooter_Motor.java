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

public class Shooter_Motor extends SubsystemBase 
{
  VictorSPX LeftSideShooter;
  VictorSPX RightSideShooter;
  /**
   * Creates a new Shooter_Motor.
   */
  public Shooter_Motor() 
  {
    LeftSideShooter = new VictorSPX(Constants.Shooter1);
    RightSideShooter = new VictorSPX(Constants.Shooter2);
  }

  public void setRaw(double Fire)
  {
    LeftSideShooter.set(ControlMode.PercentOutput, Fire);
    RightSideShooter.set(ControlMode.PercentOutput, -Fire);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

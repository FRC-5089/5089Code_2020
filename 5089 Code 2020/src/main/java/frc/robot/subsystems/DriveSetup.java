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

public class DriveSetup extends SubsystemBase {
  /**
   * Creates a new DriveSetup.
   */
  public VictorSPX FLMotor_1 = new VictorSPX(Constants.FLMOTOR_1_ID);
  public VictorSPX MLMotor_2 = new VictorSPX(Constants.MLMOTOR_2_ID);
  public VictorSPX BLMotor_3 = new VictorSPX(Constants.BLMOTOR_3_ID);
  public VictorSPX FRMotor_4 = new VictorSPX(Constants.FRMOTOR_4_ID);
  public VictorSPX MRMotor_5 = new VictorSPX(Constants.MRMOTOR_5_ID);
  public VictorSPX BRMotor_6 = new VictorSPX(Constants.BRMOTOR_6_ID);


  public DriveSetup() {

  }

  public void setLeftMotors(double speed)
  {
    FLMotor_1.set(ControlMode.PercentOutput,speed);
    MLMotor_2.set(ControlMode.PercentOutput,speed);
    BLMotor_3.set(ControlMode.PercentOutput,speed);



  }
  public void setRightMotors(double speed)

  {
    FRMotor_4.set(ControlMode.PercentOutput,-speed);
    MRMotor_5.set(ControlMode.PercentOutput,-speed);
    BRMotor_6.set(ControlMode.PercentOutput,-speed);


  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

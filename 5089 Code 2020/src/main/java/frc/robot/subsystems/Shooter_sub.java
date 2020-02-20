/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;



public class Shooter_sub extends SubsystemBase {
  /**
   * Creates a new Shooter_sub.
   */
  public VictorSP Shooter_Motor1 = new VictorSP(Constants.Shooter_8_ID);
  public VictorSP Shooter_Motor2 = new VictorSP(Constants.Shooter_9_ID);



  public Shooter_sub() {







  }

  public void setShooterMotors(double speed)
{

Shooter_Motor1.set(speed);
Shooter_Motor2.set(-speed);




}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

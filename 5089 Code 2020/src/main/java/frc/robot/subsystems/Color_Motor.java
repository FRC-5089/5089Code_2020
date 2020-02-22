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

public class Color_Motor extends SubsystemBase {
  /**
   * Creates a new Color_Motor.
   */

   public VictorSPX Color_Motor = new VictorSPX(0);



  public Color_Motor() {

  }

public void setColor_Motor(double speed){
  Color_Motor.set(ControlMode.PercentOutput,speed);
  
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

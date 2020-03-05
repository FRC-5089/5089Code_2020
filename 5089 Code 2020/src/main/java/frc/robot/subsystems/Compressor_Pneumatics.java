/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Compressor_Pneumatics extends SubsystemBase 
{
  Compressor Compressor;
  DoubleSolenoid Intake_IN_OUT;
  DoubleSolenoid Piston;
  boolean Trigger;

  public Compressor_Pneumatics() 
  {
    Compressor = new Compressor(Constants.Compressor);
    Intake_IN_OUT = new DoubleSolenoid(Constants.Extend, Constants.Retract);
    Piston = new DoubleSolenoid(Constants.Fast, Constants.Slow);

  }

  public void Compressor()
  {
    boolean pressureSwitch = Compressor.getPressureSwitchValue();
    
    if(pressureSwitch)
    {
      Compressor.start();
    }else
    {
      Compressor.stop();
    }
  }

  public void Extend()
  {
    Intake_IN_OUT.set(Value.kForward);
    Trigger = true;
  }

  public void Retract()
  {
    Intake_IN_OUT.set(Value.kReverse);
    Trigger = true;
  }

  public void Fast()
  {
    Piston.set(Value.kForward);
    Trigger = true;
  }

  public void Slow()
  {
    Piston.set(Value.kReverse);
    Trigger = true;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class Wheel_of_Fortune extends CommandBase 
{
  TalonSRX EM = new TalonSRX(Constants.Wheel_of_Fortune);
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatch = new ColorMatch();

  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  
  
  /**
   * Creates a new Encoder.
   */
  public Wheel_of_Fortune() 
  {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    //Colors Defined  
    m_colorMatch.addColorMatch(kBlueTarget);
    m_colorMatch.addColorMatch(kGreenTarget);
    m_colorMatch.addColorMatch(kRedTarget);
    m_colorMatch.addColorMatch(kYellowTarget);  

    System.out.println("Sensor Pos:" + EM.getSelectedSensorPosition()/4096);
    EM.setSelectedSensorPosition(0);
    
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double speed;

    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();

    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatch.matchClosestColor(detectedColor);
    
    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
          //Blue case code
          if (match.color == kRedTarget)
          {
            EM.set(ControlMode.PercentOutput, 0);
            System.out.println("Stop Stop");
          }else
          {
          EM.set(ControlMode.PercentOutput, 1);
          System.out.println("Blue Blue");
          }
          
          break;
        case 'G' :
          //Green case code
          if (match.color == kYellowTarget)
          {
            EM.set(ControlMode.PercentOutput, 0);
            System.out.println("Stop Stop");
          }else
          {
          EM.set(ControlMode.PercentOutput, 1);
          System.out.println("Green Green");
          }

          break;
        case 'R' :
          //Red case code
          if (match.color == kBlueTarget)
          {
            EM.set(ControlMode.PercentOutput, 0);
            System.out.println("Stop Stop");
          }else
          {
          EM.set(ControlMode.PercentOutput, 1);
          System.out.println("Red Red");
          }

          break;
        case 'Y' :
          //Yellow case code
          if (match.color == kGreenTarget)
          {
            EM.set(ControlMode.PercentOutput, 0);
            System.out.println("Stop Stop");
          }else
          {
          EM.set(ControlMode.PercentOutput, 1);
          System.out.println("Yellow Yellow");
          }

          break;
        default :
          //This is corrupt data
          break;
      }
    } 
    else 
    {//Encoder
    if (EM.getSelectedSensorPosition()/4096 > 28)
    {
      speed = 0;
      EM.set(ControlMode.PercentOutput, speed);
    }else
    {
      speed = 1;
      System.out.println("Sensor Pos:" + EM.getSelectedSensorPosition()/4096);
      EM.set(ControlMode.PercentOutput, speed);
      System.out.println("ENCODER ENCODER");
    }
  }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    EM.set(ControlMode.PercentOutput, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

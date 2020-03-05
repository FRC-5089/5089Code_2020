/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Auton_1 extends CommandBase 
{
  Timer Time;
  /**
   * Creates a new Auton.
   */
  public Auton_1() 
  {
    addRequirements(RobotContainer.m_Drivebase);
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    Time = new Timer();

    Time.reset();
    Time.start();

    System.out.println("Auto Init");

    RobotContainer.mShooter_Motor.setRaw(0);
    RobotContainer.mConveyor_Motor.setRaw(0);
    RobotContainer.m_Drivebase.setRaw(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    

    if(Time.get() <= 3)
    {
      RobotContainer.mShooter_Motor.setRaw(-.92);
      System.out.println(Time.get());

    }else if(Time.get() >= 3 && Time.get() <= 9)
    {
      System.out.println("Moving");
      RobotContainer.mConveyor_Motor.setRaw(-.5);


    }else if(Time.get() >= 9 && Time.get() <= 11)
    {
      RobotContainer.mShooter_Motor.setRaw(0);
      RobotContainer.mConveyor_Motor.setRaw(0);

      //RobotContainer.m_Drivebase.setRaw(-1, -1);
      
    }else if(Time.get() >= 11 && Time.get() < 11.6)
    {
      RobotContainer.m_Drivebase.setRaw(-1, -1);

    }else if(Time.get() >= 11.6 && Time.get() <= 13)
    {
      RobotContainer.m_Drivebase.setRaw(0, 0);
      RobotContainer.mConveyor_Motor.setRaw(0);
      RobotContainer.mShooter_Motor.setRaw(0);
    }
    else if(Time.get() >= 13 && Time.get() <= 14)
    {
      RobotContainer.m_Drivebase.setRaw(0, 1);

    }else if(Time.get() >= 14 && Time.get() <= 15)
    {
      RobotContainer.m_Drivebase.setRaw(0, 0);
      RobotContainer.mConveyor_Motor.setRaw(0);
      RobotContainer.mShooter_Motor.setRaw(0);
    }
  
  
  
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

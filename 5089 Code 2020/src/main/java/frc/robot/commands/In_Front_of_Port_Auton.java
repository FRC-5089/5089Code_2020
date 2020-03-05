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

public class Auton_2 extends CommandBase 
{
  Timer Time;
  /**
   * Creates a new Auton_2.
   */
  public Auton_2() 
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
    if(Time.get() <= 2.8)
    {

      System.out.println("Move");
      RobotContainer.m_Drivebase.setRaw(-.25, -.25);
      System.out.println(Time.get());

    }else if(Time.get() >= 2.8 && Time.get() <4)
    {
      System.out.println("Stop");
      RobotContainer.m_Drivebase.setRaw(0, 0);
      RobotContainer.mShooter_Motor.setRaw(-.8);

    }else if(Time.get() >= 4 && Time.get() < 10)
    {
      RobotContainer.mConveyor_Motor.setRaw(-1);
    }else if(Time.get() > 10)
    {
      RobotContainer.mShooter_Motor.setRaw(0);
      RobotContainer.mConveyor_Motor.setRaw(0);

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

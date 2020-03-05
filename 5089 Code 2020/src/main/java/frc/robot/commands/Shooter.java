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

public class Shooter extends CommandBase 
{
  Timer Time;
  /**
   * Creates a new Shooter.
   */
  public Shooter() 
  {
    addRequirements(RobotContainer.mShooter_Motor);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    Time = new Timer();
    Time.reset();
    Time.start();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    var n = Time.get();
    System.out.println(n);

    

    
    if(n >= 1.5)
    {
      RobotContainer.mConveyor_Motor.setRaw(-1);
      RobotContainer.mShooter_Motor.setRaw(-.8);
      System.out.println("IN");
    }else
    {
      RobotContainer.mShooter_Motor.setRaw(-.8);
      System.out.println("Rev");
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    RobotContainer.mShooter_Motor.setRaw(0);
    RobotContainer.mConveyor_Motor.setRaw(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

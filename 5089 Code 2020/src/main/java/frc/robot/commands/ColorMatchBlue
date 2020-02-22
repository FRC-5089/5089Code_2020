/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ColorSetup;

//import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;


public class ColorMatchBlue extends CommandBase {
  /**
   * Creates a new ColorMatchBlue.
   */
  

  public ColorMatchBlue() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Color_Motor);
    addRequirements(RobotContainer.m_ColorSetup);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ColorSetup.m_colorMatcher.addColorMatch(ColorSetup.kBlueTarget);
    ColorSetup.m_colorMatcher.addColorMatch(ColorSetup.kGreenTarget);
    ColorSetup.m_colorMatcher.addColorMatch(ColorSetup.kRedTarget);
    ColorSetup.m_colorMatcher.addColorMatch(ColorSetup.kYellowTarget);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {

    Color detectedColor = ColorSetup.m_colorSensor.getColor();

    ColorMatchResult match = ColorSetup.m_colorMatcher.matchClosestColor(detectedColor);

    System.out.println(match.color);

    if (match.color == ColorSetup.kBlueTarget) {
      RobotContainer.m_Color_Motor.setColor_Motor(0);
  } else {
      RobotContainer.m_Color_Motor.setColor_Motor(0.2);
  }

}
  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    RobotContainer.m_Color_Motor.setColor_Motor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

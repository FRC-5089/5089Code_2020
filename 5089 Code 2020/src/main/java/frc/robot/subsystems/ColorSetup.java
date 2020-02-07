/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorSetup extends SubsystemBase {
  /**
   * Creates a new ColorSetup.
   */

  private final static I2C.Port i2cPort = I2C.Port.kOnboard;
  public static ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  public static ColorMatch m_colorMatcher = new ColorMatch();

  public static Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  public static Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  public final static Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  public final static Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  public ColorSetup() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

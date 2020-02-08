/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.commands.Encoder;
import frc.robot.commands.ExampleCommand;

import frc.robot.commands.ColorMatchRed;
import frc.robot.commands.ColorMatchBlue;
import frc.robot.commands.ColorMatchGreen;
import frc.robot.commands.ColorMatchYellow;
import frc.robot.subsystems.ColorSetup;





import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.EncoderMotor;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ConveyorCommand;
import frc.robot.commands.ConveyorCommandBackward;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.Shooter_sub;






/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //Subsystem
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static Drivebase m_Drivebase = new Drivebase();
  public static Shooter_sub m_shooterSetup = new Shooter_sub();

  
  
  
  
  private final Joystick stick = new Joystick(Constants.Joystick_port);
  private final JoystickButton = redButton = new JoystickButton(stick, Constants.Joystick_buttonR);
  private final JoystickButton = blueButton = new JoystickButton(stick, Constants.Joystick_buttonB);
  private final JoystickButton = greenButton = new JoystickButton(stick, Constants.Joystick_buttonG);
  private final JoystickButton = yellowButton = new JoystickButton(stick, Constants.Joystick_buttonY);

  
  
    public static Joystick stick = new Joystick(0);

  
  
  
  public static EncoderMotor mEncoderMotor = new EncoderMotor();

  //Commands
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  

  public static Joystick Driver = new Joystick(Constants.Controller);

    
  JoystickButton Button = new JoystickButton(Driver, 1);
  JoystickButton Fowawrd = new JoystickButton(Driver, 2);

  JoystickButton Con_button = new JoystickButton(stick, 1);
  JoystickButton Shooter_button = new JoystickButton(stick,2);
  
  JoystickButton Con_buttonF = new JoystickButton(stick, 1);
  JoystickButton Con_buttonB = new JoystickButton(stick, 2);

  
  
  
  /*double Left_Side()
  {
    double Left = Driver.getRawAxis(1);
    return Left;
  }
  double Right_Side()
  {
    double Right = Driver.getRawAxis(3);
    return Right;
  }*/


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() 
  {
    m_Drivebase.setDefaultCommand(new Drive());
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    Button.whileHeld(new Encoder());
    redButton.whileHeld(new ColorMatchRed());
    blueButton.whileHeld(new ColorMatchBlue());
    greenButton.whileHeld(new ColorMatchGreen());
    yellowButton.whileHeld(new ColorMatchYellow());
    
    Con_buttonF.whileHeld(new ConveyorCommandForward());
    Con_buttonB.whileHeld(new ConveyorCommandBackward());
    Shooter_button.whileHeld(new ShooterCommand());

    

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}

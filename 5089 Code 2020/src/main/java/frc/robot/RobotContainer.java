/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//Ale was here :)
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Auton_1;
import frc.robot.commands.Auton_2;
import frc.robot.commands.Drive;
import frc.robot.commands.Intake;
import frc.robot.commands.Intake_Back;
import frc.robot.commands.Intake_Hold;
import frc.robot.commands.Move_to_Chamber;
import frc.robot.commands.Shooter;
import frc.robot.commands.Wheel_of_Fortune;
import frc.robot.subsystems.Compressor_Pneumatics;
import frc.robot.subsystems.Conveyor_Motor;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.EncoderMotor;
import frc.robot.subsystems.Intake_Motor;
import frc.robot.subsystems.Shooter_Motor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //Subsystem
  public static Drivebase m_Drivebase = new Drivebase();
  public static Intake_Motor mIntake_Motor = new Intake_Motor();
  public static Compressor_Pneumatics m_Compressor_Pneumatics = new Compressor_Pneumatics();
  public static Shooter_Motor mShooter_Motor = new Shooter_Motor();
  public static Conveyor_Motor mConveyor_Motor = new Conveyor_Motor();

  public static EncoderMotor mEncoderMotor = new EncoderMotor();
  
  

  //Commands
  

  public static Joystick Driver = new Joystick(Constants.Driver);
  public static Joystick Co_Driver = new Joystick(Constants.Co_Driver);
  

  //Driver Control
  
  
  //Co_Driver Control
  JoystickButton WheelofFortune = new JoystickButton(Co_Driver, 1);
  JoystickButton Reverse_Intake = new JoystickButton(Co_Driver, 4);
  JoystickButton Moving_Chamber = new JoystickButton(Co_Driver, 5);
  JoystickButton Roll_In = new JoystickButton(Co_Driver, 6);
  JoystickButton Intake = new JoystickButton(Co_Driver, 7);
  JoystickButton Fire = new JoystickButton(Co_Driver, 8);
  
  

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


    WheelofFortune.whileHeld(new Wheel_of_Fortune());
    Moving_Chamber.whileHeld(new Move_to_Chamber());
    Intake.whileHeld(new Intake());
    Fire.whileHeld(new Shooter());
    Roll_In.whileHeld(new Intake_Hold());
    Reverse_Intake.whileHeld(new Intake_Back());

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Auton_2 getAutonomousCommand() 
  {

    //Anlge Shoot Drive Turn_180
    return new Auton_2();



  }
}



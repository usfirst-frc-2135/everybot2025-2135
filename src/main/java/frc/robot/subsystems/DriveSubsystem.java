// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase
{
  private final WPI_TalonSRX     leftLeader;
  private final WPI_TalonSRX     leftFollower;
  private final WPI_TalonSRX     rightLeader;
  private final WPI_TalonSRX     rightFollower;

  public final DifferentialDrive drive;

  /**
   * The subsystem used to drive the robot.
   */
  TalonSRXConfiguration DriveSRXConfig( )
  {
    // Create a new config object with factory default settings
    TalonSRXConfiguration driveConfig = new TalonSRXConfiguration( );

    // Apply the needed changes from the default settings
    driveConfig.continuousCurrentLimit = DriveConstants.DRIVE_MOTOR_CURRENT_LIMIT;
    leftLeader.configVoltageCompSaturation(DriveConstants.DRIVE_MOTOR_VOLTAGE_COMP, 250);
    rightLeader.configVoltageCompSaturation(DriveConstants.DRIVE_MOTOR_VOLTAGE_COMP, 250);
    leftFollower.configVoltageCompSaturation(DriveConstants.DRIVE_MOTOR_VOLTAGE_COMP, 250);
    rightFollower.configVoltageCompSaturation(DriveConstants.DRIVE_MOTOR_VOLTAGE_COMP, 250);

    return driveConfig;
  }

  public DriveSubsystem( )
  {
    // Create the four motor controller objects
    leftLeader = new WPI_TalonSRX(DriveConstants.LEFT_LEADER_ID);
    leftFollower = new WPI_TalonSRX(DriveConstants.LEFT_FOLLOWER_ID);
    rightLeader = new WPI_TalonSRX(DriveConstants.RIGHT_LEADER_ID);
    rightFollower = new WPI_TalonSRX(DriveConstants.LEFT_FOLLOWER_ID);

    // Create the differential drive object that translates joysticks into motor inputs
    drive = new DifferentialDrive(leftLeader, rightLeader);

    // This erases any prior configuration and applies new config settings
    leftLeader.configAllSettings(DriveSRXConfig( ));
    rightLeader.configAllSettings(DriveSRXConfig( ));
    leftFollower.configAllSettings(DriveSRXConfig( ));
    rightFollower.configAllSettings(DriveSRXConfig( ));

    leftLeader.enableVoltageCompensation(true);
    rightLeader.enableVoltageCompensation(true);
    leftFollower.enableVoltageCompensation(true);
    rightFollower.enableVoltageCompensation(true);

    leftLeader.setNeutralMode(NeutralMode.Coast);
    rightLeader.setNeutralMode(NeutralMode.Coast);
    leftFollower.setNeutralMode(NeutralMode.Coast);
    rightFollower.setNeutralMode(NeutralMode.Coast);

    leftLeader.setInverted(false);
    leftFollower.setInverted(false);
    rightLeader.setInverted(true);
    rightFollower.setInverted(true);

    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);
  }

  @Override
  public void periodic( )
  {}

  /**
   * Use this to control your drive train, with one axis of the controller moving the robot
   * forwards and backwards with the other axis turning the robot.
   * 
   * Additionally if squared is true, it will square your controller inputs,
   * for instance pushing forwards on the control stick will yield
   * (0.5 * 0.5) = .25 or 25% power to the drivetrain.
   * 
   * @param xSpeed
   *          the speed forwards to back
   * @param zRotation
   *          the speed to turn at
   * @param squared
   *          do you square the inputs from the controller
   */
  public void driveArcade(double xSpeed, double zRotation, boolean squared)
  {
    drive.arcadeDrive(xSpeed, zRotation, squared);
  }

  /**
   * Use this to drive the robot, with one stick controlling one
   * side of the drivetrain and the other stick controlling the other.
   * 
   * @param leftSpeed
   *          speed to drive the left side of the robot at
   * @param rightSpeed
   *          speed to drive the right side of the robot at
   * @param squared
   *          do you square the inputs from the controller
   */
  public void driveTank(double leftSpeed, double rightSpeed, boolean squared)
  {
    drive.tankDrive(leftSpeed, rightSpeed, squared);
  }
}

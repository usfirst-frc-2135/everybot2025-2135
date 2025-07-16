// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private final WPI_TalonSRX leftLeaderSRX;
  private final WPI_TalonSRX leftFollowerSRX;
  private final WPI_TalonSRX rightLeaderSRX;
  private final WPI_TalonSRX rightFollowerSRX;

  private final DifferentialDrive drive;

  /**
   * The subsystem used to drive the robot.
   */
  TalonSRXConfiguration DriveSRXConfig(boolean inverted) {
    TalonSRXConfiguration DriveConfig = new TalonSRXConfiguration();

    return DriveConfig;
  }

  public DriveSubsystem() {

    leftLeaderSRX = new WPI_TalonSRX(1);
    leftFollowerSRX = new WPI_TalonSRX(2);
    rightLeaderSRX = new WPI_TalonSRX(3);
    rightFollowerSRX = new WPI_TalonSRX(4);

    drive = new DifferentialDrive(leftLeaderSRX, rightLeaderSRX);

    leftLeaderSRX.setInverted(true);
    rightLeaderSRX.setInverted(false);

    leftLeaderSRX.configAllSettings(null);
    rightLeaderSRX.configAllSettings(null);

    leftFollowerSRX.follow(leftLeaderSRX);
    rightFollowerSRX.follow(rightLeaderSRX);

  }

  @Override
  public void periodic() {
  }

  /**
   * Use this to control your drive train, with one axis of the controller moving
   * the robot
   * forwards and backwards with the other axis turning the robot.
   * 
   * Additionally if squared is true, it will square your controller inputs,
   * for instance pushing forwards on the control stick will yield
   * (0.5 * 0.5) = .25 or 25% power to the drivetrain.
   * 
   * @param xSpeed    the speed forwards to back
   * @param zRotation the speed to turn at
   * @param squared   do you square the inputs from the controller
   */
  public void driveArcade(double xSpeed, double zRotation, boolean squared) {
    drive.arcadeDrive(xSpeed, zRotation, squared);
  }

  /**
   * Use this to drive the robot, with one stick controlling one
   * side of the drivetrain and the other stick controlling the other.
   * 
   * @param leftSpeed  speed to drive the left side of the robot at
   * @param rightSpeed speed to drive the right side of the robot at
   * @param squared    do you square the inputs from the controller
   */
  public void driveTank(double leftSpeed, double rightSpeed, boolean squared) {
    drive.tankDrive(leftSpeed, rightSpeed, squared);
  }
}
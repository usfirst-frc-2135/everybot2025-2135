package frc.robot.subsystems;

// import com.revrobotics.spark.SparkMax;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.revrobotics.spark.SparkBase.PersistMode;
// import com.revrobotics.spark.SparkBase.ResetMode;
// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.config.SparkMaxConfig;
// import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
// import frc.robot.Constants.RollerConstants;
// import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RollerSubsystem extends SubsystemBase {

    private final WPI_TalonSRX rollerMotor;

    /**
     * This subsytem that controls the roller.
     */
    public RollerSubsystem() {
        rollerMotor = new WPI_TalonSRX(5);

        // Set up the roller motor as a brushed motor
        // rollerMotor = new SparkMax(RollerConstants.ROLLER_MOTOR_ID,
        // MotorType.kBrushed);

        // // Set can timeout. Because this project only sets parameters once on
        // // construction, the timeout can be long without blocking robot operation.
        // Code
        // // which sets or gets parameters during operation may need a shorter timeout.
        // rollerMotor.setCANTimeout(250);

        // Create and apply configuration for roller motor. Voltage compensation helps
        // the roller behave the same as the battery
        // voltage dips. The current limit helps prevent breaker trips or burning out
        // the motor in the event the roller stalls.
        // SparkMaxConfig rollerConfig = new SparkMaxConfig();
        // rollerConfig.voltageCompensation(RollerConstants.ROLLER_MOTOR_VOLTAGE_COMP);
        // rollerConfig.smartCurrentLimit(RollerConstants.ROLLER_MOTOR_CURRENT_LIMIT);
        // rollerConfig.idleMode(IdleMode.kBrake);
        // rollerMotor.configure(rollerConfig, ResetMode.kResetSafeParameters,
        // PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {
    }

    /**
     * This is a method that makes the roller spin to your desired speed.
     * Positive values make it spin forward and negative values spin it in reverse.
     * 
     * @param speedmotor speed from -1.0 to 1, with 0 stopping it
     */
    public void runRoller(double speed) {
        rollerMotor.set(speed);
    }

}
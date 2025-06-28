package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
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
        // Set up the roller motor as a brushed motor
        rollerMotor = new WPI_TalonSRX(5);

        // Create and apply configuration for roller motor. Voltage compensation helps
        // the roller behave the same as the battery
        // voltage dips. The current limit helps prevent breaker trips or burning out
        // the motor in the event the roller stalls.
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
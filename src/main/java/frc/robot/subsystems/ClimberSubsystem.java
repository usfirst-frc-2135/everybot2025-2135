package frc.robot.subsystems;

// import frc.robot.Constants.ClimberConstants;
// import com.ctre.phoenix6.sim.TalonFXSimState;
// import com.ctre.phoenix6.configs.TalonFXConfiguration;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;

public class ClimberSubsystem extends SubsystemBase {
    // Set up the climb motor as a brushless motor
    final TalonFX m_climbMotor = new TalonFX(7);

    // private final TalonFX m_climbMotor;
    /**
     * This subsytem that controls the climber.
     */
    public ClimberSubsystem() {

        // Create and apply configuration for climb motor. Voltage compensation helps
        // the climb behave the same as the battery
        // voltage dips. The current limit helps prevent breaker trips or burning out
        // the motor in the event the climb stalls.
        // climbConfig.voltageCompensation(ClimberConstants.CLIMBER_MOTOR_VOLTAGE_COMP);
        // climbConfig.smartCurrentLimit(ClimberConstants.CLIMBER_MOTOR_CURRENT_LIMIT);
        // climbConfig.idleMode(IdleMode.kBrake);
        // climbMotor.configure(climbConfig, ResetMode.kResetSafeParameters,
        // PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {
    }

    /**
     * Use to run the climber, can be set to run from 100% to -100%.
     * Keep in mind that the direction changes based on which way the winch is
     * wound.
     * 
     * @param speed motor speed from -1.0 to 1, with 0 stopping it
     */
    public void runClimber(double speed) {
        m_climbMotor.set(speed);
    }

}
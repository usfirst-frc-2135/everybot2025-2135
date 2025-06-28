package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;

public class ClimberSubsystem extends SubsystemBase {
    // Set up the climb motor as a brushless motor
    final TalonFX m_climbMotor = new TalonFX(7);

    /**
     * This subsytem that controls the climber.
     */
    public ClimberSubsystem() {
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
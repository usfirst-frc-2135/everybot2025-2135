package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

public class ClimberSubsystem extends SubsystemBase
{
    // Set up the climb motor as a brushless motor
    final TalonFX m_climbMotor = new TalonFX(ClimberConstants.CLIMBER_MOTOR_ID);

    TalonFXConfiguration ClimbFXConfig( )
    {
        // Create a new config object with factory default settings
        TalonFXConfiguration climbConfig = new TalonFXConfiguration( );

        // Apply the needed changes from the default settings
        climbConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        return climbConfig;
    }

    /**
     * This subsytem that controls the climber.
     */
    public ClimberSubsystem( )
    {
        // TODO: We should apply our config here, set brake/coast, current limit, inverted and voltage compensation -- these should all be configs for TalonFX
        // ClimbFXConfig();
    }

    @Override
    public void periodic( )
    {}

    /**
     * Use to run the climber, can be set to run from 100% to -100%.
     * Keep in mind that the direction changes based on which way the winch is
     * wound.
     * 
     * @param speed
     *            motor speed from -1.0 to 1, with 0 stopping it
     */
    public void runClimber(double speed)
    {
        m_climbMotor.set(speed);
    }
}

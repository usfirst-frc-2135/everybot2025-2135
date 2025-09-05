
package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

public class ClimberSubsystem extends SubsystemBase
{
    // Set up the climb motor as a brushless motor
    private TalonFX m_climbMotor = new TalonFX(ClimberConstants.CLIMBER_MOTOR_ID);

    /**
     * This subsytem that controls the climber.
     */
    TalonFXConfiguration climberFXConfig( )
    {
        // Create a new config object with factory default settings
        TalonFXConfiguration climberConfig = new TalonFXConfiguration( );

        // Apply the needed changes from the default settings
        climberConfig.CurrentLimits.StatorCurrentLimit = ClimberConstants.CLIMBER_MOTOR_CURRENT_LIMIT;
        climberConfig.CurrentLimits.StatorCurrentLimitEnable = true;

        climberConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        climberConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

        return climberConfig;
    }

    public ClimberSubsystem( )
    {
        m_climbMotor.getConfigurator( ).apply(climberFXConfig( ));
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
        // Convert percent output to units of voltage
        m_climbMotor.setVoltage(speed * 12.0);
    }
}

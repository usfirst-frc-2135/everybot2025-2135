
package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

public class ClimberSubsystem extends SubsystemBase
{
    private TalonFX m_climbMotor = new TalonFX(ClimberConstants.CLIMBER_MOTOR_ID);
    // Set up the climb motor as a brushless motor

    /**
     * This subsytem that controls the climber.
     */
    TalonFXConfiguration climberFXConfig( )
    {
        TalonFXConfiguration climberConfig = new TalonFXConfiguration( );

        climberConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        climberConfig.CurrentLimits.StatorCurrentLimit = ClimberConstants.CLIMBER_MOTOR_CURRENT_LIMIT;
        climberConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        return climberConfig;

    }

    public ClimberSubsystem( )
    {
        m_climbMotor.setVoltage(12);

        m_climbMotor.getConfigurator( ).apply(climberFXConfig( ));

        // m_climbMotor.set(ControlMode.PercentOutput, 1.0);

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

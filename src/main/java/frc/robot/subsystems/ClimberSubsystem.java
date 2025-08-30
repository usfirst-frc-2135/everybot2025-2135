
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import frc.robot.Constants.ClimberConstants;

public class ClimberSubsystem extends SubsystemBase
{
    final TalonFX m_climbMotor;
    // Set up the climb motor as a brushless motor

    /**
     * This subsytem that controls the climber.
     */
    TalonFXConfiguration climberFXConfig( )
    {
        var limitConfigs = new CurrentLimitsConfigs( );
        limitConfigs.StatorCurrentLimit = ClimberConstants.CLIMBER_MOTOR_CURRENT_LIMIT;
        limitConfigs.StatorCurrentLimitEnable = true;
        TalonFXConfiguration climberConfig = new TalonFXConfiguration( );
        MotorOutputConfigs mode = new MotorOutputConfigs( ).withNeutralMode(NeutralModeValue.Brake);

        return climberConfig;

    }

    public ClimberSubsystem( )
    {
        m_climbMotor = new TalonFX(ClimberConstants.CLIMBER_MOTOR_ID);

        // m_climbMotor.enableVoltageCompensation(true);
        // m_climbMotor.configVoltageComSaturation(12);
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

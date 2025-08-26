package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RollerConstants;

public class RollerSubsystem extends SubsystemBase
{
    private final WPI_TalonSRX rollerMotor;

    TalonSRXConfiguration RollerSRXConfig( )
    {
        // Create a new config object with factory default settings
        TalonSRXConfiguration rollerConfig = new TalonSRXConfiguration( );

        // Apply the needed changes from the default settings
        rollerConfig.peakCurrentLimit = RollerConstants.ROLLER_MOTOR_CURRENT_LIMIT;

        return rollerConfig;
    }

    /**
     * This subsytem that controls the roller.
     */
    public RollerSubsystem( )
    {
        // Set up the roller motor as a brushed motor
        rollerMotor = new WPI_TalonSRX(RollerConstants.ROLLER_MOTOR_ID);
        rollerMotor.setInverted(true);
        rollerMotor.enableVoltageCompensation(true);
        rollerMotor.configVoltageCompSaturation(RollerConstants.ROLLER_MOTOR_VOLTAGE_COMP, 250); // TODO: Move this to config above
        rollerMotor.setNeutralMode(NeutralMode.Brake);

        // This erases any prior configuration and applies new config settings
        rollerMotor.configAllSettings(RollerSRXConfig( ));       // TODO: This should be the FIRST call after declaring new WPI_TalonSRX above
    }

    @Override
    public void periodic( )
    {}

    /**
     * This is a method that makes the roller spin to your desired speed.
     * Positive values make it spin forward and negative values spin it in reverse.
     * 
     * @param speedmotor
     *            speed from -1.0 to 1, with 0 stopping it
     */
    public void runRoller(double speed)
    {
        rollerMotor.set(speed);
    }
}

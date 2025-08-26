package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
// import frc.robot.Constants.OperatorConstants;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.RollerConstants;

public class RollerSubsystem extends SubsystemBase
{

    private final WPI_TalonSRX rollerMotor;

    TalonSRXConfiguration RollerSRXConfig( )
    {
        TalonSRXConfiguration rollerConfig = new TalonSRXConfiguration( );
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
        rollerMotor.configVoltageCompSaturation(RollerConstants.ROLLER_MOTOR_VOLTAGE_COMP, 250);
        rollerMotor.setNeutralMode(NeutralMode.Brake);

        rollerMotor.configAllSettings(RollerSRXConfig( ));
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

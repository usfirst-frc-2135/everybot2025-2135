package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase
{
    private final WPI_TalonSRX armMotor;

    TalonSRXConfiguration armSRXConfig( )
    {
        // Create a new config object with factory default settings
        TalonSRXConfiguration armConfig = new TalonSRXConfiguration( );

        // Apply the needed changes from the default settings
        armConfig.peakCurrentLimit = ArmConstants.ARM_MOTOR_CURRENT_LIMIT;  // TODO: This should be a continuous current limit, not peak

        return armConfig;
    }

    /**
     * This subsytem that controls the arm.
     */
    public ArmSubsystem( )
    {
        // Set up the arm motor as a brushed motor
        armMotor = new WPI_TalonSRX(ArmConstants.ARM_MOTOR_ID);
        armMotor.setInverted(true);
        armMotor.enableVoltageCompensation(true);
        armMotor.configVoltageCompSaturation(ArmConstants.ARM_MOTOR_VOLTAGE_COMP, 250); // TODO: Move this to config above

        // This erases any prior configuration and applies new config settings
        armMotor.configAllSettings(armSRXConfig( ));        // TODO: This should be the FIRST call after declaring new WPI_TalonSRX above
        armMotor.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic( )
    {}

    /**
     * This is a method that makes the arm move at your desired speed
     * Positive values make it spin forward and negative values spin it in reverse
     *
     * @param speed
     *            motor speed from -1.0 to 1, with 0 stopping it
     */
    public void runArm(double speed)
    {
        armMotor.set(speed);
    }
}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.OperatorConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

    private final WPI_TalonSRX armMotor;

    TalonSRXConfiguration ArmSRXConfig() {
        TalonSRXConfiguration armConfig = new TalonSRXConfiguration();
        return armConfig;
    }

    /**
     * This subsytem that controls the arm.
     */
    public ArmSubsystem() {
        // Set up the arm motor as a brushed motor
        armMotor = new WPI_TalonSRX(ArmConstants.ARM_MOTOR_ID);

        armMotor.configAllSettings(ArmSRXConfig());

    }

    @Override
    public void periodic() {
    }

    /**
     * This is a method that makes the arm move at your desired speed
     * Positive values make it spin forward and negative values spin it in reverse
     * 
     * @param speed motor speed from -1.0 to 1, with 0 stopping it
     */
    public void runArm(double speed) {
        armMotor.set(speed);
    }
}
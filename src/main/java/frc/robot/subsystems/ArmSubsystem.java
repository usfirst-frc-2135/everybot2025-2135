package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

    private final WPI_TalonSRX armMotor;

    /**
     * This subsytem that controls the arm.
     */
    public ArmSubsystem() {
        // Set up the arm motor as a brushed motor
        armMotor = new WPI_TalonSRX(6);

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
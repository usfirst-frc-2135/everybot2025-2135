package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RollerSubsystem extends SubsystemBase {

    private final WPI_TalonSRX rollerMotor;

    /**
     * This subsytem that controls the roller.
     */
    public RollerSubsystem() {
        // Set up the roller motor as a brushed motor
        rollerMotor = new WPI_TalonSRX(5);

    }

    @Override
    public void periodic() {
    }

    /**
     * This is a method that makes the roller spin to your desired speed.
     * Positive values make it spin forward and negative values spin it in reverse.
     * 
     * @param speedmotor speed from -1.0 to 1, with 0 stopping it
     */
    public void runRoller(double speed) {
        rollerMotor.set(speed);
    }

}
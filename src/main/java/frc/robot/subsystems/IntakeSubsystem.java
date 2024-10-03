package frc.robot.subsystems;
import static frc.robot.Constants.IntakeConstants.*;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase { 
    final CANSparkMax intakeMotor;
    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(0,    CANSparkLowLevel.MotorType.kBrushed);

    }

    public void intake() {
        intakeMotor.set(intakingSpeed);
    }

    public void eject() {
        intakeMotor.set(ejectingSpeed);
    }

    public void stop() {
        intakeMotor.set(stoppingSpeed);
    }


}
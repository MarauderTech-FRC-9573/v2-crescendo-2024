package frc.robot.subsystems;
import static frc.robot.Constants.IntakeConstants.*;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class IntakeSubsystem extends SubsystemBase { 
    public final CANSparkMax intakeMotor;
    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(6, CANSparkLowLevel.MotorType.kBrushed);
        intakeMotor.setSmartCurrentLimit(kIntakeCurrentLimit);
        
    }

    public void stop() {
        intakeMotor.set(stoppingSpeed);
    }

}
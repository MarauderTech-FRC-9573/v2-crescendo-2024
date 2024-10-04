package frc.robot.subsystems;
import static frc.robot.Constants.IntakeConstants.*;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase { 
    final CANSparkMax intakeMotor;
    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(0,    CANSparkLowLevel.MotorType.kBrushed);
        
    }
    
    public Command intake() {
        return this.startEnd (
        () -> {
            intakeMotor.set(intakingSpeed);
            wait(1000);
        }, 
        () -> {
            stop();
        });
    }
    
    public Command eject() {
        return this.startEnd (
        () -> {
            intakeMotor.set(ejectingSpeed);
        },
        () -> {
            stop();
        });
    }
    
    public void stop() {
        intakeMotor.set(stoppingSpeed);
    }
    
    
}
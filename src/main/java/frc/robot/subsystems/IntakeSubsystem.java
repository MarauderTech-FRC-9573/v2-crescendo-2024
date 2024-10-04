package frc.robot.subsystems;
import static frc.robot.Constants.IntakeConstants.*;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class IntakeSubsystem extends SubsystemBase { 
    final CANSparkMax intakeMotor;
	public CANSparkMax bottomShooterMotor;
    public CANSparkMax topShooterMotor;
    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(0,    CANSparkLowLevel.MotorType.kBrushed);
        
    }

    
    public Command intake() {
        return this.startEnd (
        () -> {
            intakeMotor.set(intakingSpeed);
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


    public void set(double intakingspeed) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }
    
    
}
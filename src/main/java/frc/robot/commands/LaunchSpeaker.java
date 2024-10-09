package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.*;
import static frc.robot.Constants.ShooterConstants.*;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class LaunchSpeaker extends Command {
    private ShooterSubsystem shooterSubsystem;
    private CANSparkMax bottom;
    private CANSparkMax top; 
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax intake;
    
    public LaunchSpeaker(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        bottom = shooterSubsystem.bottomShooterMotor;
        top = shooterSubsystem.topShooterMotor;
        intake = intakeSubsystem.intakeMotor;

    }
    
    @Override 
    public void initialize() {
        bottom.set(kSpeakerSpeed);
        top.set(kSpeakerSpeed);
        intake.set(intakingSpeed);
    }
    
    @Override
    public void execute() {
    }
    
    public void shoot() {
        
    }
    
    @Override
    public void end(boolean isInterrupted) {
        shooterSubsystem.stop();
        intakeSubsystem.stop();
    }
}
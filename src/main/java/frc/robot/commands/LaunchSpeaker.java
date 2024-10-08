package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.*;
import static frc.robot.Constants.ShooterConstants.*;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class LaunchSpeaker extends Command {
    private ShooterSubsystem shooterSubsystem;
    private CANSparkMax bottom;
    private CANSparkMax top; 
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax intake;
    Timer timer;
    private boolean isRunning;
    
    public LaunchSpeaker(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        bottom = shooterSubsystem.bottomShooterMotor;
        top = shooterSubsystem.topShooterMotor;
        intake = intakeSubsystem.intakeMotor;
        timer = new Timer();

    }
    
    @Override 
    public void initialize() {
        intakeSubsystem.intakeMotor.set(launchSpeed);
        timer.reset();
        timer.start();
        isRunning = true;
    }
    
    @Override
    public void execute() {
        if (isRunning && timer.get() >= 0.5) {
            isRunning = false;
            shoot();
        }
    }
    
    public void shoot() {
        bottom.set(kSpeakerSpeed);
        top.set(kSpeakerSpeed);
        intake.set(intakingSpeed);
        
    }
    
    @Override
    public void end(boolean isInterrupted) {
        shooterSubsystem.stop();
        intakeSubsystem.stop();
    }
    
}
package frc.robot.commands;

import static frc.robot.Constants.ShooterConstants.*;
import static frc.robot.Constants.IntakeConstants.*;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class LaunchAmp extends Command {
    private ShooterSubsystem shooterSubsystem;
    private CANSparkMax bottom;
    private CANSparkMax top; 
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax intake;
    Timer timer;
    private boolean isRunning;
    
    public LaunchAmp(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        bottom = shooterSubsystem.bottomShooterMotor;
        top = shooterSubsystem.topShooterMotor;
        intake = intakeSubsystem.intakeMotor;
        timer = new Timer();
        
    }
    
    @Override 
    public void initialize() {
        new IntakeBack(intakeSubsystem).withTimeout(0.5);
        bottom.set(kAmpSpeedBottom);
        top.set(kAmpSpeedTop);
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
        // intakeSubsystem.stop();
    }
    
}
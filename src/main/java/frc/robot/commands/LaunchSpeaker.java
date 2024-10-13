package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.*;
import static frc.robot.Constants.ShooterConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

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

    private RelativeEncoder topEncoder, bottomEncoder;
    
    public LaunchSpeaker(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        bottom = shooterSubsystem.bottomShooterMotor;
        top = shooterSubsystem.topShooterMotor;
        intake = intakeSubsystem.intakeMotor;

        topEncoder = top.getEncoder();
        bottomEncoder = bottom.getEncoder();

    }
    
    @Override 
    public void initialize() {
        bottom.set(kSpeakerSpeed);
        top.set(kSpeakerSpeed);
    }
    
    @Override
    public void execute() {
        if (topEncoder.getVelocity() > 1000 && bottomEncoder.getVelocity() > 1000) {
            intake.set(intakingSpeed);
        }
    }
    
    public void shoot() {
        
    }
    
    @Override
    public void end(boolean isInterrupted) {
        shooterSubsystem.stop();
        intakeSubsystem.stop();
    }
}
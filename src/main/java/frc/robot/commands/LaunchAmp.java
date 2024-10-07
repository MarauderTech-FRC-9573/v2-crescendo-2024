package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.intakingSpeed;
import static frc.robot.Constants.ShooterConstants.kAmpSpeedBottom;
import static frc.robot.Constants.ShooterConstants.kAmpSpeedTop;
import static frc.robot.Constants.ShooterConstants.kSpeakerSpeed;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class LaunchAmp extends Command {
    private ShooterSubsystem shooterSubsystem;
    private CANSparkMax bottom;
    private CANSparkMax top; 
    
    public LaunchAmp(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        bottom = shooterSubsystem.bottomShooterMotor;
        top = shooterSubsystem.topShooterMotor;
    }

    @Override 
    public void initialize() {
        
        bottom.set(kAmpSpeedBottom);
        top.set(kAmpSpeedTop);

    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean isInterrupted) {
        shooterSubsystem.stop();
    }

}
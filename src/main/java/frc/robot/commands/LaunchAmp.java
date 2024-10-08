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
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax intake;
    
    public LaunchAmp(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        bottom = shooterSubsystem.bottomShooterMotor;
        top = shooterSubsystem.topShooterMotor;
        intake = intakeSubsystem.intakeMotor;
    }

    @Override 
    public void initialize() {
        
        bottom.set(kAmpSpeedBottom);
        top.set(kAmpSpeedTop);
        intake.set(intakingSpeed);

    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean isInterrupted) {
        shooterSubsystem.stop();
        intakeSubsystem.stop();
    }

}
package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.intakingSpeed;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.DigitalGlitchFilter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class AutoMoveIntake extends Command {
    private DriveSubsystem driveSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private ShooterSubsystem shooterSubsystem;
    CANSparkMax intakeMotor;
    DigitalInput beamBreaker;
    
    public AutoMoveIntake(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem) {
        this.driveSubsystem = driveSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.shooterSubsystem = shooterSubsystem;
        intakeMotor = intakeSubsystem.intakeMotor;
    }
    
    @Override
    public void initialize() {
        System.out.println("bruh wtffff");
        
    }
    
    @Override
    public void execute() {
        driveSubsystem.driveArcade(0.7, 0);
        intakeMotor.set(intakingSpeed);
    }

    @Override
    public void end(boolean isInterrupted) {
        driveSubsystem.driveArcade(0, 0);
        intakeSubsystem.stop();
        shooterSubsystem.stop();
    }
    
}

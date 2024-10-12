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
        this.intakeMotor = intakeSubsystem.intakeMotor;
        this.beamBreaker = shooterSubsystem.beamBreaker;

    }
    
    @Override
    public void initialize() {
        
    }
    
    @Override
    public void execute() {
        driveSubsystem.driveArcade(0.5, 0);
        if (beamBreaker.get()) {
            intakeMotor.set(intakingSpeed);
        } else {
            intakeMotor.set(0);
        }
        
    }
}

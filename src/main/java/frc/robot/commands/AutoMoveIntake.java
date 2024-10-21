package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.intakingSpeed;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoMoveIntake extends Command {
    private DriveSubsystem driveSubsystem;
    private IntakeSubsystem intakeSubsystem;
    CANSparkMax intakeMotor;
    DigitalInput beamBreaker;
    
    public AutoMoveIntake(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {
        this.driveSubsystem = driveSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        intakeMotor = intakeSubsystem.intakeMotor;
    }
    
    @Override
    public void initialize() {
        
    }
    
    @Override
    public void execute() {
        driveSubsystem.driveArcade(0.5, 0);
        intakeMotor.set(intakingSpeed);
    }

    @Override
    public void end(boolean isInterrupted) {
        driveSubsystem.driveArcade(0, 0);
        intakeSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return !beamBreaker.get();
    }
    
}

package frc.robot.commands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class Spoonfeeding extends Command {
    private ShooterSubsystem shooterSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax topMotor;
    private CANSparkMax bottomMotor;
    private CANSparkMax intakeMotor;

    private RelativeEncoder topEncoder, bottomEncoder;
    
    public Spoonfeeding(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.intakeMotor = intakeSubsystem.intakeMotor;
        this.topMotor = shooterSubsystem.topShooterMotor;
        this.bottomMotor = shooterSubsystem.bottomShooterMotor;

        topEncoder = topMotor.getEncoder();
        bottomEncoder = bottomMotor.getEncoder();

    }

    @Override 
    public void initialize() {
        bottomMotor.set(0.5);
        topMotor.set(0.8);
    }

    @Override
    public void execute() {
        if (topEncoder.getVelocity() > 850 && bottomEncoder.getVelocity() > 650) {
            intakeMotor.set(0.7);
        }
    }

    @Override
    public void end(boolean isInterrupted) {
        shooterSubsystem.stop();
        intakeSubsystem.stop();
    }
}

package frc.robot.commands;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class Spoonfeeding extends Command {
    private ShooterSubsystem shooterSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax topMotor;
    private CANSparkMax bottomMotor;
    private CANSparkMax intakeMotor;
    
    public Spoonfeeding(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.intakeMotor = intakeSubsystem.intakeMotor;
        this.topMotor = shooterSubsystem.topShooterMotor;
        this.bottomMotor = shooterSubsystem.bottomShooterMotor;

    }

    @Override 
    public void initialize() {}

    @Override
    public void execute() {
        topMotor.set(1.0);
        bottomMotor.set(0.6);
        intakeMotor.set(0.9);
    }

    @Override
    public void end(boolean isInterrupted) {
        shooterSubsystem.stop();
        intakeSubsystem.stop();
    }
}

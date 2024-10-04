package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.ejectingSpeed;
import static frc.robot.Constants.ShooterConstants.kIntakeEject;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Eject extends Command {
    private IntakeSubsystem intakeSubsystem;
    private ShooterSubsystem shooterSubsystem;
    private CANSparkMax motor;
    private CANSparkMax shootTop;
    private CANSparkMax shootBottom;

    public Eject(IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.shooterSubsystem = shooterSubsystem;
        motor = intakeSubsystem.intakeMotor;
        shootTop = shooterSubsystem.topShooterMotor;
        shootBottom = shooterSubsystem.bottomShooterMotor;
    }

    @Override
    public void initialize() {
        motor.set(ejectingSpeed);
        shootTop.set(kIntakeEject);
        shootBottom.set(kIntakeEject);
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean isInterrupted) {
        intakeSubsystem.stop();
    }
}

package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.launchSpeed;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeBack extends Command {
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax motor;

    public IntakeBack(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        motor = intakeSubsystem.intakeMotor;
    }

    @Override
    public void initialize() {
        motor.set(launchSpeed);
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean isInterrupted) {
        intakeSubsystem.stop();
    }
}

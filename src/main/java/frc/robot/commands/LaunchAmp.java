package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;

public class LaunchAmp extends Command {
    ShooterSubsystem shooterSubsystem;
    Timer timer = new Timer();

    public LaunchAmp(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {
        // Prepare Launch Speaker
        shooterSubsystem.setLaunchWheel(ShooterConstants.kSpeakerAmpLauncherSpeed);

        // Timeout for 1 second
        timer.start();

        while (timer.get() < 1.0) {
            // Keep waiting until 1 second has passed 
        }
        shooterSubsystem.setLaunchWheel(ShooterConstants.kSpeakerAmpLauncherSpeed);
        shooterSubsystem.setFeedWheel(ShooterConstants.kSpeakerAmpLaunchFeederSpeed);
    }

    @Override 
    public void execute() {

    }

    @Override 
    public boolean isFinished() {
        return false;
    }

    @Override 
    public void end(boolean interrupted) {
        shooterSubsystem.stop();
    }
}

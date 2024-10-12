package frc.robot.commands;

public class Spoonfeeding extends Command {
    private ShooterSubsystem shooterSubsystem;
    private CANSparkMax topMotor;
    private CANSparkMax bottomMotor;
    
    public Spoonfeeding(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        this.topMotor = shooterSubsystem.topShooterMotor;
        this.bottomMotor = shooterSubsystem.bottomShooterMotor;

    }

    @Override 
    public void initialize() {}

    @Override
    public void execute() {
        topMotor.set(1.0);
        bottomMotor.set(0.25);
    }

    @Override
    public void end(boolean isInterrupted) {
        shooterSubsystem.stop();
    }
}

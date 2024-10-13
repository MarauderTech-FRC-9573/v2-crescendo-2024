package frc.robot.subsystems;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import static frc.robot.Constants.DriveConstants.*;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.Volts;
// Simulation libraries
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;


/* This class declares the subsystem for the robot drivetrain if controllers are connected via CAN. Make sure to go to
* RobotContainer and uncomment the line declaring this subsystem and comment the line for PWMDrivetrain.
*
* The subsystem contains the objects for the hardware contained in the mechanism and handles low level logic
* for control. Subsystems are a mechanism that, when used in conjuction with command "Requirements", ensure
* that hardware is only being used by 1 command at a time.
*/
public class DriveSubsystem extends SubsystemBase {
    /*Class member variables. These variables represent things the class needs to keep track of and use between
    different method calls. */
    DifferentialDrive m_drivetrain;
    
    public static final double kMaxSpeed = 3.0; // meters per second
    public static final double kMaxAngularSpeed = 2 * Math.PI; // radians per second
    private static final double kTrackWidth = 0.381 * 2; // meters UPDATE THIS VALUE
    private static final double kWheelRadius = 0.0507; // meters
    private static final int kEncoderResolution = 4096; // encoder ticks per revolution UPDATE THIS VALUE
    
    private final CANSparkMax leftFront = new CANSparkMax(kLeftFrontID, CANSparkLowLevel.MotorType.kBrushed);
    private final CANSparkMax leftRear = new CANSparkMax(kLeftRearID, CANSparkLowLevel.MotorType.kBrushed);
    private final CANSparkMax rightFront = new CANSparkMax(kRightFrontID, CANSparkLowLevel.MotorType.kBrushed);
    private final CANSparkMax rightRear = new CANSparkMax(kRightRearID, CANSparkLowLevel.MotorType.kBrushed);
    
    private DigitalSource[] kLeftLeadEncoderPorts;
    
    private final Encoder driveLeftEncoder = new Encoder(5, 6);
    private final Encoder driveRightEncoder = new Encoder(7, 8);
    
    private final PIDController m_leftPIDController = new PIDController(1, 0, 0);
    private final PIDController m_rightPIDController = new PIDController(1, 0, 0);
    
    private final DifferentialDriveKinematics m_kinematics = new DifferentialDriveKinematics(kTrackWidth);
    
    // private final DifferentialDriveOdometry m_odometry;
    
    // Gains are for example purposes only - must be determined for your own robot!
    private final SimpleMotorFeedforward m_feedforward = new SimpleMotorFeedforward(1, 3);
    
    // Gyroscope
    private final ADXRS450_Gyro m_gyro = new ADXRS450_Gyro();
    
    Pose2d m_pose;
    
    /*Constructor. This method is called when an instance of the class is created. This should generally be used to set up
    * member variables and perform any configuration or set up necessary on hardware.
    */
    public DriveSubsystem() {
        leftFront.setSmartCurrentLimit(kDriveCurrentLimit);
        leftRear.setSmartCurrentLimit(kDriveCurrentLimit);
        rightFront.setSmartCurrentLimit(kDriveCurrentLimit);
        rightRear.setSmartCurrentLimit(kDriveCurrentLimit);
        
        // Set the rear motors to follow the front motors.
        leftRear.follow(leftFront);
        rightRear.follow(rightFront);
        
        // Invert the left side so both side drive forward with positive motor outputs
        leftFront.setInverted(false);
        rightFront.setInverted(true);

        
        // Put the front motors into the differential drive object. This will control all 4 motors with
        // the rears set to follow the fronts
        m_drivetrain = new DifferentialDrive(leftFront, rightFront);
        m_drivetrain.setSafetyEnabled(false);
        
        // m_odometry =
        // new DifferentialDriveOdometry(
        //     m_gyro.getRotation2d(), driveLeftEncoder.getDistance(), driveRightEncoder.getDistance());
        
        m_drivetrain.setMaxOutput(DriveConstants.defaultSpeed);
    }
    
    boolean isStopped = false;
    
    /*Method to control the drivetrain using arcade drive. Arcade drive takes a speed in the X (forward/back) direction
    * and a rotation about the Z (turning the robot about it's center) and uses these to control the drivetrain motors */
    public void driveArcade(double speed, double rotation) {
        m_drivetrain.arcadeDrive(speed, rotation);
    }
    
    /** 
    * Drives the robot with the given linear velocity and angular velocity
    */
    // public void drive(double speed, double rotation) {
        //     var wheelSpeeds = m_kinematics.toWheelSpeeds(new ChassisSpeeds(speed, 0.0, rotation));
        //     setSpeeds(wheelSpeeds);
        // }
        
        
        @Override
        public void periodic() {
            
            // Get the rotation of the robot from the gyro.
            var gyroAngle = m_gyro.getRotation2d();
            
            SmartDashboard.putNumber("Left Encoder Value: ", driveLeftEncoder.getDistance());
            SmartDashboard.putNumber("Right Encoder Value: ", driveRightEncoder.getDistance());
            
            // Update the pose
            // m_pose = m_odometry.update(gyroAngle,
            // driveLeftEncoder.getDistance(),
            // driveRightEncoder.getDistance());
            // SmartDashboard.putNumber("Gyro ", this.getHeading());
            
        }
        
            
            public double getHeading() {
                return Math.IEEEremainder(m_gyro.getAngle(), 360) * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
            }
            
            public void zeroHeading() {
                
                m_gyro.reset();
                
            }
            
            public void setMaxOutput(double maxOutput) {
                
                m_drivetrain.setMaxOutput(maxOutput);
                
            }
            
            public double getTurnRate() {
                
                return m_gyro.getRate() * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
                
            }
            
            public void driveSet(int setpoint) {
                leftFront.set(m_leftPIDController.calculate(driveLeftEncoder.getDistance(),setpoint));
                rightFront.set(m_rightPIDController.calculate(driveRightEncoder.getDistance(), setpoint));
            }
            }
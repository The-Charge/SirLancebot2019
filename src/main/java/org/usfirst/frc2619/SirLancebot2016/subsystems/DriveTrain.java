// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SirLancebot2016.subsystems;


import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.TheChargeDashboard;
import org.usfirst.frc2619.SirLancebot2016.Robot;
import org.usfirst.frc2619.SirLancebot2016.RobotMap;
import org.usfirst.frc2619.SirLancebot2016.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    private final WPI_TalonSRX leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    private final WPI_TalonSRX rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final WPI_TalonSRX rightRearMotor = RobotMap.driveTrainRightRearMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public final static double DRIVETRAIN_SPEED_P_CONSTANT = .2;
	private final static double DRIVETRAIN_SPEED_I_CONSTANT = .001;
	private final static double DRIVETRAIN_SPEED_D_CONSTANT = 0;
	private final static double DRIVETRAIN_SPEED_F_CONSTANT = .1;

	public final static double DRIVETRAIN_POSITION_P_CONSTANT = 1.1;
	private final static double DRIVETRAIN_POSITION_I_CONSTANT = .0001;
	private final static double DRIVETRAIN_POSITION_D_CONSTANT = 0;

	private final static double DRIVETRAIN_SPEED_DEADBAND_CONSTANT = 50;
	private final static double DRIVETRAIN_POSITION_DEADBAND_CONSTANT = 300;

	private final static int PID_PROFILE_SPEED = 0;
	private final static int PID_PROFILE_POSITION = 1;

	private final static double TICKSPERFOOT = 4314.5;
	private final static double MAX_TICKS_PER_SECOND = 8300;

	private final double DEFAULT_DEADBANDX = .15;
	private final double DEFAULT_DEADBANDY = .15;
	private final double DEFAULT_DEADBANDZ = .15;
	private final double DEFAULT_DELIN_POWER = 1;

	private final static double DEFAULT_AIM_DISTANCE_SPEED = .15;
	private final static double DEFAULT_AIM_ANGLE_SPEED = .175;
	private final static double DISTANCE_GAIN = .02;
	private final static double ANGLE_GAIN = .015;
	
	private static double AimDistanceSpeed = DEFAULT_AIM_DISTANCE_SPEED;
	private static double AimAngleSpeed = DEFAULT_AIM_ANGLE_SPEED;
	private static double DistanceGain = DISTANCE_GAIN;
	private static double AngleGain = ANGLE_GAIN;

	public double speedMode = 1;
	

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public DriveTrain() {
		writeDefaultDashboardValues();

		// Needed for Competition Bot,  comment out for plybot 
		leftFrontMotor.setInverted(true);
		rightFrontMotor.setInverted(true);
	}

	private void writeDefaultDashboardValues() {
		// put PID numbers on smart dashboard

		TheChargeDashboard.putNumber("DriveTrainSpeedP",
				DRIVETRAIN_SPEED_P_CONSTANT);
		TheChargeDashboard.putNumber("DriveTrainSpeedI",
				DRIVETRAIN_SPEED_I_CONSTANT);
		TheChargeDashboard.putNumber("DriveTrainSpeedD",
				DRIVETRAIN_SPEED_D_CONSTANT);
		TheChargeDashboard.putNumber("DriveTrainSpeedF",
				DRIVETRAIN_SPEED_F_CONSTANT);

		TheChargeDashboard.putNumber("DriveTrainSpeedDeadband",
				DRIVETRAIN_SPEED_DEADBAND_CONSTANT);

		TheChargeDashboard.putNumber("DriveTrainPositionP",
				DRIVETRAIN_POSITION_P_CONSTANT);
		TheChargeDashboard.putNumber("DriveTrainPositionI",
				DRIVETRAIN_POSITION_I_CONSTANT);
		TheChargeDashboard.putNumber("DriveTrainPositionD",
				DRIVETRAIN_POSITION_D_CONSTANT);

		TheChargeDashboard.putNumber("DriveTrainPositionDeadband",
				DRIVETRAIN_POSITION_DEADBAND_CONSTANT);

		// Joystick Deadband Values
		TheChargeDashboard.putNumber("DeadbandY", DEFAULT_DEADBANDY);
		TheChargeDashboard.putNumber("DeadbandX", DEFAULT_DEADBANDX);
		TheChargeDashboard.putNumber("DeadbandZ", DEFAULT_DEADBANDZ);
		TheChargeDashboard.putNumber("DelinPower", DEFAULT_DELIN_POWER);

		TheChargeDashboard.putNumber("AutonDistance", 3);
		TheChargeDashboard.putNumber("AutonSpeed", .5);
		TheChargeDashboard.putNumber("AutonDegrees", 54);
		
		TheChargeDashboard.putNumber("AimDistanceSpeed", AimDistanceSpeed);
		TheChargeDashboard.putNumber("AimAngleSpeed", AimAngleSpeed);
		TheChargeDashboard.putNumber("AimDistanceGain", DistanceGain);
		TheChargeDashboard.putNumber("AimAngleGain", AngleGain);
	}

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveCG());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setLeftPercentVBus(double percentvbus) {
		leftFrontMotor.set(percentvbus);
	}

	public void setRightPercentVBus(double percentvbus) {
		rightFrontMotor.set(percentvbus);
	}

	public void setLeftSpeedPercentage(double percentspeed) {
		leftFrontMotor.set(percentspeed * MAX_TICKS_PER_SECOND);
	}

	public void setRightSpeedPercentage(double percentspeed) {
		rightFrontMotor.set(percentspeed * MAX_TICKS_PER_SECOND);
	}

	public void initSpeedPercentageMode() {
		setControlMode(ControlMode.Velocity);
		readDashboardControlValues();
		setProfile(PID_PROFILE_SPEED);

		leftFrontMotor.configNominalOutputForward(1, RobotMap.TIMEOUT_MS);
		rightFrontMotor.configNominalOutputForward(1, RobotMap.TIMEOUT_MS);
		
		leftFrontMotor.configNominalOutputReverse(-1, RobotMap.TIMEOUT_MS);
		rightFrontMotor.configNominalOutputReverse(-1, RobotMap.TIMEOUT_MS);
	}

	public void initPercentVBusMode() {
		setControlMode(ControlMode.PercentOutput);
		readDashboardControlValues();

		leftFrontMotor.configNominalOutputForward(1, RobotMap.TIMEOUT_MS);
		rightFrontMotor.configNominalOutputForward(1, RobotMap.TIMEOUT_MS);
		
		leftFrontMotor.configNominalOutputReverse(-1, RobotMap.TIMEOUT_MS);
		rightFrontMotor.configNominalOutputReverse(-1, RobotMap.TIMEOUT_MS);
	}

	//public void initPositionMode() {
		//setControlMode(ControlMode.Position);
		//readDashboardControlValues();
		//setProfile(PID_PROFILE_POSITION);

		// clear the accumulated I value in the PIDs
		//leftFrontMotor.ClearIaccum();
		//rightFrontMotor.ClearIaccum();

		//leftFrontMotor.configNominalOutputForward(SmartDashboard
			//	.getNumber("AutonSpeed", 0), RobotMap.TIMEOUT_MS);
		//rightFrontMotor.configNominalOutputForward(SmartDashboard
		//		.getNumber("AutonSpeed", 0), RobotMap.TIMEOUT_MS);
	//}

	public void setLeftPostionFeet(double feet) {
		leftFrontMotor.set(feet);
	}

	public void setRightPostionFeet(double feet) {
		rightFrontMotor.set(feet);
	}

	private void setProfile(int profile) {
		leftFrontMotor.selectProfileSlot(profile, 0);
		rightFrontMotor.selectProfileSlot(profile, 1);
	}

	private void setControlMode(ControlMode velocity) {
		// setContronlMode
		leftFrontMotor.set(ControlMode.Velocity, RobotMap.TIMEOUT_MS);
		leftFrontMotor.set(ControlMode.Velocity, RobotMap.TIMEOUT_MS);
	}

	private void zeroEncoders() {
		// zero encoders
		leftFrontMotor.setSelectedSensorPosition(0, 0, RobotMap.TIMEOUT_MS);
		rightFrontMotor.setSelectedSensorPosition(0, 0, RobotMap.TIMEOUT_MS);
	}

	/**
	 * if send true, turns on brake mode if send false, turns off brake mode
	 * 
	 * @param brakeMode
	 */
	public void brakeModeOn(boolean brakeMode) {
		// .enableBrakeMode(true) = brake mode on
		// .enableBrakeMode(false) = brake mode off
		//leftFrontMotor.setNeutralMode();
		//rightFrontMotor.enableBrakeMode(brakeMode);
	}

	// ---------------------methods for DriveXFeet command------------------------------------
	public void setDistanceTarget(double distanceInFeet) {
		zeroEncoders();

		double distanceInTicks = distanceInFeet * TICKSPERFOOT;

		// set distance
		leftFrontMotor.set(distanceInTicks);
		rightFrontMotor.set(-1 * distanceInTicks);
	}

	private void readDashboardControlValues() {

		setProfile(PID_PROFILE_POSITION);

		// set PID variables
		double driveTrainPositionP = SmartDashboard.getNumber(
				"DriveTrainPositionP", DRIVETRAIN_POSITION_P_CONSTANT);
		double driveTrainPositionI = SmartDashboard.getNumber(
				"DriveTrainPositionI", DRIVETRAIN_POSITION_I_CONSTANT);
		double driveTrainPositionD = SmartDashboard.getNumber(
				"DriveTrainPositionD", DRIVETRAIN_POSITION_D_CONSTANT);

		// set CANTalon PIDs
		//leftFrontMotor.setPID(driveTrainPositionP, driveTrainPositionI,
			//	driveTrainPositionD);
		//rightFrontMotor.setPID(driveTrainPositionP, driveTrainPositionI,
			//	driveTrainPositionD);
		
		leftFrontMotor.config_kP(0, driveTrainPositionP, RobotMap.TIMEOUT_MS);
		leftFrontMotor.config_kI(0, driveTrainPositionI, RobotMap.TIMEOUT_MS);
		leftFrontMotor.config_kD(0, driveTrainPositionD, RobotMap.TIMEOUT_MS);
		
		rightFrontMotor.config_kP(0, driveTrainPositionP, RobotMap.TIMEOUT_MS);
		rightFrontMotor.config_kI(0, driveTrainPositionI, RobotMap.TIMEOUT_MS);
		rightFrontMotor.config_kD(0, driveTrainPositionD, RobotMap.TIMEOUT_MS);

		setProfile(PID_PROFILE_SPEED);

		// set PID variables
		double driveTrainSpeedP = SmartDashboard.getNumber("DriveTrainSpeedP",
				DRIVETRAIN_SPEED_P_CONSTANT);
		double driveTrainSpeedI = SmartDashboard.getNumber("DriveTrainSpeedI",
				DRIVETRAIN_SPEED_I_CONSTANT);
		double driveTrainSpeedD = SmartDashboard.getNumber("DriveTrainSpeedD",
				DRIVETRAIN_SPEED_D_CONSTANT);
		double driveTrainSpeedF = SmartDashboard.getNumber("DriveTrainSpeedF",
				DRIVETRAIN_SPEED_F_CONSTANT);

		// set CANTalon PIDs
		//leftFrontMotor.setPID(driveTrainSpeedP, driveTrainSpeedI,
			//	driveTrainSpeedD, driveTrainSpeedF, 0, 0, PID_PROFILE_SPEED);
		//rightFrontMotor.setPID(driveTrainSpeedP, driveTrainSpeedI,
			//	driveTrainSpeedD, driveTrainSpeedF, 0, 0, PID_PROFILE_SPEED);
		
		leftFrontMotor.config_kP(0, driveTrainSpeedP, RobotMap.TIMEOUT_MS);
		leftFrontMotor.config_kI(0, driveTrainSpeedI, RobotMap.TIMEOUT_MS);
		leftFrontMotor.config_kD(0, driveTrainSpeedD, RobotMap.TIMEOUT_MS);
		leftFrontMotor.config_kF(0, driveTrainSpeedF, RobotMap.TIMEOUT_MS);
		
		rightFrontMotor.config_kP(0, driveTrainSpeedP, RobotMap.TIMEOUT_MS);
		rightFrontMotor.config_kI(0, driveTrainSpeedI, RobotMap.TIMEOUT_MS);
		rightFrontMotor.config_kD(0, driveTrainSpeedD, RobotMap.TIMEOUT_MS);
		rightFrontMotor.config_kF(0, driveTrainSpeedF, RobotMap.TIMEOUT_MS);
	}

	//public void writeDashboardDebugValues() {
		// Output of Current Encoder Values:
		//TheChargeDashboard.putNumber("LeftFrontEncoder",
				//leftFrontMotor.pidGet());
		//TheChargeDashboard.putNumber("RightFrontEncoder",
			//	rightFrontMotor.pidGet());

		// Output of Desired Setpoint
		//TheChargeDashboard.putNumber("LeftFrontSetDist",
			//	leftFrontMotor.getSetpoint());
		//TheChargeDashboard.putNumber("RightFrontSetDist",
		//		leftFrontMotor.getSetpoint());

		// Output Speed of Encoders
		//TheChargeDashboard.putNumber("LeftFrontSpeed",
			//	leftFrontMotor.getEncVelocity());
		//TheChargeDashboard.putNumber("RightFrontSpeed",
		//		rightFrontMotor.getEncVelocity());
	//}

	//public boolean atTarget() {
		// setting variables to determine atTarget-ness
		//double leftFrontCurrentValue = leftFrontMotor.pidGet();
		//double leftFrontDesiredValue = leftFrontMotor.getSetpoint();
		//double leftFrontError = Math.abs(leftFrontDesiredValue
			//	- leftFrontCurrentValue); // all these are in ticks
		//double rightFrontCurrentValue = rightFrontMotor.pidGet();
		//double rightFrontDesiredValue = rightFrontMotor.getSetpoint();
		//double rightFrontError = Math.abs(rightFrontDesiredValue
			//	- rightFrontCurrentValue);

		//double acceptableError = 250; // in ticks

		// check if any of the PIDs in the CANTalons are close enough to the
		// acceptableError

		//if ((leftFrontError < acceptableError) || (rightFrontError < acceptableError))
			//return true;
		//else
			//return false;
	//}

	// -------------------- methods for TurnNDegrees ------------------------------------
	public double zeroTo360Angle(double angle)
	{
		while (angle < 0) {
			angle += 360;
		}
		while (angle >= 360) {
			angle -= 360;
		}
		
		return angle;
	}
	
	/*public double turnToAbsoluteAngle(double current_position, double degrees, double speed)
	{
		// change speed once it gets close
		if (Math.abs(degrees - current_position) <= 20) {
			speed = .4;
		}
		if (Math.abs(degrees - current_position) <= 10) {
			speed = .24;
			TheChargeDashboard.putNumber("TurnSpeed", speed);
		}
				
		if (MathUtil.calcDirection(current_position, degrees) > 0) // shortest way clockwise
		{
			TheChargeDashboard.putNumber("TurnSpeed", speed);
			Robot.driveTrain.setLeftPercentVBus(speed);
			Robot.driveTrain.setRightPercentVBus(-speed);
		} 
		else {
			TheChargeDashboard.putNumber("TurnSpeed", speed);
			Robot.driveTrain.setLeftPercentVBus(-speed);
			Robot.driveTrain.setRightPercentVBus(speed);
		}
		
		return (Robot.gyroSubsystem.ahrs.getAngle());
	}
	*/
	
	//public boolean atAbsoluteAngle(double degrees, double error)
	//{
		//if ((Math.abs(Robot.gyroSubsystem.ahrs.getAngle() - degrees)) <= error) {
			//return true;
		//} 
		//else
			//return false;
	//}
	
	public void disablePID() {
		setControlMode(ControlMode.PercentOutput);
	}

	/*
	public void autoPosition() // For AutoAimHorizontal
	{
		setLeftPercentVBus(motorSpeedCalcDis() + motorSpeedCalcAng());
		setRightPercentVBus(motorSpeedCalcDis() - motorSpeedCalcAng()*1);
		//setRightSpeedPercentage(motorSpeedCalcDis());
	}
	*/

	/*double motorSpeedCalcDis() {
		if (!Robot.cameraSubsystem.onDistanceTarget()) // not on target
			if (Robot.cameraSubsystem.getDistance() > Robot.cameraSubsystem.OPTIMAL_DISTANCE) // too far away
				return ((Robot.cameraSubsystem.getDistance() - Robot.cameraSubsystem.OPTIMAL_DISTANCE) * DISTANCE_GAIN)
						+ DEFAULT_AIM_DISTANCE_SPEED;
			else  // too close
				return ((Robot.cameraSubsystem.getDistance() - Robot.cameraSubsystem.OPTIMAL_DISTANCE) * DISTANCE_GAIN)
						- DEFAULT_AIM_DISTANCE_SPEED;
		else  // on target
			return 0.0;
	}
	*/

	/*
	double motorSpeedCalcAng() {
		if (!Robot.cameraSubsystem.onAngleTarget()) // not on target
			if (Robot.cameraSubsystem.getTargetXRotation() > 0.0) // turn right
				return (Robot.cameraSubsystem.getTargetXRotation() * ANGLE_GAIN) *
						((Robot.cameraSubsystem.OPTIMAL_DISTANCE*Robot.cameraSubsystem.OPTIMAL_DISTANCE) / 
						(Robot.cameraSubsystem.getDistance()*Robot.cameraSubsystem.getDistance()))
						+ DEFAULT_AIM_ANGLE_SPEED;
			else  // turn left
				return (Robot.cameraSubsystem.getTargetXRotation() * ANGLE_GAIN) *
						((Robot.cameraSubsystem.OPTIMAL_DISTANCE*Robot.cameraSubsystem.OPTIMAL_DISTANCE) / 
						(Robot.cameraSubsystem.getDistance()*Robot.cameraSubsystem.getDistance()))
						- DEFAULT_AIM_ANGLE_SPEED;
		else  // on target
			return 0.0;
	}
	*/
	
	public void readAndWriteAutoTuningConstants()
	{
		AimDistanceSpeed = SmartDashboard.getNumber("AimDistanceSpeed", DEFAULT_AIM_DISTANCE_SPEED);
		AimAngleSpeed = SmartDashboard.getNumber("AimAngleSpeed", DEFAULT_AIM_ANGLE_SPEED);
		DistanceGain = SmartDashboard.getNumber("AimDistanceGain", DISTANCE_GAIN);
		AngleGain = SmartDashboard.getNumber("AimAngleGain", ANGLE_GAIN);
		
		TheChargeDashboard.putNumber("AimDistanceSpeed", AimDistanceSpeed);
		TheChargeDashboard.putNumber("AimAngleSpeed", AimAngleSpeed);
		TheChargeDashboard.putNumber("AimDistanceGain", DistanceGain);
		TheChargeDashboard.putNumber("AimAngleGain", AngleGain);
	}

	public void fullSpeedMode()
	{
		 speedMode = 1;
	}
	public void halfSpeedMode()
	{
		 speedMode = 0.5;
	}
	public void quarterSpeedMode()
	{
		 speedMode = 0.25;
	}
}

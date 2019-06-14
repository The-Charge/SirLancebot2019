// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SirLancebot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2619.SirLancebot2016.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 *
 */
public abstract class DriveBase extends Command {
	protected double deadbandY = .15;
	protected double deadbandX = .15;
	protected double deadbandZ = .15;
	protected int power;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	private ControlMode currentControlMode;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public DriveBase() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

	}

	// Called just before this Command runs the first time
	protected void initialize() {

		//Robot.driveTrain.writeDashboardDebugValues();
		Robot.driveTrain.readAndWriteAutoTuningConstants();

		//currentControlMode = (ControlMode) Robot.oi.loopMode.getSelected();

		//if (currentControlMode == ControlMode.Velocity) {
		//	Robot.driveTrain.initSpeedPercentageMode();
		//} else {
			Robot.driveTrain.initPercentVBusMode();
		//}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		deadbandY = SmartDashboard.getNumber("DeadbandY", 0.1);
		deadbandX = SmartDashboard.getNumber("DeadbandX", 0.1);
		deadbandZ = SmartDashboard.getNumber("DeadbandZ", 0.1);
		power = (int) SmartDashboard.getNumber("DelinPower", 1);

		double leftspeed = getLeft();
		double rightspeed = getRight();

		//if (currentControlMode == ControlMode.Velocity) {
		//	Robot.driveTrain.setLeftSpeedPercentage(leftspeed);
		//	Robot.driveTrain.setRightSpeedPercentage(rightspeed);
		//} else {
			Robot.driveTrain.setLeftPercentVBus(leftspeed);
			Robot.driveTrain.setRightPercentVBus(rightspeed);
		//}

		//Robot.driveTrain.writeDashboardDebugValues();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//return  Robot.oi.loopMode.getSelected() != currentControlMode;
		end();
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.setLeftPercentVBus(0);
		Robot.driveTrain.setRightPercentVBus(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

	protected abstract double getLeft();

	protected abstract double getRight();

}

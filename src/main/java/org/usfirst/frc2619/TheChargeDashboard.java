package org.usfirst.frc2619;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TheChargeDashboard {

	private static String[] whiteList = {
			// /*DriveTrainSpeed*/ "DriveTrainSpeedP", "DriveTrainSpeedI",
			// "DriveTrainSpeedD", "DriveTrainSpeedF",
			// "DriveTrainSpeedDeadband",
			// /*DriveTrainPosition*/ "DriveTrainPositionP",
			// "DriveTrainPositionI", "DriveTrainPositionD",
			// "DriveTrainPositionDeadband",
			/* DriveTrainEncoders */"LeftFrontEncoder", "RightFrontEncoder",
			//"LeftFrontSpeed", "RightFrontSpeed",
			/* DriveTrainDeadband */
			//"DeadbandY", /* "DeadbandX", "DeadbandZ", */ "DelinPower",
			/* DriveTrainAuon */"AutonDistance", "AutonSpeed","AutonDegrees",
			///* CamaraSubsystem */"Distance", "xRotationAngle","TargetVisable", "BLOB_COUNT", "IMAGE_COUNT", "IS_VISION_RUNNING",
			//"onTarget", "onAngleTarget", "onDistanceTarget", "OptimalDistance", "DistanceDeadband", "TurnSpeed",
			///* Blinky Lights */ "LightSpike", "LEDState", "BallSensor", "Hasball", "hasBallBool", "ShooterUp",
			/* GyroSubsystem */"IMU_TotalYaw",
			//"IMU_Roll",
			//"IMU_Pitch",
			// /*IntakeArms*/ "IntakeArmsSpeed", "IntakePercentSpeed",
			// /*Shooter*/ "ShooterSpeedP", "ShooterSpeedI", "ShooterSpeedD",
			// "ShooterSpeedF", "ShooterSpeed",
			//"ShooterLeftSpeed", "ShooterRightSpeed",// "Shooter SetPoint", "ShooterMotorsOn",
			// "ShooterMotorsForward", "ShooterUp",
			// /*Collector*/ "Feed Roller Forward Speed",
			// "Feed Roller Reverse Speed", "Center Roller Forward Speed",
			// "Center Roller Reverse Speed"
			/* Auton Bools */"AutonShiftHigh", "AutonArmsDown", "AutonPivotDown", 
			///* AutoAim Tuning Constants */ "AimDistanceSpeed", "AimAngleSpeed", "AimDistanceGain", "AimAngleGain"
			};

	public static void putNumber(String key, double value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putNumber(key, value);
			}
		}
	}

	public static void putBoolean(String key, boolean value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putBoolean(key, value);
			}
		}
	}

	public static void putString(String key, String value) {
		for (int x = 0; x < whiteList.length; x++) {
			if (key.equals(whiteList[x])) {
				SmartDashboard.putString(key, value);
			}
		}
	}
}

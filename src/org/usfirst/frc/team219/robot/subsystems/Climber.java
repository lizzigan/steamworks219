package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;
import org.usfirst.frc.team219.robot.commands.ClimbUp;

import com.ctre.phoenix.motorcontrol.can.TalonSRX; import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is the climber subsystem for Team 219's 2017 robot.
 */
public class Climber extends Subsystem 
{	
	private TalonSRX climberMotor;
	
	public Climber() 
	{
		climberMotor = new TalonSRX(RobotMap.CLIMBERMOTOR_PORT);
	}
	
    public void initDefaultCommand() {
    }
    
    /**
     * Starts the climber motor and also puts info onto smart dashboard.
     */
    public void startClimbing()
    {
    	climberMotor.set(ControlMode.PercentOutput,1);
    	SmartDashboard.putString("Climber", "Climbing");
    }
    
    /**
     * Sets the climber motor to go in reverse and also puts info onto smart dashboard.
     */
    public void comeDown() 
    {
    	climberMotor.set(ControlMode.PercentOutput,-1);
    	SmartDashboard.putString("Climber", "Descending");
    }
    
    /**
     * Stops the climber motor completely.
     */
	public void stopMotor() {
		climberMotor.set(ControlMode.PercentOutput,0);
    	SmartDashboard.putString("Climber", "Stopped");
	}
}


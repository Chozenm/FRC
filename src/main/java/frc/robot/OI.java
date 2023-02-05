package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
    public XboxController C1 = new XboxController(Constants.controller1);
    public XboxController C2 = new XboxController(Constants.controller2);


    public double GetDriverRawAxis(int Axis){
       return C1.getRawAxis(Axis);
      }

     
      
     
}

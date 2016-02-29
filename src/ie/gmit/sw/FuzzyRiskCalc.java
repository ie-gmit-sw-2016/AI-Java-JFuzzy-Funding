package ie.gmit.sw;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyRiskCalc {
	public static void main(String[] args) {
		FIS fis = FIS.load("fcl/funding.fcl", true); //Load and parse the FCL
		
		//Display the linguistic variables and terms
		FunctionBlock functionBlock = fis.getFunctionBlock("Project");
		JFuzzyChart.get().chart(functionBlock);
		
		fis.setVariable("funding", 60); //Apply a value to a variable
		fis.setVariable("staffing", 5);
		fis.evaluate(); //Execute the fuzzy inference engine
		System.out.println(fis.getVariable("risk").getValue()); //Output end result
	}
}

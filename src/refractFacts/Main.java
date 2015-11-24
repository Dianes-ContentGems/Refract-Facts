package refractFacts;

import java.util.Scanner;

public class Main 
{
	public static void main(String args[])
	{	
		Scanner in = new Scanner(System.in);
		
		double d, h, x, n1, n2;
		
		d = in.nextDouble();
		while(d != 0)
		{
			h = in.nextDouble();
			x = in.nextDouble();
			n1 = in.nextDouble();
			n2 = in.nextDouble();
			
			double solution = bruteTheSolution(d,h,x,n1,n2);
			System.out.printf("%.02f",solution);
			
			d = in.nextDouble();
		}
		
		
		
	}
	
	private static double bruteTheSolution(double d, double h, double x, double n1, double n2)
	{
		double solutionAngle = 0;
		double minError = Double.MAX_VALUE;
		
		for(double angle = 0;angle <= 90; angle+=.01)
		{
			double radianAngle = angle*(Math.PI/180);
			double lhs = n1/n2;
			
			double tanAngle = Math.tan(radianAngle);
			
			double p1 = d/tanAngle;
			double p2 = Math.sqrt(Math.pow((x-d/tanAngle),2)+(h*h));
			double numerator = p1*p2;
			
			p1 = Math.sqrt((d*d)/(tanAngle*tanAngle)+(d*d));
			p2 = (x-d/tanAngle);
			
			double denominator = p1*p2;
			
			double rhs = numerator/denominator;
			
			double error = Math.abs(lhs-rhs);

			if(error < minError)
			{
				solutionAngle = angle;
				minError = error;
			}
		}
		return solutionAngle;
	}

}

import java.util.Scanner;
import java.io.*;
import java.util.Formatter;

public class Project2
{
	public static void main(String[] args) throws IOException
	{
		int count = 0;
		int commandcount;
		int decimalplaces = 3;
		String tossOut;
		String operation;
		String operator;
		double data1;
		double data2;
		Scanner fileScan, operationScan;

		//opens and read and stores the first line of the file in a variable
		fileScan = new Scanner(new File("calculator.txt"));
		commandcount = fileScan.nextInt();
		tossOut = fileScan.nextLine();
		
		//while loop that continues based on the first number read from the file
		while (count < commandcount)
		{
			//stores each line in a variable and then each part of each line (separated by a space) in another variable
			operation = fileScan.nextLine();
			operationScan = new Scanner(operation);
			operator = operationScan.next();

			//series of command options that are performed based on the first character that is read from each line in the file
			if (operator.equals("+"))
			{
				Formatter fmt1 = new Formatter();
				data1 = operationScan.nextDouble();
				data2 = operationScan.nextDouble();
				double addition = data1 + data2;
				fmt1.format("%" + "." + decimalplaces + "f", addition);
				System.out.println(operation + " = " + fmt1);
			}
			if (operator.equals("-"))
			{
				Formatter fmt2 = new Formatter();
				data1 = operationScan.nextDouble();
				data2 = operationScan.nextDouble();
				double subtraction = data1 - data2;
				fmt2.format("%" + "." + decimalplaces + "f", subtraction);
				System.out.println(operation + " = " + fmt2);
			}
			if (operator.equals("*"))
			{
				Formatter fmt3 = new Formatter();
				data1 = operationScan.nextDouble();
				data2 = operationScan.nextDouble();
				double multiplication = data1 * data2;
				fmt3.format("%" + "." + decimalplaces + "f", multiplication);
				System.out.println(operation + " = " + fmt3);
			}
			if (operator.equals("/"))
			{
				Formatter fmt4 = new Formatter();
				data1 = operationScan.nextDouble();
				data2 = operationScan.nextDouble();
				double division = data1 / data2;
				fmt4.format("%" + "." + decimalplaces + "f", division);
				System.out.println(operation + " = " + fmt4);
			}
			if (operator.equals("%"))
			{
				int remainderdata1 = operationScan.nextInt();
				int remainderdata2 = operationScan.nextInt();
				int remainder = remainderdata1 % remainderdata2;
				System.out.println(operation + " = " + remainder);
			}
			if (operator.equals("cube"))
			{
				Formatter fmt5 = new Formatter();
				data1 = operationScan.nextDouble();
				double cube = Math.pow(data1, 3);
				fmt5.format("%" + "." + decimalplaces + "f", cube);
				System.out.println(operation + " = " + fmt5);
			}
			if (operator.equals("sqrt"))
			{
				Formatter fmt6 = new Formatter();
				data1 = operationScan.nextDouble();
				double sqrt = Math.sqrt(data1);
				fmt6.format("%" + "." + decimalplaces + "f", sqrt);
				System.out.println(operation + " = " + fmt6);
			}
			if (operator.equals("n!"))
			{
				long factorial = operationScan.nextInt();
				for (long i = (factorial - 1); i >= 1; i--) 
				{
            		factorial *= i;
        		}
        		System.out.println(operation + " = " + factorial);
			}
			//returns the result of raising one data value to the power of another data value
			if (operator.equals("pow"))
			{
				Formatter fmt7 = new Formatter();
				data1 = operationScan.nextDouble();
				data2 = operationScan.nextDouble();
				double pow = Math.pow(data1, data2);
				fmt7.format("%" + "." + decimalplaces + "f", pow);
				System.out.println(operation + " = " + fmt7);
			}
			//returns the largest number in a group of values
			if (operator.equals("max"))
			{
				int maxint = Integer.MIN_VALUE;
				int minint = Integer.MAX_VALUE;
				int totvalues;
				int values;

				totvalues = operationScan.nextInt();

				for(int i = 1; i <= totvalues; i++) 
 				{
 					values = operationScan.nextInt(); 
 					if (values >= maxint) 
 					{ 
 						maxint = values;
  					} 
 					if (values <= minint) 
 					{
  						minint = values;
					}
 				} 
				System.out.println(operation + " = " + maxint); 
			}
			//sets the precision of the above calculations (exclduing the "n!" and the "max") to the read value
			if (operator.equals("precision"))
			{
				decimalplaces = operationScan.nextInt();
			}		
			count++;
		}
	}
}
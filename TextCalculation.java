/** TextCalculation
 *
 * @author BinHong Lee
 * @version 1.0 Dec 18, 2016.
 */
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class TextCalculation
{
  public static void main(String[] args) throws IOException
  {
    File file = new File(args[0]);
    BufferedReader buffer = new BufferedReader(new FileReader(file));

    String line = null;

    while((line = buffer.readLine()) != null)
    {
      //Splitting each separate word into separate string and store them in an array
      String[] inputs = line.split(" ");

      //Declaring all needed ArrayList
      List<String> tempStringList = new ArrayList();
      List<Integer> numbers = new ArrayList();
      List<Character> expressions = new ArrayList();

      //Initializing counter
      int counter = 0;

      //Loop until all the strings for the row are interpreted
      while (counter < inputs.length)
      {
        //Initialize negativity as false
        boolean negative = false;

        //Check if the next number is negative
        if (inputs[counter].equals("negative"))
        {
          negative = true;
          counter++;
        }

        //Loop through the number
        while (counter < inputs.length && !isExpression(inputs[counter]))
        {
          tempStringList.add(inputs[counter]);
          counter++;
        }

        //Get the number and put it into the array list
        numbers.add(toWholeNumber(tempStringList));

        //Check if it is supposed to be negative
        if (negative)
        {
          numbers.set(numbers.size() - 1, numbers.get(numbers.size() - 1) * -1);
        }

        //Clear the list to be ready for the next use
        tempStringList.clear();

        //After the number is interpreted, its time to interpret the expression
        if (counter < inputs.length)
        {
          expressions.add(toSymbol(inputs[counter]));
          counter++;
        }
      }

      //Initialize total with the first number
      int total = numbers.get(0);

      //Run through the list of numbers and expressions to carry out the calculation
      for (int i = 0; i < numbers.size() - 1; i++)
      {
        total = calculate(total, numbers.get(i + 1), expressions.get(i));
      }

      //Print the total
      System.out.println(total);
    }
  }

  /** Convert each string to numerical equivalent
	 *
	 * @param input	     	String input that is to be converted
	 * @return			      int equivalent of the given String
	 */
  public static int toNum(String input)
  {
    switch (input)
    {
      case "zero" : return 0;
      case "one" : return 1;
      case "two" : return 2;
      case "three" : return 3;
      case "four" : return 4;
      case "five" : return 5;
      case "six" : return 6;
      case "seven" : return 7;
      case "eight" : return 8;
      case "nine" : return 9;
      case "ten" : return 10;
      case "eleven" : return 11;
      case "twelve" : return 12;
      case "thirteen" : return 13;
      case "fourteen" : return 14;
      case "fifteen" : return 15;
      case "sixteen" : return 16;
      case "seventeen" : return 17;
      case "eighteen" : return 18;
      case "nineteen" : return 19;
      case "twenty" : return 20;
      case "thirty" : return 30;
      case "forty" : return 40;
      case "fifty" : return 50;
      case "sixty" : return 60;
      case "seventy" : return 70;
      case "eighty" : return 80;
      case "ninety" : return 90;
      case "hundred" : return 100;
      case "thousand" : return 1000;
      default : return -1;
    }
  }

  /** Convert each string to char equivalent
	 *
	 * @param input		    String input that is to be converted
	 * @return			      char equivalent of the given String
	 */
  public static char toSymbol(String input)
  {
    switch(input)
    {
      case "plus" : return '+';
      case "minus" : return '-';
      case "multiply" : case "times" : return '*';
      case "divide" : case "over" : return '/';
      case "remainder" : return '%';
      default : return '#';
    }
  }

  /** Check if the given String refers to an expression
	 *
	 * @param toCheck     String input that is to be checked
	 * @return			      If the String refers to a recognized expression
	 */
  public static boolean isExpression(String toCheck)
  {
    if (toSymbol(toCheck) == '#')
    {
      return false;
    }

    return true;
  }

  /** Convert the List of String into a whole number
	 *
	 * @param existingSet	Given, existing set of String to be interpreted
	 * @return			      A whole number represented by the given list of string
	 */
  public static int toWholeNumber(List<String> existingSet)
  {
    List<Integer> numbers = new ArrayList();

    //Loop through the given list
    for (int i = 0; i < existingSet.size(); i++)
    {
      //Get and convert the next String
      int newInput = toNum(existingSet.get(i));

      //Check if any multiplication is needed for this input
      if (newInput > 90)
      {
        //Multiply the previous figure with the current one
        numbers.set(numbers.size() - 1, numbers.get(numbers.size() - 1) * newInput);

        //If there is another number before this, add that as well
        if (numbers.size() - 2 != - 1 && numbers.get(numbers.size() - 2) != - 1)
        {
          numbers.set(numbers.size() - 1, numbers.get(numbers.size() - 1) + numbers.get(numbers.size() - 2));
        }
      }
      else
      {
        //Add the new integer to list
        numbers.add(newInput);

        //Check if the previous number is also less than 100
        if (numbers.size() - 2 > 0 && numbers.get(numbers.size() - 2) < 100)
        {
          //Add the previous number with the one before
          numbers.set(numbers.size() - 2, numbers.get(numbers.size() - 3) + numbers.get(numbers.size() - 2));
        }
      }
    }

    //If it is larger than one integer, add the last two together
    if (numbers.size() > 1)
    {
      numbers.set(numbers.size() - 1, numbers.get(numbers.size() - 2) + numbers.get(numbers.size() - 1));
    }

    //Put the wanted number into an int
    int temp = numbers.get(numbers.size() - 1);
    //Clear the list
    numbers.clear();
    //Return the desired number
    return temp;
  }

  /** Carry out the calculation
	 *
	 * @param total      	Existing total
   * @param newInt      The next integer in the main list
   * @param operation   The operation to be carried out onto the existing total and the new integer
	 * @return			      New total
	 */
  public static int calculate(int total, int newInt, char operation)
  {
    switch(operation)
    {
      case '+' : return total + newInt;
      case '-' : return total - newInt;
      case '*' : return total * newInt;
      case '/' : return total / newInt;
      case '%' : return total % newInt;
      default : return -1;
    }
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifemilesShunting;

/**
 *
 * @author Pavilion
 */
public class Calculator {
  private Stack<Integer> stack = new Stack<Integer>();
  private Queue<String> queue;

  public Calculator(Queue<String> q) {
    queue = q;
  }

  public String toString() {
    String str = "";

    for (String item: queue) {
      str += item + " ";
    }
    return str;
  }

  public int calculate() {
    for (String item: queue) {
      if (isNumeric(item)) stack.push(Integer.parseInt(item));
      else {
        int right = stack.pop();
        int left  = stack.pop();

        if (item.equals("+"))      stack.push(left + right);
        else if (item.equals("-")) stack.push(left - right);
        else if (item.equals("*")) stack.push(left * right);
        else if (item.equals("/")) stack.push(left / right);
      }
    }
    return stack.pop();
  }

  private static boolean isNumeric(String s)  {  
    try  {  
      double d = Double.parseDouble(s);  
    } catch(NumberFormatException nfe)  {  
      return false;  
    }  
    return true;  
  }
}


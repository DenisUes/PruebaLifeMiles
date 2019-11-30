/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifemilesShunting;
import java.util.Arrays;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Pavilion
 */
@XmlRootElement 
public class Result {
    
    public String infijo;
    public String postfijo;
    public double valor;

    public static boolean isNumeric(String s)  {  
    try  {  
      double d = Double.parseDouble(s);  
    } catch(NumberFormatException nfe)  {  
      return false;  
    }  
    return true;  
  }
      
    
  public Result (){
    Queue<String> input          = new Queue<String>();
    Queue<String> tokens         = new Queue<String>();
    Stack<Operador> operadores    = new Stack<Operador>();
    Queue<String> output         = new Queue<String>();
    String[] operadores_disponibles = {"+", "-", "*", "/"};


    for (String in: tokens) {
      input.enqueue(in);
    }
    

    while (!tokens.isEmpty()) {
      String token = tokens.dequeue();

      if (isNumeric(token)) output.enqueue(token);
      else if (Arrays.asList(operadores_disponibles).contains(token)) {
        Operador operator     = new Operador(token);
        Operador top_operator = operadores.peek();

          while (top_operator != null && top_operator.procedencia() > operator.procedencia()) {
            output.enqueue(top_operator.operador());
            operadores.pop();
            top_operator = operadores.peek();
          }

          operadores.push(operator);
        
      }
    }

    while (!operadores.isEmpty()) {
      Operador operator = operadores.pop();
      output.enqueue(operator.operador());
    }

    String in = "";
    Calculator calculator = new Calculator(output);

    for (String s: input) {
      in += s + " ";
    }

    
    infijo=in.toString();
    postfijo=calculator.toString();
    valor=calculator.calculate();
    
    /*
    System.out.printf("INFIX_EXPRESSION: %s \n", in);
    System.out.printf("POSTFIX_EXPRESSION: %s \n", calculator.toString());
    System.out.printf("VALUE: %d", calculator.calculate());
    */
  }
  
  public Result(String infx, String postfx, Double value){
      this.infijo=infx;
      this.postfijo=postfx;
      this.valor=value;
  }
  
  @Override
    public String toString(){
        return new StringBuffer("INFIX_EXPRESSION: ").append(infijo).
        append("POSTFIX_EXPRESSION: ").append(postfijo).
        append("RESULT: ").append(valor).toString();
      }
}


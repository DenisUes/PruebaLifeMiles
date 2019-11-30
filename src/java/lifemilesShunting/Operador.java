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
public class Operador {
    private String operador;

  public Operador(String op) {
    operador = op;
  }

  public String operador() {
    return operador;
  }

  public int procedencia() {
    if (operador.equals("+") || operador.equals("-")) return 1;
    else if (operador.equals("*") || operador.equals("/")) return 2;
    return -1;
  }
  

}

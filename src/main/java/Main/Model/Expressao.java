/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.Model;

/** Classe abstrata do Model para a expressão, que representa o Component, no padrão de projeto Composite
 *
 * @author havillon
 */
public abstract class Expressao {
   public abstract boolean calcular();
   public abstract void adicionar(Expressao e); 
}

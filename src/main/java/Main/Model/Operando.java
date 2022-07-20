package Main.Model;

/** Classe do Model para o operando, que representa o Leaf, no padrão de projeto Composite
 *
 * @author havillon
 */
public class Operando extends Expressao {
    public boolean valor;
    
    /**Método construtor padrão da classe
    * @author havillon
    * @param valor Boolean - Valor lógico do Operando
    */
    public Operando(boolean valor){
        this.valor = valor;
    }
    
    /**Método que atribui um valor ao operando
    * @author havillon
    * @param valor Boolean - Valor lógico do Operando
    */
    public void setValor (boolean valor){
        this.valor = valor;
    }
    
    /**Método que retorna o valor do operando
    * @author havillon
    * @return Boolean - Valor lógico do Operando
    */
    public boolean getValor(){
        return this.valor;
    }
    
    /**Método que retorna o valor do operando, de acordo com o padrão Composite
    * @author havillon
    * @return Boolean - Valor do operando
    */
    @Override
    public boolean calcular(){
        return this.valor;
    }
    
    /**Método de adicionar (apenas para implementar o método da classe abstrata)
    * @author havillon
    */
    @Override
    public void adicionar(Expressao e){
        
    }
}

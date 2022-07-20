package Main.Model;

/** Classe do Model para o operador, que representa o Composite, no padrão de projeto Composite
 *
 * @author havillon
 */
public class Operador extends Expressao{
    
    Expressao e;
    Expressao e2;
    char tipo;
    
    /**Método construtor da classe quando a operação é a negação
    * @author havillon
    * @param e Expressao - Expressão a ser negada
    * @param tipo Char - Caractere que representa a operação de negação
    */
    public Operador(Expressao e, char tipo){
        if(tipo == '~'){
            this.e = e;
            this.e2 = null;
            this.tipo = tipo;
        }
    }
    
    /**Método construtor da classe quando a operação é disjunção ou conjunção
    * @author havillon
    * @param e Expressao - Primeira expressão da operação
    * @param e2 Expressao - Segunda expressão da operação
    * @param tipo Char - Caractere que representa a operação
    */
    public Operador(Expressao e, Expressao e2, char tipo){
        if(tipo == '+' || tipo == '.'){
            this.e = e;
            this.e2 = e2;
            this.tipo = tipo;
        }
    }
    
    /**Método que realiza o cálculo do valor da operação dada
    * @author havillon
    * @return Boolean - Resultado da operação calculada
    */
    @Override
    public boolean calcular(){
        return switch (tipo) {
            case '~' -> !e.calcular();
            case '+' -> e.calcular() || e2.calcular();
            case '.' -> e.calcular() && e2.calcular();
            default -> false;
        };
    }
    
    /**Método que adiciona uma Expressão, para negação
     * @param e Expressao
    * @author havillon
    */
    @Override
    public void adicionar(Expressao e){
        this.e = e;
    }
    
    /**Método que adiciona duas Expressões, para disjunção ou conjunção
     * @param e Expressao
     * @param e2 Expressao
    * @author havillon
    */
    public void adicionar(Expressao e, Expressao e2){
        this.e = e;
        this.e2 = e2;
    }
}

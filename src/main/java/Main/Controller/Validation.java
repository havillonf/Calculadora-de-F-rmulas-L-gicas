package Main.Controller;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.*;

/**Classe do Controller que irá vaçlidar a formula lógica digitada pelo usuário
 * 
 * @author havillon
 */
public class Validation {
    
    public static String entry;
    
    /**Método construtor padrão da classe
    * @author havillon
    * @param entry String - Formula lógica fornecida pelo usuário
    */
    public Validation(String entry){
        Validation.entry = entry;
    }
    
    /**Método que valida a fórmula recebida, a partir de chamadas de funções que fazem cada validação específica.
    * @author havillon
    * @return String - Mensagem de erro, que é vazia caso a entrada seja válida.
    */
    public static String validate(){
        String error_message = "";
        //remove espaços em branco
        entry = entry.replaceAll("\\s+",""); 
        
        if(entry.length() < 1){
            error_message = "Tamanho inválido";
        }else if(entry.charAt(0) == '+' || entry.charAt(0) == '.'){
            error_message = "Não é permitido iniciar a expressão com um operador";
        }else if(!invalidCharacters(entry)){
            error_message = "Caracteres inválidos";
        }else if(!verifyOperators(entry)){
            error_message = "Operadores inexistentes ou inválidos";
        }else if(!verifyVariables(entry)){
            error_message = "Número de variáveis maior que o permitido";
        }else if(!verifyParentesis(entry)){
            error_message = "Parênteses inválidos";
        }else if(verifyFormula(entry)){
            error_message = "Fórmula lógica inválida";
        }
        return error_message;
    }
    
    /**Método que realiza a contagem do número de variáveis 
    * @author havillon
    * @param entry String - Formula lógica fornecida pelo usuário
    * @return Boolean - Resultado da validação do número de variáveis, caso seja menor ou igual a 5
    */
    public static boolean verifyVariables(String entry){
        Set<Character> variables = new HashSet<>();
        for(int i = 0; i < entry.length(); i++){
            if(entry.charAt(i) != '~' && entry.charAt(i) != '+' && entry.charAt(i) != '.' && entry.charAt(i) != '(' && entry.charAt(i) != ')'){
                variables.add(entry.charAt(i));
                if(variables.size() > 5){
                    return false;
                }
            }
        }
        return true;
    }

    /**Método que procura por caracteres não permitidos, a partir de expressão regular.
    * @author havillon
    * @param entry String - Formula lógica fornecida pelo usuário
    * @return Boolean - Resultado da validação da entrada
    */
    public static boolean invalidCharacters(String entry){
        entry = entry.replaceAll("\\+", "");
        entry = entry.replaceAll("\\(", "");
        entry = entry.replaceAll("\\)", "");
        entry = entry.replaceAll("\\.", "");
        entry = entry.replaceAll("\\~", "");
        
        Pattern pat = Pattern.compile("[^a-zA-Z]");
        Matcher mat = pat.matcher(entry); 

        return !mat.find();    
    }

    /**Método que checa se os parênteses estão dispostos de maneira correta
    * @author havillon
    * @param entry String - Formula lógica fornecida pelo usuário
    * @return Boolean - Resultado da validação da entrada
    */
    public static boolean verifyParentesis(String entry){
        int contOpen = 0, contClose = 0; 
        for(int i = 0; i < entry.length(); i++){
            if(contClose > contOpen){
                return false;
            }
            if(entry.charAt(i) == '('){
                contOpen++;
            }else if(entry.charAt(i) == ')'){
                contClose++;
            }
        }
        return contClose == contOpen;

    }
    
    /**Método que checa se os operadores existem, e previne o caso de a entrada terminar com um operador
    * @author havillon
    * @param entry String - Formula lógica fornecida pelo usuário
    * @return Boolean - Resultado da validação da entrada
    */
    public static boolean verifyOperators(String entry){
        int cont = 0;
        for(int i = 0; i < entry.length(); i++){
            if(entry.charAt(i) == '~' || entry.charAt(i) == '+' || entry.charAt(i) == '.'){
                cont++;
            }
        }
        
        char last_char = entry.charAt(entry.length()-1);
        
        if(last_char == '~' || last_char == '+' || last_char == '.' || last_char == '('){
            cont = 0;
        }
        return cont > 0;
    }
    
    /**Método que procura por erros de digitação na entrada, a partir de expressões regulares
    * @author havillon
    * @param entry String - Formula lógica fornecida pelo usuário
    * @return Boolean - Resultado da validação da entrada
    */
    public static boolean verifyFormula(String entry){
        Pattern patLetterTwice = Pattern.compile("[a-zA-Z]{2}");
        Pattern patSpecialCharacters = Pattern.compile("[\\+\\.]{2}");
        Pattern patSpecialCharacters2 = Pattern.compile("[\\)][\\~]");
        Pattern patSpecialCharacters3 = Pattern.compile("[\\~][\\+\\.]");
        Pattern patParentesisLetter = Pattern.compile("[\\)][a-zA-Z]");
        Pattern patLetterParentesis = Pattern.compile("[a-zA-Z][\\(]");
        Pattern patLetterNot = Pattern.compile("[a-zA-Z][\\~]");
        
        Matcher matLT = patLetterTwice.matcher(entry);
        Matcher matSC = patSpecialCharacters.matcher(entry);
        Matcher matSC2 = patSpecialCharacters2.matcher(entry);
        Matcher matSC3 = patSpecialCharacters3.matcher(entry);
        Matcher matPL = patParentesisLetter.matcher(entry);
        Matcher matLP = patLetterParentesis.matcher(entry);
        Matcher matLN = patLetterNot.matcher(entry);
        
        return matLT.find() || matSC.find() || matSC2.find() || matSC3.find() || matPL.find() || matLP.find() || matLN.find();

    }

}
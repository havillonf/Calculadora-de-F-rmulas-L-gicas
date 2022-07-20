package Main.Controller;

import Main.Model.Expressao;
import Main.Model.Operando;
import Main.Model.Operador;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import com.opencsv.CSVWriter;

/**Classe do Controller que irá realizar as manipulações da String da formula lógica
 * 
 * @author havillon
 */
public class Formula {
    public ArrayList<Expressao> expressoes = new ArrayList<>();
    public Map <Character, Boolean> variables = new HashMap<>();
    public ArrayList<String> formulas = new ArrayList<>();
    public String tabela[][];
    public String entry;
    
    /**Método construtor da classe, sem parâmetros
    * @author havillon
    */
    public Formula(){}
    
    /**Método construtor padrão da classe
    * @author havillon
    * @param entry String - Formula lógica fornecida pelo usuário
    */
    public Formula(String entry){
        this.entry = entry;
    }
    
    /**Método que preenche o dicionário de variáveis que serão utilizadas para calcular a tabela
    * @author havillon
    */
    public void fillMap(){
        for(int i = 0; i < entry.length(); i++){
            if(entry.charAt(i) != '~' && entry.charAt(i) != '+' && entry.charAt(i) != '.' && entry.charAt(i) != '(' && entry.charAt(i) != ')'){
                variables.put(entry.charAt(i), false);
            }
        }
    }
    
    /**Método que adiciona as variáveis do dicionário no ArrayList de fórmulas, já que cada variável representa uma coluna da tabela verdade
    * @author havillon
    */
    public void variablesToFormulas(){
        for(Map.Entry<Character, Boolean> ent : variables.entrySet()){
            formulas.add(String.valueOf(ent.getKey()));
        }
    }
    
    /**Método recursivo que divide as fórmulas em partes menores baseando-se na divisão em parênteses. 
    * Essas divisões são as demais colunas da tabela verdade, junto com as variáveis e a fórmula final
    * @author havillon
    * @param entry String - Formula lógica 
    * @return String - Chamada recursiva da função com uma fórmula intermediária (com partes que ainda não foram analisadas)
    */
    public String separateFormulas(String entry){
        //Variavel que recebe o index do parenteses mais interno
        int parOp = entry.lastIndexOf("(");

        //Confere se existem parenteses (caso de encerramento da recursão)
        if(parOp == -1){
            correctFormulas();
            return "";
        }

        //A partir disso pegamos uma substring que representa a expressão dentro dos parênteses mais internos
        String oper = entry.substring(parOp);
        int parCl = oper.indexOf(")");
        String form = entry.substring(parOp, parCl+parOp+1);

        //Adiciona na lista de formulas
        formulas.add(form);

        //Troca parenteses por colchetes para substituir e poder fazer a recursão
        String formAdapted = form.replaceAll("\\(", "[").replaceAll("\\)", "]");

        //Troca os parenteses da expressão mais interna analisada 
        String newEntry = entry.substring(0, parOp);
        newEntry += formAdapted;
        newEntry += entry.substring(parCl+parOp+1);
        
        return separateFormulas(newEntry);
    }
    
    /**Método auxiliar, que substitui os colchetes adicionados no método separateFormulas() por parênteses, fazendo com que a fórmula volte ao padrão original
    * @author havillon
    */
    public void correctFormulas(){
        //percorre por todas as formulas recolocando os parenteses
        for(int i = 0; i < formulas.size(); i++){
            formulas.set(i, formulas.get(i).replaceAll("\\[", "(").replaceAll("\\]", ")"));
        }
        if(!formulas.contains(entry)){
            formulas.add(entry);
        }
    }
    
    /**Método que faz as variações de valores de cada variável, faz a chamada da função que calcula os valores das subfórmulas e da fórmula final, e preenche a matriz com os valores respectivos.
    * @author havillon
    */
    public void generateTable(){
        int j = 0;
        
        tabela = new String[(int)(Math.pow(2,variables.size()))][formulas.size()];
        
        for(int i = 0; i < Math.pow(2,variables.size()); i++){
            for(Map.Entry<Character, Boolean> ent : variables.entrySet()){
                if(j % variables.size() == 0){
                    if(i % (Math.pow(2,variables.size())/2) == 0){
                        ent.setValue(!ent.getValue());
                    }
                }else if(j % variables.size() == 1){
                    if(i % (Math.pow(2,variables.size())/4) == 0){
                        ent.setValue(!ent.getValue());
                    }
                }else if(j % variables.size() == 2){
                    if(i % (Math.pow(2,variables.size())/8) == 0){
                        ent.setValue(!ent.getValue());
                    }
                }else if(j % variables.size() == 3){
                    if(i % (Math.pow(2,variables.size())/16) == 0){
                        ent.setValue(!ent.getValue());
                    }
                }else if(j % variables.size() == 4){
                    if(i % (Math.pow(2,variables.size())/32) == 0){
                        ent.setValue(!ent.getValue());
                    }
                }
                
                if(ent.getValue()){
                    tabela[i][j%variables.size()] = "1";
                }else{
                    tabela[i][j%variables.size()] = "0";
                }
                j++;
                
            }
            
            for(int k = variables.size(); k < formulas.size(); k++){
                if(solveFormula(formulas.get(k))){
                    tabela[i][k] = "1";
                }else{
                    tabela[i][k] = "0";
                }
                
            }
            
        }
    }
    
    /**Método recursivo que, a partir da fórmula, retorna o valor lógico (0 ou 1) baseado nos valores atuais de cada variável.
    * @author havillon
    * @param formula String - Formula lógica fornecida pelo usuário
    * @return Boolean - Valor lógico da fórmula recebida
    */
    public boolean solveFormula(String formula){
        Pattern pat = Pattern.compile("[\\(\\)]");
        Pattern pat2 = Pattern.compile("[\\~]");
        Pattern pat3 = Pattern.compile("[\\.]");
        Pattern pat4 = Pattern.compile("[\\+]");
        
        //nao tem parenteses
        if(!pat.matcher(formula).find()){
            
            //nao tem negacao
            if(!pat2.matcher(formula).find()){
                
                //apenas conjuncao
                if((pat4.matcher(formula).find() && !pat3.matcher(formula).find())){
                    return getSimpleExpressionValue(formula, '+');
                
                //apenas disjuncao
                }else if((!pat4.matcher(formula).find() && pat3.matcher(formula).find())){
                    
                    return getSimpleExpressionValue(formula, '.');
                
                //disjuncao e conjuncao juntas    
                }else if(pat3.matcher(formula).find() && pat4.matcher(formula).find()){
                    
                    //retorna para a funcao, agora com parenteses
                    return solveFormula(this.addParentesis1(formula));
                
                //apenas o valor logico
                }else{
                    if("1".equals(formula)){
                        return true;
                    }else if ("0".equals(formula)){
                        return false;
                    }
                }
                
            //tem negacao e nao tem parenteses    
            }else{
                if(formula.length() == 2){
                    return getSimpleExpressionValue(formula, '~');
                }else{
                    return solveFormula(this.addParentesis2(formula));
                }
            }   
        
        //tem parenteses
        }else{
            
            //nao tem negacao
            if(!pat2.matcher(formula).find()){
                
                //apenas disjuncao
                if((pat4.matcher(formula).find() && !pat3.matcher(formula).find())){
                    
                    //os parenteses sao desnecessarios, retorna para a funcao sem parenteses
                    return solveFormula(formula.replaceAll("\\(", "").replaceAll("\\)", ""));
                
                //apenas conjuncao
                }else if((!pat4.matcher(formula).find() && pat3.matcher(formula).find())){
                    
                    //os parenteses sao desnecessarios, retorna para a funcao sem parenteses
                    return solveFormula(formula.replaceAll("\\(", "").replaceAll("\\)", ""));
                
                //disjuncao e conjuncao juntas    
                }else if(pat3.matcher(formula).find() && pat4.matcher(formula).find()){
                    
                    Pattern dc = Pattern.compile("[\\+][A-Za-z][\\.]");
                    Pattern cd = Pattern.compile("[\\.][A-Za-z][\\+]");
                    
                    //procura por irregularidades nos parenteses
                    if(cd.matcher(formula).find() || dc.matcher(formula).find()){
                        
                        //os parenteses estao incorretos, retorna para a funcao para ser corrigido
                        return solveFormula(formula.replaceAll("\\(", "").replaceAll("\\)", ""));
                        
                    //nao ha irregularidade nos parenteses, podemos resolver
                    }else{
                        //Variavel que recebe o index do parenteses mais interno
                        int parOp = formula.lastIndexOf("(");

                        //A partir disso pegamos uma substring que representa a expressão dentro dos parênteses mais internos
                        String oper = formula.substring(parOp);
                        int parCl = oper.indexOf(")");
                        String form = formula.substring(parOp+1, parCl+parOp);
                        
                        boolean subResult = solveFormula(form);

                        String beg = formula.substring(0,parOp);
                        String end = formula.substring(parCl+parOp+1);
                        if(subResult){
                            return solveFormula(beg+"1"+end);
                        }else{
                            return solveFormula(beg+"0"+end);
                        }
                    }
                    
                //apenas o valor logico
                }else{
                    if(formula.charAt(1) == '1'){
                        return true;
                    }else if(formula.charAt(1) == '0'){
                        return false;
                    }
                }
                
            //tem parenteses e negacao
            }else{
                
                if(formula.length() == 4){
                    //os parenteses sao desnecessarios, retorna para a funcao sem parenteses
                    return solveFormula(formula.replaceAll("\\(", "").replaceAll("\\)", ""));  
                }else{
                    //Variavel que recebe o index do parenteses mais interno
                    int parOp = formula.lastIndexOf("(");

                    //A partir disso pegamos uma substring que representa a expressão dentro dos parênteses mais internos
                    String oper = formula.substring(parOp);
                    int parCl = oper.indexOf(")");
                    String form = formula.substring(parOp+1, parCl+parOp);

                    boolean subResult = solveFormula(form);

                    String beg = formula.substring(0,parOp);
                    String end = formula.substring(parCl+parOp+1);
                    if(subResult){
                        return solveFormula(beg+"1"+end);
                    }else{
                        return solveFormula(beg+"0"+end);
                    }
                }   
            }
        }
        return false;
    }
    
    /**Método que resolve expressões lógicas do tipo (A.B), (A+B), (~A), seja com variáveis ou constantes.
    * Esse método acessa o Model, atribui um valor lógico para a variável a ser utilizada, e calcula o valor final baseado nos valores atribuídos e na operação realizada.
    * @author havillon
    * @param formula String - Formula lógica fornecida pelo usuário
    * @param operation Char - Caractere que representa a operação a ser executada
    * @return Boolean - Resultado da fórmula simples
    */
    public boolean getSimpleExpressionValue(String formula, char operation){
        if(operation == '~'){
            
            Expressao e;
            Expressao neg;
            if(formula.charAt(1) == '1'){
                e = new Operando(true);
            }else if(formula.charAt(1) == '0'){
                e = new Operando(false);
            }else{
                e = new Operando(variables.get(formula.charAt(1)));
            }
            
            neg = new Operador(e, operation);
            
            return neg.calcular();
            
        }else{
            ArrayList<Character> vars = new ArrayList<>();
            ArrayList<Character> ops = new ArrayList<>();

            for(int i = 0; i < formula.length(); i++){
                if(i%2==0){
                    vars.add(formula.charAt(i));
                }else{
                    ops.add(formula.charAt(i));
                }
            }

            ArrayList<Expressao> operandos = new ArrayList<>();
            for(int i = 0; i < vars.size(); i++){
                if(vars.get(i) == '0'){
                    operandos.add(new Operando(false));
                }else if(vars.get(i) == '1'){
                    operandos.add(new Operando(true));
                }else{
                    operandos.add(new Operando(variables.get(vars.get(i))));
                }
            }

            ArrayList<Expressao> operadores = new ArrayList<>();
            operadores.add(new Operador(operandos.get(0), operandos.get(1), operation));
            for(int i = 0; i < ops.size()-1; i++){
                operadores.add(new Operador(operadores.get(i), operandos.get(i+2), operation));
            }

            return operadores.get(operadores.size()-1).calcular();
        }     
        
    }
    
    /**Método que adiciona parênteses à fórmula recebida, no caso em que existe uma negação sem estes, para que a operação receba a maior prioridade.
    * @author havillon
    * @param entry String - Formula lógica a ser corrigida
    * @return String - formula lógica corrigida
    */
    public String addParentesis2(String entry){
        Pattern p = Pattern.compile("[\\~]");
        while(p.matcher(entry).find()){
            String beg = entry.substring(0, entry.indexOf("~"));
            String mid = entry.substring(entry.indexOf("~"), entry.indexOf("~")+2);
            mid = mid.replaceAll("\\~", "!");
            String end = entry.substring(entry.indexOf("~")+2);
            entry = beg + "(" + mid + ")" + end;
        }
        entry = entry.replaceAll("\\!", "~");
        return entry;
    }
    
    /**Método que adiciona parênteses à fórmula recebida, no caso em que existe disjunção e conjunção juntas no mesmo nível, para que a disjunção receba a maior prioridade.
    * @author havillon
    * @param entry String - Formula lógica a ser corrigida
    * @return String - formula lógica corrigida
    */
    public String addParentesis1(String entry){
        Pattern p = Pattern.compile("[\\.]");
        while(p.matcher(entry).find()){
            String beg = entry.substring(0, entry.indexOf(".")-1);
            String mid = entry.substring(entry.indexOf(".")-1, entry.indexOf(".")+2);
            mid = mid.replaceAll("\\.", "*");
            String end = entry.substring(entry.indexOf(".")+2);
            entry = beg + "(" + mid + ")" + end;
        }
        entry = entry.replaceAll("\\*", ".");
        return entry;
    }

    /**Método que salva um arquivo CSV da tabela verdade.
    * @author havillon
    * @param rowData String[]][] - Valores (0 ou 1) da tabela verdade
    * @param columnNames String[] - Valores para os cabeçalhos das colunas
    */
    public void exportCSV(String[][] rowData, String[] columnNames){
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/CSV/table.csv");
        
        try{
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            ArrayList<String[]> data = new ArrayList<String[]>();
            
            data.add(columnNames);
            for (int i = 0; i < rowData.length; i++) {;;
                data.add((String[]) rowData[i]);
            }
            writer.writeAll(data);
            writer.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

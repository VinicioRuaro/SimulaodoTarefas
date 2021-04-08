package trabalho.pkg2.jogo.de.so;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorTarefa {
    
    public static Tarefa gerador(){
        Tarefa tarefa = new Tarefa();
        Random gerador = new Random();
        
        String letras = "ABCDEFGHIJKLMNOPQRSTUVXWYZabcdefghijklmnopqrstuvxwyz0123456789";
        
        int qtdNome;
        qtdNome = gerador.nextInt(10);
        
        if (qtdNome==0) {
            qtdNome++;
        }
        
        tarefa.nome = "" + letras.charAt(gerador.nextInt(letras.length()));
         qtdNome--;
        for (int i = 0; i < qtdNome; i++) {
            tarefa.nome = tarefa.nome + letras.charAt(gerador.nextInt(letras.length()));
        }
        
        int prioridade= gerador.nextInt(10);
        if(prioridade==0){
            prioridade++;
        }
        tarefa.prioridade= prioridade;
        
        int qtdOpera;
        qtdOpera = gerador.nextInt(10);
        if(qtdOpera==0){
            qtdOpera++;
        }
        
        ArrayList<String> memoria = new  ArrayList<>();
        String mem;
        mem="0";
        memoria.add(mem);
        mem="1";
        memoria.add(mem);
        mem="2";
        memoria.add(mem);
        mem="3";
        memoria.add(mem);
        mem="4";
        memoria.add(mem);
        mem="5";
        memoria.add(mem);
        mem="6";
        memoria.add(mem);
        mem="7";
        memoria.add(mem);
        mem="8";
        memoria.add(mem);
        mem="9";
        memoria.add(mem);
        
        for (int i = 0; i < qtdOpera; i++) {
            
            int ale;
            ale = gerador.nextInt(2);
            
            if(ale==0){
                tarefa.operação.add("W");
                
            }
            
            if(ale==1){
                 
                int memoriasor;
                
                memoriasor= gerador.nextInt(memoria.size());
               
                String operação = "L"+memoria.get(memoriasor);
                
                tarefa.operação.add(0,operação);
                
                tarefa.operaçãoint.add(0, Integer.parseInt(memoria.get(memoriasor)));
                
                operação = "U"+memoria.get(memoriasor);
                
                tarefa.operação.add(operação);
               
                tarefa.operaçãoint.add(Integer.parseInt(memoria.get(memoriasor)));
                memoria.remove(memoriasor);
                
               
            }
            
            
        }
        
        return tarefa;
    }
    
}

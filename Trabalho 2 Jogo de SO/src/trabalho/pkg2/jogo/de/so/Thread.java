
package trabalho.pkg2.jogo.de.so;

import java.util.concurrent.RecursiveTask;
import javax.swing.JOptionPane;


public class Thread extends RecursiveTask<Object>{

    Tarefa tarefa = new Tarefa();
    
    JFrameTelaJogo telaJogo;
    int thread;
    int thread1;
    
    public Thread(Tarefa tarefa, JFrameTelaJogo telaJogo,int thread){
        this.tarefa=tarefa;
        this.telaJogo=telaJogo;
        this.thread=thread;
        
    }
    
    @Override
    protected Object compute() { 
        
        thread1=thread-1;
        if (tarefa.operação.get(0).charAt(0)=='W') {
            tarefa.operação.remove(0);
            JOptionPane.showMessageDialog(null, "A Thread "+thread+ " fez o processo de Wait.");     
            }
        else if(tarefa.operação.get(0).charAt(0)=='L'){
                if(telaJogo.mutex.get(tarefa.operaçãoint.get(0))==1){
                    JOptionPane.showMessageDialog(null, "A Thread "+thread+" não alocou o espaço "+tarefa.operação.get(0).charAt(1)+" pois o espaço ja estava alocado.");             
                }
                else{
                    telaJogo.mutex.set(tarefa.operaçãoint.get(0), 1);
                    JOptionPane.showMessageDialog(null, "A Thread "+thread+" alocou o espaço "+tarefa.operação.get(0).charAt(1)+".");
                    tarefa.operação.remove(0);
                   
                    tarefa.operaçãoint.remove(0);
                    
            }          
        }
        else if(tarefa.operação.get(0).charAt(0)=='U'){
            telaJogo.mutex.set(tarefa.operaçãoint.get(0), 0);
            JOptionPane.showMessageDialog(null, "A Thread "+thread+" desalocou o espaço "+tarefa.operação.get(0).charAt(1)+".");
            tarefa.operação.remove(0);
            
        }
        
      
        
        
        
        
        
        return null;      
    }
    
}

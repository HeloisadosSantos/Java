package ExercicioIII;


public class Task {
//atributos
private String description;
private boolean done; //indica se foi ou não concluido
//construtor(somente String description)
public Task(String description) {
this.description = description;
this.done = false;

}
//set and Gets
public String getDescription() {
return description;
}
public boolean isDone() { //foi ou não concluida a tarefa
return done;
}
public void setDone(boolean done) {
this.done = done;
}
public void setCompleted(boolean b) {
}
public boolean isCompleted() {
    return false;
}
}

package Agenda;

import Cadastro.Animal;

/**
 * Agendamento
 */
public class Agendamento extends Animal {

    //atributos
    //métodos
    //verificar se já foi cadastrado
    //só pode haver se o horario estiver vago retornar mensagem falando para a pessoa solicitar um novo horario.

    int horario;
    int data;
    String cirurgia;
    String local;
    int contact;
    
    public Agendamento(int horario, int data, String cirurgia, String local, int contact) {
        this.horario = horario;
        this.data = data;
        this.cirurgia = cirurgia;
        this.local = local;
        this.contact = contact;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(String cirurgia) {
        this.cirurgia = cirurgia;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
 


}
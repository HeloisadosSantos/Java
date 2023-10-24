import javax.swing.JOptionPane;
import Cadastro.Animal;
import Cadastro.Cachorro;
import Cadastro.Coelho;
import Cadastro.Gato;
import Cadastro.OutroAnimal;
import Agenda.Agendamento;


/**
 * App
 */
public class App {

    public static void main(String[] args) {
        Cachorro Cachorro[] = new Cachorro[10];
        Coelho Coelho[] = new Coelho[10];
        Gato Gato[] = new Gato[10];
        OutroAnimal OutroAnimal[] = new OutroAnimal[10];

        // aberta igual true, roda o que esta dentro do while.
        boolean aberta = true;
        int cachorro = 0;
        int coelho = 0;
        int gato = 0;
        int outroAnimal = 0;
       

        while (aberta) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma ação:"
                    + "\n 1- Cadastrar Cachorro;"
                    + "\n 2- Cadastrar Coelho"
                    + "\n 3- Cadastrar Gato"
                    + "\n 4- Cadastrar Animal Encontrado"));

            if (acao == 1) { // vai cadastrar cachorro

                // criar um objeto (construtor)
                Cachorro[cachorro] = new Cachorro();// obj/conta esta criado
                // preencher as informações do cadastro
                Cachorro[cachorro].setNome(JOptionPane.showInputDialog("Digite o Nome do Animal"));
                Cachorro[cachorro].setPeso(JOptionPane.showInputDialog("Informe o Peso do Animal"));
                Cachorro[cachorro].setProprietario(JOptionPane.showInputDialog("Informe seu nome"));
                Cachorro[cachorro].setEspecie(JOptionPane.showInputDialog("Informe a Raça do seu cão."));
                Cachorro[cachorro].setCor(JOptionPane.showInputDialog("Qual a cor do s eu Pet?"));
                Cachorro[cachorro].setIdade(JOptionPane.showInputDialog("Qual a Idade do seu Pet?"));

                // imprimir
                JOptionPane.showMessageDialog(null,
                        "O Cãozinho " + Cachorro[cachorro].getNome() + " \n do Proprietário (a)"
                                + Cachorro[cachorro].getProprietario() +
                                " \n foi Cadastrado com sucesso.");
                JOptionPane.showMessageDialog(null,
                        "" + Cachorro[cachorro].getNome() + " \n da Raça " + Cachorro[cachorro].getEspecie() +
                                " \n está pronto para ser consultada.");
                
               

                // acrescimo do contador
                cachorro++;



            } else if (acao == 2) { // cobra

                // criar um objeto (construtor)
                Coelho[coelho] = new Coelho();// obj/conta esta criado
                // preencher as informações do cadastro
                Coelho[coelho].setNome(JOptionPane.showInputDialog("Digite o Nome do Animal"));
                Coelho[coelho].setPeso(JOptionPane.showInputDialog("Informe o Peso do Animal"));
                Coelho[coelho].setProprietario(JOptionPane.showInputDialog("Informe seu nome"));
                Coelho[coelho].setCor(JOptionPane.showInputDialog("Informe se a a cor do seu Coelho"));
                Coelho[coelho].setSilvestre(JOptionPane.showInputDialog("Estamos lidando com um Animal Silvestre ?"));

                // imprimir
                JOptionPane.showMessageDialog(null,
                        " O Coelho " + Coelho[coelho].getNome() + " \n do Proprietário (a)"
                                + Coelho[coelho].getProprietario() +
                                " \n foi Cadastrado com sucesso.");

                // acrescimo do contador
                coelho++;

            } else if (acao == 3) { // gato

                // criar um objeto (construtor)
                Gato[gato] = new Gato();// obj/conta esta criado
                // preencher as informações do cadastro
                Gato[gato].setNome(JOptionPane.showInputDialog(" Digite o Nome do Animal"));
                Gato[gato].setPeso(JOptionPane.showInputDialog(" Informe o Peso do seu Gatinho"));
                Gato[gato].setProprietario(JOptionPane.showInputDialog(" Informe seu nome"));
                Gato[gato]
                        .setEspecie(JOptionPane.showInputDialog(" Informe a especie do seu Animalzinho de Estimação."));
                Gato[gato].setOndeMora(JOptionPane.showInputDialog("Informe onde você mora."));

                // imprimir
                JOptionPane.showMessageDialog(null,
                        " O Gato " + Gato[gato].getNome() + " \n do Proprietário (a) "
                                + Gato[gato].getProprietario() +
                                " \n foi Cadastrado com sucesso.");

                // acrescimo do contador
                gato++;
            } else if (acao == 4) {
                OutroAnimal[outroAnimal] = new OutroAnimal();

                OutroAnimal[outroAnimal].setLugarEncontrado(JOptionPane.showInputDialog("Onde você o encontrou?"));
                OutroAnimal[outroAnimal].setQualAnimal(JOptionPane.showInputDialog("Qual a Especie do Animal ?"));
                OutroAnimal[outroAnimal]
                        .setSilvestre(JOptionPane.showInputDialog("Este Animal é domestico ou Silvestre?"));
                OutroAnimal[outroAnimal]
                        .setSituacao(JOptionPane.showInputDialog("De uma breve descriÇão dos Machucados"));

                JOptionPane.showMessageDialog(null,
                        " O " + OutroAnimal[outroAnimal].getQualAnimal() + " \n encontrado nas redondezas do "
                                + OutroAnimal[outroAnimal].getLugarEncontrado() +
                                " \n foi Cadastrado com sucesso e logo será atendido");

                outroAnimal++;
            }

              }
        }
    }


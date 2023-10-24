import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        // SwingUtilities.invokeLater garante que a interface gráfica Swing seja criada na thread de eventos Swing,
        // que é a thread apropriada para manipular a GUI. Isso evita problemas de concorrência.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Cria uma instância da classe CadastroUsuarios, que é a classe principal da aplicação.
                MainFrame app = new MainFrame();
                app.pack();
                // Torna a janela da aplicação visível para o usuário.
                app.setVisible(true);
            }
        });
    }
}

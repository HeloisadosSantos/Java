import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OperacoesAgenda {
    private List<Agenda> agendas;
    private DefaultTableModel agendaTableModel;
    private JTable agendaTable;

     

    public OperacoesAgenda(String data, String hora, String usuario, String descricao) {
        Agenda agendas = new Agenda(data, hora, usuario, descricao);
        agendas.add(agendas);
        atualizarTabelaAgendas();
    }

    public OperacoesAgenda(List<Agenda> agendas2, DefaultTableModel agendaTableModel2, JTable agendaTable2) {
    }

    public void atualizarAgenda(int linhaSelecionada, String data, String hora, Usuario usuario, String descricao) {
        if (linhaSelecionada != -1) {
            agenda.setData(data);
            agenda.setHora(hora);
            agenda.setUsuario(usuario);
            agenda.setDescricao(descricao);
            atualizarTabelaAgendas();
        }
    }

    public void apagarAgenda(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            agendas.remove(linhaSelecionada);
            atualizarTabelaAgendas();
        }
    }

    private void atualizarTabelaAgendas() {
        agendaTableModel.setRowCount(0);
        for (Agenda agenda : agendas) {
            agendaTableModel.addRow(new Object[]{agenda.getData(), agenda.getHora(), agenda.getUsuario().getNome(), agenda.getDescricao()});
        }
    }

    public void cadastrarUsuario(String text, String text2) {
    }

    public void apagarUsuario(int linhaSelecionadaAgenda) {
    }

    public void salvarUsuarios() {
    }
}

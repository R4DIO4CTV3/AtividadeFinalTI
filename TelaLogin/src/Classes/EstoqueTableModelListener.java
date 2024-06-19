
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

class EstoqueTableModelListener implements TableModelListener {
    private DefaultTableModel tbRegModel;
    private int[][] valoresAnteriores;

    public EstoqueTableModelListener(DefaultTableModel tbRegModel, int numRows) {
        this.tbRegModel = tbRegModel;
        this.valoresAnteriores = new int[numRows][3]; // Inicializa a matriz com o número de linhas da tabela
    }

    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            int linha = e.getFirstRow();
            int coluna = e.getColumn();
            if (coluna == 2) { // Quantidade
                int quantidadeAtual = (int) ((TableModel) e.getSource()).getValueAt(linha, coluna);
                int quantidadeAnterior = valoresAnteriores[linha][coluna]; // Pega o valor anterior da quantidade
                valoresAnteriores[linha][coluna] = quantidadeAtual; // Atualiza o valor anterior
                String produto = (String) ((TableModel) e.getSource()).getValueAt(linha, 1); // Suponha que o produto esteja na coluna 1
                int quantidadeAlterada = quantidadeAtual - quantidadeAnterior;
                adicionaTextoTabela2(quantidadeAlterada, produto);
            }
        }
    }

    private void adicionaTextoTabela2(int quantidadeAlterada, String produto) {
        String texto = "";
        if (quantidadeAlterada > 0) {
            texto = "Atenção, foram adicionados " + quantidadeAlterada + " de " + produto;
        } else if (quantidadeAlterada < 0) {
            texto = "Atenção, foram retirados " + Math.abs(quantidadeAlterada) + " de " + produto;
        }
        tbRegModel.addRow(new Object[]{texto});
    }
}
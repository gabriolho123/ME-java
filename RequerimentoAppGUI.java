package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import modelo.entidades.Aluno;
import modelo.entidades.TipoRequerimento;
import modelo.entidades.Requerimento;
import modelo.entidades.Status;
import modelo.entidades.Boleto;
import modelo.entidades.Responsavel;

// A classe principal herda de JFrame para criar a janela.
public class RequerimentoAppGUI extends JFrame { 
    
    // LINHA ESSENCIAL: Corrige o erro de serialização do Eclipse (vermelho ou amarelo)
    private static final long serialVersionUID = 1L; 

    // Componentes da GUI
    private JPanel mainPanel;
    private JComboBox<String> tipoRequerimentoComboBox;
    private JTextArea detalhesArea;
    private JButton abrirRequerimentoButton;
    private JLabel resultadoLabel;

    // Dados de teste FIXOS (para simulação inicial, como nos seus arquivos)
    private Aluno alunoTeste = new Aluno("123456", "Maria da Silva");
    private TipoRequerimento tipoCertificado = new TipoRequerimento("Certificado", 10.00);
    private TipoRequerimento tipoDesistencia = new TipoRequerimento("Desistência", 0.00);

    // Construtor: Configura a interface e seus componentes
    public RequerimentoAppGUI() {
        // Configurações básicas da janela (como nas suas imagens)
        setTitle("Módulo de Requerimento HABILITA -  Teste POO");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        
        // Inicialização dos componentes
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // JComboBox para Tipo de Requerimento
        String[] tipos = {"Certificado", "Desistência"};
        tipoRequerimentoComboBox = new JComboBox<>(tipos);
        mainPanel.add(new JLabel("Tipo de Requerimento:"));
        mainPanel.add(tipoRequerimentoComboBox);

        // JTextArea para Detalhes
        detalhesArea = new JTextArea(5, 20);
        mainPanel.add(new JLabel("Detalhes da Solicitação:"));
        mainPanel.add(new JScrollPane(detalhesArea));

        // Botão de Ação
        abrirRequerimentoButton = new JButton("Abrir Requerimento");
        mainPanel.add(abrirRequerimentoButton);

        // Label de Resultado
        resultadoLabel = new JLabel("Status: Aguardando...");
        mainPanel.add(resultadoLabel);
        
        // Adiciona o painel principal à janela
        this.add(mainPanel);

        // Adiciona o Listener ao botão
        abrirRequerimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirNovoRequerimento();
            }
        });
    }
    
    // Método de Simulação de Abertura de Requerimento
    private void abrirNovoRequerimento() {
        
        // 1. Coleta dados da GUI
        String tipoSelecionado = (String) tipoRequerimentoComboBox.getSelectedItem();
        TipoRequerimento tipoParaRequerimento = tipoSelecionado.equals("Certificado") ? tipoCertificado : tipoDesistencia;
        
        // 2. Cria o novo Requerimento
        // O número é apenas um ID de simulação
        Requerimento novoRequer = new Requerimento("REQ-" + (int)(Math.random() * 1000), alunoTeste, tipoParaRequerimento);
        
        // 3. Aplica regras de negócio (simulação)
        String logBoleto = "NÃO APLICÁVEL";
        if (tipoParaRequerimento.getValorTaxa() > 0) {
            // Simula a criação de um Boleto
            Boleto logBoletoGerado = new Boleto("BLT-" + novoRequer.getNumero(), tipoParaRequerimento.getValorTaxa());
            novoRequer.setBoletoGerado(logBoletoGerado);
            logBoleto = "Gerado: " + logBoletoGerado.getNumero() + " (R$ " + logBoletoGerado.getValor() + ")";
        }
        
        // 4. Exibe o resultado da simulação
        resultadoLabel.setText("Requerimento " + novoRequer.getNumero() + " ABERTO com sucesso!");
        
        // Apenas para ver no Console (ajuda no debug)
        System.out.println("------------------------------------");
        System.out.println("Novo Requerimento Aberto:");
        System.out.println("Número: " + novoRequer.getNumero());
        System.out.println("Solicitante: " + novoRequer.getSolicitante().getNome());
        System.out.println("Tipo: " + novoRequer.getTipo().getNome());
        System.out.println("Status Inicial: " + novoRequer.getStatusAtual().getNome());
        System.out.println("Info Pagamento: " + logBoleto);
        System.out.println("------------------------------------");
    }

    // MÉTODO MAIN: Inicia a aplicação (OBRIGATÓRIO)
    public static void main(String[] args) {
        // Usa SwingUtilities.invokeLater para garantir que a GUI seja iniciada na Thread segura do Swing
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Instancia a classe e torna a janela visível
                new RequerimentoAppGUI().setVisible(true); // Inicia a janela
            }
        });
    }
}
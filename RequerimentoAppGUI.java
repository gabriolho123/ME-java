package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.entidades.Aluno;
import modelo.entidades.TipoRequerimento;
import modelo.entidades.Requerimento;
import modelo.entidades.Status;
import modelo.entidades.Boleto;
import modelo.entidades.Responsavel;

// A classe principal herda de JFrame para criar a janela.
public class RequerimentoAPPgui extends JFrame { 

    // LINHA ESSENCIAL: Corrige o erro de serializa��o do Eclipse (vermelho ou amarelo)
    private static final long serialVersionUID = 1L; 

    // Componentes da GUI
    private JPanel mainPanel;
    private JComboBox<String> tipoRequerimentoComboBox;
    private JTextArea detalhesArea;
    private JButton abrirRequerimentoButton;
    private JLabel resultadoLabel;

    // Dados de teste FIXOS (para simula��o inicial)
    // Usando construtor com String e String (Matricula e Nome)
    private Aluno alunoTeste = new Aluno("123456", "Maria da Silva"); 
    private TipoRequerimento tipoCertificado = new TipoRequerimento("Certificado", 10.00);
    private TipoRequerimento tipoDesistencia = new TipoRequerimento("Desist�ncia", 0.00);

    // Construtor: Configura a interface e seus componentes
    public RequerimentoAPPgui() {
        // Configura��es b�sicas da janela 
        setTitle("M�dulo de Requerimento HABILITA - Teste POO");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        
        // Inicializa��o dos componentes
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // JComboBox para Tipo de Requerimento
        String[] tipos = {"Certificado", "Desist�ncia"};
        tipoRequerimentoComboBox = new JComboBox<>(tipos);
        mainPanel.add(new JLabel("Tipo de Requerimento:"));
        mainPanel.add(tipoRequerimentoComboBox);

        // JTextArea para Detalhes
        detalhesArea = new JTextArea(5, 20);
        mainPanel.add(new JLabel("Detalhes da Solicita��o:"));
        mainPanel.add(new JScrollPane(detalhesArea));

        // Bot�o de A��o
        abrirRequerimentoButton = new JButton("Abrir Requerimento");
        mainPanel.add(abrirRequerimentoButton);

        // Label de Resultado
        resultadoLabel = new JLabel("Status: Aguardando...");
        mainPanel.add(resultadoLabel);
        
        // Adiciona o painel principal � janela
        this.add(mainPanel);

        // Adiciona o Listener ao bot�o
        abrirRequerimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirNovoRequerimento();
            }
        });
    }
    
    // M�todo de Simula��o de Abertura de Requerimento
    private void abrirNovoRequerimento() {
        
        // 1. Coleta dados da GUI
        String tipoSelecionado = (String) tipoRequerimentoComboBox.getSelectedItem();
        TipoRequerimento tipoParaRequerimento = tipoSelecionado.equals("Certificado") ? tipoCertificado : tipoDesistencia;
        
        // 2. Cria o novo Requerimento
        Requerimento novoRequer = new Requerimento("REQ-" + (int)(Math.random() * 1000), alunoTeste, tipoParaRequerimento);
        
        // 3. Aplica regras de neg�cio (simula��o)
        String logBoleto = "N�O APLIC�VEL";
        if (tipoParaRequerimento.getValorTaxa() > 0) {
            // Simula a cria��o de um Boleto
            Boleto logBoletoGerado = new Boleto("BLT-" + novoRequer.getNumero(), tipoParaRequerimento.getValorTaxa());
            novoRequer.setBoletoGerado(logBoletoGerado);
            
            // LINHA CORRIGIDA: getNumero() e getValor() s�o chamados
            logBoleto = "Gerado: " + logBoletoGerado.getNumero() + " (R$ " + logBoletoGerado.getValor() + ")"; 
        }
        
        // 4. Exibe o resultado da simula��o
        resultadoLabel.setText("Requerimento " + novoRequer.getNumero() + " ABERTO com sucesso!");
        
        // Apenas para ver no Console (ajuda no debug)
        System.out.println("------------------------------------");
        System.out.println("Novo Requerimento Aberto:");
        System.out.println("N�mero: " + novoRequer.getNumero());
        System.out.println("Solicitante: " + novoRequer.getSolicitante().getNome());
        System.out.println("Tipo: " + novoRequer.getTipo().getNome());
        System.out.println("Status Inicial: " + novoRequer.getStatusAtual().getNome());
        System.out.println("Info Pagamento: " + logBoleto);
        System.out.println("------------------------------------");
    }

    // M�TODO MAIN: Ponto de entrada da aplica��o
    public static void main(String[] args) { // String[] args � OBRIGAT�RIO e est� aqui.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RequerimentoAPPgui().setVisible(true); 
            }
        });
    }
}

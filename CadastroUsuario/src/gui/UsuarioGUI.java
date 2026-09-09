package gui;

import dao.UsuarioDAO;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;

public class UsuarioGUI extends JFrame {

    private final JTextField txtNome = new JTextField();
    private final JTextField txtCpf = new JTextField();
    private final JTextField txtEmail = new JTextField();
    private final JTextField txtTelefone = new JTextField();

    public UsuarioGUI() {
        setTitle("Cadastro de Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 360);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel lblTitulo = new JLabel("Cadastro de Usuário", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 8, 12));
        painelCampos.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Cadastrar novo usuário"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(txtNome);
        painelCampos.add(new JLabel("CPF:"));
        painelCampos.add(txtCpf);
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(txtEmail);
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(txtTelefone);

        add(painelCampos, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnSair = new JButton("Sair");

        btnCadastrar.addActionListener(e -> cadastrar());
        btnLimpar.addActionListener(e -> limpar());
        btnSair.addActionListener(e -> System.exit(0));

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnSair);

        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void cadastrar() {
        if (txtNome.getText().trim().isEmpty()
                || txtCpf.getText().trim().isEmpty()
                || txtEmail.getText().trim().isEmpty()
                || txtTelefone.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Os campos não podem retornar vazios");
            return;
        }

        try {
            Usuario usuario = new Usuario();
            usuario.setNome(txtNome.getText());
            usuario.setCpf(txtCpf.getText());
            usuario.setEmail(txtEmail.getText());
            usuario.setTelefone(txtTelefone.getText());

            UsuarioDAO dao = new UsuarioDAO();
            dao.adiciona(usuario);

            JOptionPane.showMessageDialog(this,
                    "Usuário " + txtNome.getText() + " inserido com sucesso!");
            limpar();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpar() {
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UsuarioGUI().setVisible(true));
    }
}

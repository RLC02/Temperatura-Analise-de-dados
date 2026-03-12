import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SistemaTemperaturas {

    static JTextField cidade[] = new JTextField[3];
    static JTextField temp[][] = new JTextField[3][12];
    static JTextArea resultado;

    public static void main(String[] args) {

        JFrame janela = new JFrame("Sistema de Temperaturas");
        janela.setSize(600,600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3,13));

        for(int i = 0; i < 3; i++) {

            cidade[i] = new JTextField("Cidade " + (i+1));
            painel.add(cidade[i]);

            for(int j = 0; j < 12; j++) {
                temp[i][j] = new JTextField();
                temp[i][j].setBorder(BorderFactory.createTitledBorder("M" + (j+1)));
                painel.add(temp[i][j]);
            }
        }

        JButton botao = new JButton("Calcular médias");

        resultado = new JTextArea();
        resultado.setEditable(false);

        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String texto = "";

                for(int i = 0; i < 3; i++) {

                    float soma = 0;

                    for(int j = 0; j < 12; j++) {
                        soma += Float.parseFloat(temp[i][j].getText());
                    }

                    float media = soma / 12;

                    String roupa;

                    if(media < 15)
                        roupa = "Casaco pesado";
                    else if(media < 25)
                        roupa = "Roupa moderada";
                    else
                        roupa = "Roupa leve";

                    texto += "Cidade: " + cidade[i].getText() +
                            " | Média: " + media +
                            " C | Roupa: " + roupa + "\n";
                }

                resultado.setText(texto);
            }
        });

        janela.add(painel, BorderLayout.CENTER);
        janela.add(botao, BorderLayout.NORTH);
        janela.add(new JScrollPane(resultado), BorderLayout.SOUTH);

        janela.setVisible(true);
    }
}
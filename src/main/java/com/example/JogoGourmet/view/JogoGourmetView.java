package com.example.JogoGourmet.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.example.JogoGourmet.model.Dish;
import com.example.JogoGourmet.resource.JogoGourmetResource;

import lombok.Getter;
import lombok.Setter;

public class JogoGourmetView {
	
	@Getter
	@Setter
	private static Dish firstDish;
	
	private static JogoGourmetResource resource;
	
	public static void onBeforeInit() {
        Dish lasanha = new Dish();
        lasanha.setDescription("Lasanha");
        lasanha.setNext(null);
        lasanha.setDifferent(null);

        Dish bolo = new Dish();
        bolo.setDescription("Bolo de Chocolate");
        bolo.setNext(null);
        bolo.setDifferent(null);

        Dish massa = new Dish();
        massa.setDescription("Massa");
        massa.setNext(lasanha);
        massa.setDifferent(bolo);
        firstDish = massa;
	}

    public static JFrame getFrame() {
    	resource = new JogoGourmetResource();
        JFrame frame;
        JLabel label = new JLabel("Pense em um prato que gosta");
        label.setBounds(43, 5, 220, 40);
        JButton button = new JButton("OK");
        button.setBounds(100,50, 60, 25);
        
        onBeforeInit();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resource.init(firstDish);
            }
        });

        frame = new JFrame("Jogo Gourmet");
        frame.add(button);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(272,124);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        return frame;
    }
    
	public static void rightAnswer() {
		JOptionPane.showMessageDialog(null, "Acertei de novo!", "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
	}

	public static int nextQuestion(String description) {
		return JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + description + " ?", "Confirm",
				JOptionPane.YES_NO_OPTION);
	}

	public static String newDish() {
		return JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", JOptionPane.QUESTION_MESSAGE);
	}

	public static String differenceBetweenDishes(String newDish, String currentDish) {
		return JOptionPane.showInputDialog(null, newDish + " é ________ mas " + currentDish + " não.", "Complete",
				JOptionPane.QUESTION_MESSAGE);
	}
	    
}

package com.example.JogoGourmet;

import javax.swing.JFrame;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.JogoGourmet.view.JogoGourmetView;


@SpringBootApplication
public class JogoGourmetApplication {

	public static void main(String[] args) {
		JogoGourmetView view = new JogoGourmetView();
        JFrame principal = view.getFrame();
        principal.setVisible(true);
	}

}

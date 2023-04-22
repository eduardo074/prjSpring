package br.ifba.eduardosouza.prjSpring;

import br.ifba.eduardosouza.prjSpring.views.Dashboard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class PrjSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(PrjSpringApplication.class, args);


		if (!GraphicsEnvironment.isHeadless()) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new Dashboard().setVisible(true);
				}
			});
		}
	}

}

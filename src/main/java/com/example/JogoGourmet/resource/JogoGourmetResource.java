package com.example.JogoGourmet.resource;

import javax.swing.JOptionPane;

import com.example.JogoGourmet.model.Dish;
import com.example.JogoGourmet.view.JogoGourmetView;

public class JogoGourmetResource {

	public void init(Dish Dish) {
		ask(Dish);
	}

	public Dish ask(Dish current) {
		int option = JogoGourmetView.nextQuestion(current.getDescription());
		Dish newDish;
		switch (option) {
		case 0:
			if (current.getNext() == null) {
				JogoGourmetView.rightAnswer();
				newDish = null;
			} else {
				newDish = ask(current.getNext());
				if (newDish != null) {
					current.setNext(newDish);
					newDish = null;
				}
			}
			break;
		case 1:
			if (current.getDifferent() == null) {
				newDish = insertNewDish(current);
			} else {
				newDish = ask(current.getDifferent());
				if (newDish != null) {
					current.setDifferent(newDish);
					newDish = null;
				}
			}
			break;
		default:
			newDish = null;
			break;
		}
		return newDish;
	}

	public Dish insertNewDish(Dish current) {
		String newDescription = JogoGourmetView.newDish();
		newDescription = newDescription.trim();
		if (newDescription != null && !newDescription.isEmpty()) {
			Dish newDish = new Dish();
			newDish.setDescription(newDescription);
			newDish.setNext(null);
			newDish.setDifferent(null);

			String differentDishDescription = JogoGourmetView.differenceBetweenDishes(newDescription,
					current.getDescription());
			differentDishDescription = differentDishDescription.trim();

			if (differentDishDescription != null && !differentDishDescription.isEmpty()) {
				Dish differentDish = new Dish();
				differentDish.setDescription(differentDishDescription);
				differentDish.setNext(newDish);
				differentDish.setDifferent(current);
				return differentDish;
			} else {
				callExceptionEmptyField();
			}
		} else {
			callExceptionEmptyField();
		}

		return null;
	}

	private void callExceptionEmptyField() {
		try {
			throw new Exception("Campo obrigatório não preenchido.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campo obrigatório não preenchido.", "Erro",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}

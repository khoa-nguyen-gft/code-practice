package design_pattern.constructor_factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.reflections.Reflections;

public class Step04 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
		HotDrinkMachine machine = new HotDrinkMachine();
		
		machine.makeCoffee().consume();
	}
	
	
}


class HotDrinkMachine {
	private List<Pair<String, HotDrinkFactory>> nameFactories = new ArrayList<Pair<String, HotDrinkFactory>>();
	
	public HotDrinkMachine() throws InstantiationException, IllegalAccessException {
		Set<Class<? extends HotDrinkFactory>> types = new Reflections("").getSubTypesOf(HotDrinkFactory.class);
		
		System.out.println("type" + types);
		
		for (Class<? extends HotDrinkFactory> type : types) {
			MutablePair<String, HotDrinkFactory> pair = new MutablePair<>(type.getSimpleName().replace("Factory", ""), type.newInstance());
			nameFactories.add(pair);
		}
		
		System.out.println("name Factories: " + nameFactories);
	}
	
	public HotDrink makeCoffee() throws IOException {
		System.out.println("Available drinks: ");
		
		for (int i = 0; i < nameFactories.size(); i++) {
			Pair<String, HotDrinkFactory> pair = nameFactories.get(i);
			System.out.println(i + ": " + pair.getKey());
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		
		while (true) {
			String kind = reader.readLine();
			
			if(kind == null || "".equals(kind) ) {
				System.out.println("Please enter kind of Drink again!0");
				continue;
			}
			
			if(Integer.parseInt(kind) <= nameFactories.size()) {
				System.out.println("Specify amount:  ");
				String amount = reader.readLine();
				HotDrink hotDrink = nameFactories.get(Integer.parseInt(kind)).getValue().prepare(Integer.parseInt(amount));
				return hotDrink;
			}
		}
	}
}


interface HotDrink {
	void consume();
}


interface HotDrinkFactory{
	HotDrink prepare(int amount);
}

class TeaHotDrinkFactory implements HotDrinkFactory {

	@Override
	public HotDrink prepare(int amount) {
		System.out.println("Put in tea, boil water, pour " + amount + " ml, "
				+ " and lemonn enjoy!");
		return new TeaHotDrink();
	}
	
}


class CoffeeHotDrinkFactory implements HotDrinkFactory {

	@Override
	public HotDrink prepare(int amount) {
		System.out.println("Grind some beans, boil water, pour " + amount + " ml, "
				+ " and cream and sugar, enjoy!");
		return new CoffeeHotDrink();
	}
	
}

class CoffeeHotDrink implements HotDrink {

	@Override
	public void consume() {
		System.out.println("Coffee Hot Drink is delicies");
	}
	
}


class TeaHotDrink implements HotDrink {

	@Override
	public void consume() {
		System.out.println("Tea Hot Drink is delicies");
	}
	
}
package main;

import data.FelineInterface;
import persistance.FelineRepository;
import persistance.FelineRepositoryInterface;

public class TestApplication {
	public static void main(String[] args) {
		FelineRepositoryInterface fr = new FelineRepository();
		((FelineRepository)fr).generate();
		for(FelineInterface f : fr.findAll()){
			System.out.println(f);
		}
		System.out.println();
		
		System.out.println(fr.findById(2) + "\n");
		
		System.out.println(fr.findById(1000) + "\n");
				
		FelineInterface cat = fr.findById(2);
		cat.setName("New Name");
		for(FelineInterface f : fr.findAll()){
			System.out.println(f);
		}
		System.out.println();
		
//		FelineInterface cat1 = fr.findById(110);
//		if(cat1 != null) {
//			cat1.setName("New Name - Joric");
//			for(FelineInterface f : fr.findAll()){
//				System.out.println(f);
//			}
//		}
//		System.out.println();
		
		//System.out.println(((FelineRepository)fr).findByName("Arnold"));
		
		((FelineRepository)fr).findByName("Arnold").forEach(f -> System.out.println(f));
		
//		for(FelineInterface f : ((FelineRepository)fr).findByName("Arnold")) {
//			System.out.println(f);
//		}
		
		System.out.println();
		for(FelineInterface f : ((FelineRepository)fr).findByName("Mahmud")) {
			System.out.println(f);
		}
		System.out.println();
		for(FelineInterface f : ((FelineRepository)fr).findByName("New Name")) {
			System.out.println(f);
		}
		System.out.println();
		
		
		((FelineRepository)fr).findByRace("Russian").forEach(f -> System.out.println(f));
		
		
//		for(FelineInterface f : ((FelineRepository)fr).findByRace("Russian")) {
//			System.out.println(f);
//		}
		System.out.println();
		for(FelineInterface f : ((FelineRepository)fr).findByRace("Arabian")) {
			System.out.println(f);
		}
		System.out.println();
		for(FelineInterface f : ((FelineRepository)fr).findByRace("Mongol")) {
			System.out.println(f);
		}
		System.out.println();
	}
}
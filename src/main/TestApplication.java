package main;

import java.util.ArrayList;
import java.util.List;

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
		
		FelineInterface catTest1 = fr.findById(9);
		System.out.println(fr.findById(9));
		System.out.println(catTest1);
		System.out.println();
		
		catTest1.setName("Vasilisa");
		System.out.println(fr.findById(9));
		System.out.println(catTest1);
		System.out.println();
		
		FelineInterface catTest2 = null;
		try {
			catTest2 = ((FelineInterface)catTest1).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println(fr.findById(9));
		System.out.println(catTest1);
		System.out.println(catTest2);
		System.out.println();
		
		catTest2.setName("Maricica");
		System.out.println(fr.findById(9));
		System.out.println(catTest1);
		System.out.println(catTest2);
		System.out.println();
		
		catTest1.setRace("Japan");
		System.out.println(fr.findById(9));
		System.out.println(catTest1);
		System.out.println(catTest2);
		System.out.println();
		
		System.out.println(fr.findById(4));
		FelineInterface catTest3 = fr.findById(4);
		System.out.println(fr.findById(4));
		System.out.println(catTest3);
		System.out.println();
		
		catTest3.setName("Bambula");
		System.out.println(fr.findById(4));
		System.out.println(catTest3);
		System.out.println();
		
		fr.update(catTest3);
		System.out.println(fr.findById(4));
		System.out.println(catTest3);
		System.out.println();
		
		for(FelineInterface f : fr.findByName("Arnold")){
			System.out.println(f);
		}
		System.out.println();
		List<FelineInterface> clonedName = new ArrayList<FelineInterface>();
		clonedName = fr.findByName("Arnold");
		for(FelineInterface f : clonedName){
			System.out.println(f);
		}
		System.out.println();
		
		for(FelineInterface f : fr.findByRace("Arabian")){
			System.out.println(f);
		}
		System.out.println();
		List<FelineInterface> clonedRace = new ArrayList<FelineInterface>();
		clonedRace = fr.findByRace("Arabian");
		for(FelineInterface f : clonedRace){
			System.out.println(f);
		}
		System.out.println();
	}
}
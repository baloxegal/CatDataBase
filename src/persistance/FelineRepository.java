package persistance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import data.Cat;
import data.FelineInterface;

public class FelineRepository implements FelineRepositoryInterface {
	
	//STORAGE
	
	private List<FelineInterface> felines;

	public FelineRepository() {
		felines = new ArrayList<FelineInterface>();
	}

	@Override
	public boolean save(FelineInterface feline) {
		if(!update(feline))
			felines.add(feline);
		return true;
	}

	@Override
	public boolean delete(FelineInterface feline) {

//		for(FelineInterface f : felines) {
//			if(f.getId().equals(feline.getId())) {
//				felines.remove(f);
//				return true;
//			}
//		}

		felines.stream()
				.filter(f -> f.getId().equals(feline.getId()))
				.map(f -> {felines.remove(f); return true;});
		
		return false;
	}

	@Override
	public boolean update(FelineInterface feline) {

//		for(FelineInterface f : felines) {
//			if(f.getId().equals(feline.getId())) {
//				felines.set(felines.indexOf(f), feline);
//				return true;
//			}
//		}
		
		felines.stream()
				.filter(f -> f.getId().equals(feline.getId()))
				.map(f -> {felines.set(felines.indexOf(f), feline); return true;});
		
		return false;
	}	
	@Override
	public List<FelineInterface> findAll() {
//		List<FelineInterface> felinesClon = new ArrayList<FelineInterface>();
//		for(FelineInterface f : felines) {
//			try {
//				felinesClon.add(f.clone());
//			} catch (CloneNotSupportedException e) {
//				e.printStackTrace();
//			}
//		}
		List<FelineInterface> felinesClon = felines.stream()
													.map(f -> {
														try {
															return f.clone();
														} catch (CloneNotSupportedException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
														return null;
													})
													.collect(Collectors.toList());
		
		return felinesClon;
	}
	
	@Override
	public FelineInterface findById(Integer id){
		
//		for(FelineInterface f : felines) {
//			if(f.getId().equals(id))
//				try {
//					return f.clone();
//				} catch (CloneNotSupportedException e) {
//					e.printStackTrace();
//				}
//		}

		
		felines.stream()
				.filter(f -> f.getId().equals(id))
			  	.map(f -> {
			  		try {
			  			return f.clone();
			  		} catch (CloneNotSupportedException e) {
			  			// TODO Auto-generated catch block
			  			e.printStackTrace();
			  		}
			  		return null;
			  	});
		System.out.println("Super!");
		return null;
	}
	
	public void generate(){
		felines.add(new Cat(1, "Arnold", "Russian", 6));
		felines.add(new Cat(2, "Mahmud", "Arabian", 8));
		felines.add(new Cat(3, "Arnold", "Japan", 4));
		felines.add(new Cat(4, "Petea", "Russian", 12));
		felines.add(new Cat(5, "John", "American", 3));
		felines.add(new Cat(6, "Abdula", "Arabian", 6));
		felines.add(new Cat(7, "Mahmud", "Arabian", 9));
		felines.add(new Cat(8, "Mack", "American", 12));
		felines.add(new Cat(9, "Mahmud", "Russian", 8));
	}

	@Override
	public List<FelineInterface> findByName(String name){
		
//		List<FelineInterface> felinesTmpClone = new ArrayList<FelineInterface>();
//		felines.forEach(f -> {if(f.getName().equals(name))
//			try {
//				felinesTmpClone.add(f.clone());
//			} catch (CloneNotSupportedException e) {
//				e.printStackTrace();
//			}});
		
		List<FelineInterface> felinesTmpClone = felines.stream()
														.filter(f -> f.getName().equals(name))
														.map(f -> {
															try {
																return f.clone();
															} catch (CloneNotSupportedException e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}
															return null;
														})
														.collect(Collectors.toList());
		
		return felinesTmpClone;
	}
	
	@Override
	public List<FelineInterface> findByRace(String race){
		
//		List<FelineInterface> felinesTmpClone = new ArrayList<FelineInterface>();
//		felines.forEach(f -> {if(f.getRace().equals(race))
//			try {
//				felinesTmpClone.add(f.clone());
//			} catch (CloneNotSupportedException e) {
//				e.printStackTrace();
//			}});
		
		List<FelineInterface> felinesTmpClone = felines.stream()
			  									.filter(f -> f.getRace().equals(race))
			  									.map(f -> {
			  										try {
			  											return f.clone();
			  										} catch (CloneNotSupportedException e) {
			  											// TODO Auto-generated catch block
			  											e.printStackTrace();
			  										}
			  										return null;
			  									})
			  									.collect(Collectors.toList());
		
		return felinesTmpClone;
	}
}
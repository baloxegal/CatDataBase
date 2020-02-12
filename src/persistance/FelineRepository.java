package persistance;

import java.util.ArrayList;
import java.util.List;

import data.Cat;
import data.FelineInterface;

public class FelineRepository implements FelineRepositoryInterface {
	
	//STORAGE
	
	private List<FelineInterface> felines;

	public FelineRepository() {
		felines = new ArrayList<>();
	}

	@Override
	public boolean save(FelineInterface feline) {
		
		return false;
	}

	@Override
	public boolean delete(FelineInterface feline) {
		
		return false;
	}

	@Override
	public boolean update(FelineInterface feline) {
		
		return false;
	}

	@Override
	public List<FelineInterface> findAll() {
		return felines;
	}
	
	@Override
	public FelineInterface findById(Integer id){
		//FelineInterface fTmp = null;
		for(FelineInterface f : felines) {
			if(f.getId().equals(id))
				return f;
				//fTmp = f;
		}
		//if(fTmp == null)
			//System.out.println("The object with ID " + id + " not found!");
		//return fTmp;
		return null;
	}
	
	//FOR TEST
	//FILL THE LIST THE DATA
	
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

	 //--- getByName(String name) -> List<FelineInterface>
	 //--- getByRace(String race) -> List<FelineInterface>
	
	@Override
	public List<FelineInterface> findByName(String name){
		List<FelineInterface> felinesTmp = new ArrayList<FelineInterface>();
		//felines.forEach(f -> {if(f.getName() == name) felineTmp.add(f);});
		felines.forEach(f -> {if(f.getName().equals(name)) felinesTmp.add(f);});
//		if(felinesTmp.size() != 0) {
//			return felinesTmp;
//		}
//		return null;
		
		return felinesTmp;
	}
	
	@Override
	public List<FelineInterface> findByRace(String race){
		List<FelineInterface> felinesTmp = new ArrayList<FelineInterface>();
		//felines.forEach(f -> {if(f.getRace() == race) felineTmp.add(f);});
		felines.forEach(f -> {if(f.getRace().equals(race)) felinesTmp.add(f);});
//		if(felinesTmp.size() != 0) {
//		return felinesTmp;
//	}
//	return null;
	
		return felinesTmp;
	}

}
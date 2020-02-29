package persistance;

import java.util.List;

import data.FelineInterface;

public interface FelineRepositoryInterface {
	
	public boolean save (FelineInterface feline);
	public boolean delete (FelineInterface feline);
	public boolean update (FelineInterface feline); 
	public List<FelineInterface> findAll()throws CloneNotSupportedException;
	public FelineInterface findById(Integer id);
	public List<FelineInterface> findByName(String name);
	public List<FelineInterface> findByRace(String race);
	
}
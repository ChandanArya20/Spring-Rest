package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Tourist;

public interface ITouristMnmtService {

	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTourisById(Integer id);
	public String modifyTourist(Tourist tourist);
	public String updateTouristBudgetById(Integer id, Float hikePercent);
	public String deleteTouristById(Integer id);
	
}

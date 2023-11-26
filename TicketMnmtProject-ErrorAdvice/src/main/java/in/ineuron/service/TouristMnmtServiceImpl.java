package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ITouristRepo;
import in.ineuron.exception.TouristNotFoundException;
import in.ineuron.model.Tourist;

@Service
public class TouristMnmtServiceImpl implements ITouristMnmtService{

	@Autowired
	ITouristRepo repo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		
		Integer id=repo.save(tourist).getId();
		
		return "Tourist is registerd having the ticket id "+id;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		return (List<Tourist>) repo.findAll();
	}

	@Override
	public Tourist fetchTourisById(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			throw new TouristNotFoundException("Tourist with id "+id+" not found");
	}

	@Override
	public String modifyTourist(Tourist tourist) {
		Optional<Tourist> optional = repo.findById(tourist.getId());
		if(optional.isPresent()) {
			repo.save(tourist);
			return "Tourist with id "+tourist.getId()+" updated successfully...";			
		}
		else
			throw new TouristNotFoundException("Tourist with id "+tourist.getId()+" not found for updation");
		
	}

	@Override
	public String updateTouristBudgetById(Integer id, Float hikePercent) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(hikePercent/100)));
			repo.save(tourist);
			return "Tourist with id "+tourist.getId()+" updated successfully...";			
		}
		else
			throw new TouristNotFoundException("Tourist with id "+id+" not found for updation");
		
	}

	@Override
	public String deleteTouristById(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			repo.deleteById(id);
			return "Tourist with id "+tourist.getId()+" deleted successfully...";			
		}
		else
			throw new TouristNotFoundException("Tourist with id "+id+" not found for deletion");

	}

}

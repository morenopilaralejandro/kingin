package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamRepository repo;
	
	@Override
	public List<Team> all() {
		return repo.findAll();
	}
	
	@Override
	public Team one(Long id) {
		return repo.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
	}
	
	@Override
	public Team insert(Team newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Team replace(Team newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setTeamUuid(newObj.getTeamUuid());
			oldObj.setTeamDateCrt(newObj.getTeamDateCrt());
			oldObj.setTeamDateMod(newObj.getTeamDateMod());
			oldObj.setTeamIsPriv(newObj.getTeamIsPriv());
			oldObj.setUsr(newObj.getUsr());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setTeamId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}

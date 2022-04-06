package com.kan.admin.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.kan.admin.dao.Admindao;
import com.kan.admin.vo.State;

@Service
public class StateService {
	
	private static final Logger logger = LoggerFactory.getLogger(StateService.class);

	@Autowired
	private Admindao admindao;
	public State saveState(@RequestBody State state)
	{
		Long a=admindao.queryForSave("master.state.add",new Object[] {state.getState()});
		if(a!=0)
			return state;
			
		else
			return null;
		
	}
	public List<State> getAllState()
	{
		List<State> allState=admindao.findAll("master.state.all",State.class);
		 return allState;
		
	}
	
	public Object getState(@PathVariable("state_id") int state_id)
	{
		Object myObject=admindao.findById("master.state.getById",new Object[]{state_id},State.class);
		return myObject;
		
	}
	
	public void deleteState(@PathVariable("state_id") int state_id)
	{
		
//		 staterepo.deleteById(state_id);
		admindao.delete("master.state.delete",new Object[]{state_id});
		
	}
	public Long updateState(@RequestBody State state,@PathVariable("state_id") int state_id)
	{
	
		long myObject=admindao.queryForUpdate("master.state.update",new Object[]{state.getState(),state_id});
		return myObject;
//		return state.getState();
		
	}

}

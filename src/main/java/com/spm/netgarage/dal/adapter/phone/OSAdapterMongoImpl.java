package com.spm.netgarage.dal.adapter.phone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spm.netgarage.dal.model.phone.OSModel;
import com.spm.netgarage.dal.repository.phone.OSRepository;
import com.spm.netgarage.domain.phone.OSDataAdapter;

@Component
public class OSAdapterMongoImpl implements OSDataAdapter {
	
	private OSRepository osRepository;
	
	@Autowired
	public OSAdapterMongoImpl(OSRepository osRepository) {
		this.osRepository = osRepository;
	}

	@Override
	public OSModel save(OSModel os) {
		System.out.println("Adding OS :  " +os.getName());
		return osRepository.save(os);
	}

	@Override
	public List<OSModel> getAll() {
		System.out.println("Returning all OS es");
		return osRepository.findAll();
	}

	@Override
	public OSModel getById(String id) {
		return osRepository.findById(id).get();
	}

	@Override
	public String update(OSModel os) {
		
		OSModel updatedOS = osRepository.save(os);
		System.out.println("Updated OS with id : " + os.getId());
		return updatedOS.getId();
	}

	@Override
	public String delete(String id) {
		System.out.println("Deleting OS with ID : " + id);
		osRepository.deleteById(id);
		return id;
	}

	@Override
	public OSModel getByName(String name) {
		return osRepository.findByName(name);
	}

}

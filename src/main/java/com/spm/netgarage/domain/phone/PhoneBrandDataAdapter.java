package com.spm.netgarage.domain.phone;

import java.util.List;

import com.spm.netgarage.dal.model.phone.PhoneBrandModel;

public interface PhoneBrandDataAdapter {
	
	public String save(PhoneBrandModel phoneBrandModel);
	public List<PhoneBrandModel> getAll();
	public PhoneBrandModel getById(String id);
	public PhoneBrandModel getByName(String name);
	public String update(PhoneBrandModel phoneBrandModel);
	public String delete(String id);

}

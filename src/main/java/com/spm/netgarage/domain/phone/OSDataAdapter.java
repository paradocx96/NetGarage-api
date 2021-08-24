package com.spm.netgarage.domain.phone;

import java.util.List;

import com.spm.netgarage.dal.model.phone.OSModel;

public interface OSDataAdapter {
	
	public OSModel save (OSModel os);
	public List<OSModel> getAll();
	public OSModel getById (String id);
	public String update( OSModel os);
	public String delete (String id);
	public OSModel getByName(String name);

}

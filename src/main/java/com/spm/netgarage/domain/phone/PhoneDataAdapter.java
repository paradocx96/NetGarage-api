package com.spm.netgarage.domain.phone;

import java.util.List;

import com.spm.netgarage.dal.model.phone.PhoneModel;
import com.spm.netgarage.dto.phone.ImageUpdateRequest;

public interface PhoneDataAdapter {
	
	public String save(PhoneModel phoneModel);
	public List<PhoneModel> getAll();
	public PhoneModel getById(String id);
	public List<PhoneModel> getByBrandModel(String brandModel);
	public String updateById( PhoneModel phoneModel);
	public String delete(String id);
	public List<PhoneModel> getByBrand(String brand);
	public List<PhoneModel> getByOs(String os);
	public List<PhoneModel> getByChipset(String chipset);
	public List<PhoneModel> getByPublishedStatus(String status);
	public String publishPhone(String id);
	public String unpublishPhone(String id);
	public String updateImageUrl(ImageUpdateRequest imegeUpdateRequest);
	
	

}

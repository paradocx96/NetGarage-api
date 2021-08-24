package com.spm.netgarage.domain.phone;

import java.util.List;

import com.spm.netgarage.dal.model.phone.ChipsetModel;

public interface ChipsetDataAdapter {
	
	public String save(ChipsetModel chipset);
	public List<ChipsetModel> getAll ();
	public ChipsetModel getById(String id);
	public String updateById(String id, ChipsetModel chipset);
	public String delete(String id);
	public ChipsetModel getByBrandAndModel(String brandAndModel);

}

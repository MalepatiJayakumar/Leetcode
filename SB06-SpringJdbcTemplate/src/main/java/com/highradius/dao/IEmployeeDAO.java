package com.highradius.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {
	public List<Map<String,Object>> getAllEmployees();
}
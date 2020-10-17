package com.greenfield.dao;

import java.util.Date;
import java.util.List;

import com.greenfield.model.Dependent;

public interface DependentDao {
	
	public List<Dependent> FindAllDependents();
	
	public List<Dependent> AddNewDependent(Dependent dependent);
	
	public Dependent FindDependentById(int id);
	
	public List<Dependent> AddToListOfDependents(List<Dependent> depList, Dependent dependent);
	
	public void InsertDependentWithEnrollee(int enrolleeId, String firstName, String lastName, Date birthday);
	
	public void DeleteDependent(int id);
	
	public void UpdateSoloDependent(int id, String firstName, String lastName, Date birthday);

}

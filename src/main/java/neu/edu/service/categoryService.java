package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.category.categoryCreation;
import neu.edu.controller.category.categoryModel;
import neu.edu.controller.role.RoleModel;
import neu.edu.dao.categoryDao;
import neu.edu.entity.Category;
import neu.edu.entity.Role;
import neu.edu.dao.ideaDao;

@Service
public class categoryService {
	@Autowired
	private categoryDao categoryDao;
	
	@Autowired
	private ideaDao ideaDao;
	
	@Transactional
	public boolean createCategry(categoryCreation categoryCreation) {
		
		Category category = new Category();
		category.setCategoryName(categoryCreation.getCategoryName());
		category.setCategoryDescription(categoryCreation.getCategoryDescription());
		
		categoryDao.save(category);
		
		return true;
	}
	
	@Transactional
	public List<categoryModel> findAll() {
		// TODO Auto-generated method stub

		return categoryDao.findAll().stream()
			   .map(x -> {
			categoryModel temp = new categoryModel();
			temp.setCategoryId(x.getCategoryId());
			temp.setCategoryName(x.getCategoryName());
			temp.setCategoryDescription(x.getCategoryDescription());
			return temp;
		}).collect(Collectors.toList());
	}

	public boolean deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category category = categoryDao.findOne(categoryId);
		if (ideaDao.findByCategory(category).size() > 0) {
			return false;
		} else {
			categoryDao.delete(category);
		}
		return true;
	}
	
	@Transactional
	public boolean updateCategory(Integer categoryId, categoryCreation categoryCreation) {

		Category category = categoryDao.findOne(categoryId);
		category.setCategoryDescription(categoryCreation.getCategoryDescription());
		category.setCategoryName(categoryCreation.getCategoryName());

		categoryDao.save(category);
		return true;
	}
}

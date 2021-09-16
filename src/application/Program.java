package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println("======= TEST 1: Seller FindById");
		System.out.println(seller);
		
		System.out.println("======= TEST 2: Seller FindByDepartment");
		Department department =  new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("======= TEST 3: Seller FindAll");
		
		list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("======= TEST 4: Seller Insert");
		Seller newSeller = new Seller(null, "GREG", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted: New id = " + newSeller.getId());
		
		System.out.println("======= TEST 5: Seller Update");
		seller = sellerDao.findById(1);
		seller.setName("EDUARDO BORGES");
		sellerDao.update(seller);
		System.out.println("Update Completed");
	}

}

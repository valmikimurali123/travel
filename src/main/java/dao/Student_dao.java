package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Booking_dto;
import dto.Student_dto;




public class Student_dao 
{ 
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
    EntityManager entityManager=factory.createEntityManager();
    EntityTransaction transaction=entityManager.getTransaction();
        public void save(Student_dto dto)
  {
	transaction.begin();
	entityManager.persist(dto);
	transaction.commit();
  }
        
        public void save1(Booking_dto dto)
        {
      	transaction.begin();
      	entityManager.persist(dto);
      	transaction.commit();
        }
              
        

     public Student_dto login(long mob)
  {
	return entityManager.find(Student_dto.class, mob);
  }

      public Student_dto login1(String email)
   {
	// entityManager.createNativeQuery("select * from User_dto where email=?").setParameter(1, email);
        List<Student_dto> list=entityManager.createQuery("select X from Student_dto X where email=?1").setParameter(1, email).getResultList();

    if(list.isEmpty())
  {
	return null;
    }
 else
  {
	return list.get(0);
	
   }
  }
      public List<Booking_dto> fetchAll()
   {
       return	entityManager.createQuery("select x from Booking_dto x").getResultList();
   }
       public Student_dto find(long mob)
       {
   	       return entityManager.find(Student_dto.class, mob);
       }
    
  }
 

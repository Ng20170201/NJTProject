/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.jwt;

import com.NJTProject.rest.webservices.restwebservices.BcryptEncoderTest;
import com.NJTProject.rest.webservices.restwebservices.doctor.Doctor;
import com.NJTProject.rest.webservices.restwebservices.doctor.DoctorJpaRepository;
import com.NJTProject.rest.webservices.restwebservices.patient.Patient;
import com.NJTProject.rest.webservices.restwebservices.patient.PatientsJpaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {
	@Autowired
	private DoctorJpaRepository doctorJpaRepository=new DoctorJpaRepository() {
		
		@Override
		public Optional<Doctor> findOne(Specification<Doctor> spec) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Doctor> findAll(Specification<Doctor> spec, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Page<Doctor> findAll(Specification<Doctor> spec, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Doctor> findAll(Specification<Doctor> spec) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public long count(Specification<Doctor> spec) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public <S extends Doctor> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Doctor> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Doctor> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public <S extends Doctor> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public <S extends Doctor> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<Doctor> findById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean existsById(Long id) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllById(Iterable<? extends Long> ids) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll(Iterable<? extends Doctor> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Doctor entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Page<Doctor> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Doctor> S saveAndFlush(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Doctor> List<S> saveAllAndFlush(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Doctor> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Doctor getOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Doctor getById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public List<Doctor> findAllById(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Doctor> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Doctor> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Doctor> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void deleteAllInBatch(Iterable<Doctor> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllByIdInBatch(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setRepositoryMethodMetadata(CrudMethodMetadata crudMethodMetadata) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Doctor findByUsername(String username) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Doctor> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	@Autowired
	private PatientsJpaRepository patientJpaRepository=new PatientsJpaRepository() {
		
		@Override
		public Optional<Patient> findOne(Specification<Patient> spec) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Patient> findAll(Specification<Patient> spec, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Page<Patient> findAll(Specification<Patient> spec, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Patient> findAll(Specification<Patient> spec) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public long count(Specification<Patient> spec) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public <S extends Patient> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Patient> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Patient> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public <S extends Patient> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public <S extends Patient> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<Patient> findById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean existsById(Long id) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllById(Iterable<? extends Long> ids) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll(Iterable<? extends Patient> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Patient entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Page<Patient> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Patient> S saveAndFlush(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Patient> List<S> saveAllAndFlush(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Patient> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Patient getOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Patient getById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public List<Patient> findAllById(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Patient> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Patient> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Patient> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void deleteAllInBatch(Iterable<Patient> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllByIdInBatch(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setRepositoryMethodMetadata(CrudMethodMetadata crudMethodMetadata) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public List<Patient> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

            @Override
            public Patient findByUCIN(String ucin) {
                return null;
            }
	};
	
	List<Doctor> doctors=doctorJpaRepository.findAll();
	
	 BcryptEncoderTest bcr=new BcryptEncoderTest();
     List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
    Long counter=0L;
    JwtTokenUtil jwtTokenUtil= new JwtTokenUtil();
    
    static {
//    	
//        inMemoryUserList.add(new JwtUserDetails(1L, "admin",
//                "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
//        inMemoryUserList.add(new JwtUserDetails(2L, "nikola",
//                "$2a$10$JgPgC9WSolPSaITqmiZ3oepPEmfFQOyoHiQiD2LfPnHCF11GOLnv6", "ROLE_USER_2"));
    
    }
    public void makeList() throws Exception {
    	List<Patient> patients=patientJpaRepository.findAll();
        List<Doctor> doctors1=doctorJpaRepository.findAll();
        System.out.println("-------------------"+doctors1);
        System.out.println("==============="+patients);
        String encodedPass="";
       
        if(patients!=null && doctors1!=null) {
        for(int i=0;i<patients.size();i++) {
            bcr.setPassword(patients.get(i).getPassword());
           
            encodedPass=bcr.getEncodedPassword();
            
           
            inMemoryUserList.add(new JwtUserDetails(++counter, patients.get(i).getUCIN(),encodedPass ,"patient"));
        }
      
        for(int i=0;i<doctors1.size();i++) {
            bcr.setPassword(doctors1.get(i).getPassword());
            encodedPass=bcr.getEncodedPassword();
            inMemoryUserList.add(new JwtUserDetails(++counter, doctors1.get(i).getUsername(),encodedPass,"doctor"));
         
        }
       System.out.println("Memory list"+inMemoryUserList);
     
        for(int i=0;i<inMemoryUserList.size();i++) {
        	
        	jwtTokenUtil.generateToken((UserDetails) inMemoryUserList.get(i));
        	   
        }
       
        }
   }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	try {
			makeList();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();

        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        return findFirst.get();
    }
    public void addUserDetails(Patient patient) throws Exception{
      /*  String username=patient.getEmail();
        bcryptEncoderTest.setPassword(username);
        String token=bcryptEncoderTest.getEncodedPassword();
        inMemoryUserList.add(new JwtUserDetails(Long.parseLong(i+""), username, token, "ROLE_USER_2"));
     */   
    }
   
    
}

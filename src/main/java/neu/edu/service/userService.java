package neu.edu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import neu.edu.controller.role.RoleModel;
import neu.edu.controller.user.UserModel;
import neu.edu.controller.user.userCreation;

import neu.edu.dao.userDao;
import neu.edu.dao.roleDao;
import neu.edu.entity.Role;
import neu.edu.entity.User;

@Service
public class userService implements UserDetailsService{

	@Autowired
	private userDao userDao;
	
	@Autowired
	private roleDao roleDao;
	
	@Transactional
	public boolean creatUser(userCreation userCreation) {
		Role role = roleDao.findOne(userCreation.getRoleId());
		
		if (role != null) {
			User user = new User();
			
			user.setUserUsername(userCreation.getUserUsername());
			user.setUserPassword(getHashedPassword(userCreation.getUserPassword()));
			user.setUserBalance(userCreation.getUserBalance());
			user.setUserStatus(userCreation.getUserStatus());
			user.setRole(role);
			
			user = userDao.save(user);
			
			return true;
		}
		
		return false;
	}
	
	@Transactional
	public List<UserModel> findAll() {

		return userDao.findAll().stream()
				.map(user -> {

					UserModel userProfile = new UserModel();
					userProfile.setUserId(user.getUserId());
					userProfile.setUsername(user.getUserUsername());
					
					Role role = user.getRole();
					RoleModel roleModel = new RoleModel(role.getRoleId());
					roleModel.setRoleName(role.getRoleName());
					roleModel.setRoleDesc(role.getRoleDescription());
					userProfile.setRole(roleModel);
					
					return userProfile;
		}).collect(Collectors.toList());

	}

	
	private  String getHashedPassword(String password) {
	  	ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
	  	String hashed = encoder.encodePassword(password, null);
	  	return hashed;
	}
	
	@Transactional
	public boolean deletedUser(Integer userId) {
		userDao.delete(userId);
		return true;
	}
	
	@Transactional
	public boolean updateUserRole(Integer userId,Integer roleId) {
		User user = userDao.findOne(userId);
		Role newRole = roleDao.findOne(roleId);
		if(newRole != null){
			user.setRole(newRole);
			userDao.save(user);
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 User user = userDao.findByuserUsername(username);
		 
		  if(user == null) {
	            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
	        }
		  
		  System.out.println(" User Role -->"+user.getRole().getRoleName());
		  List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		
	    UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUserUsername(), user.getUserPassword(), authorities);

		return userDetails;
	}

	public int findByuserName(String username) {
		// TODO Auto-generated method stub
		int id = userDao.findByuserUsername(username).getUserId();
		return id;
	}
	
	public User findUserByUserName(String username) {
		return userDao.findByuserUsername(username);
	}
	
	
}

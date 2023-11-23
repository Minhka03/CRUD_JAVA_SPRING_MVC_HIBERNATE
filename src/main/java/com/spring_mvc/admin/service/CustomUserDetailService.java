package com.spring_mvc.admin.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring_mvc.admin.dao.UserDAO;
import com.spring_mvc.admin.entities.User;
import com.spring_mvc.admin.entities.User_Role;
import com.spring_mvc.admin.security.entities.CustomUserDetails;


@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserDAO userDAO;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		return loadUser(username);
	}
	
	private UserDetails loadUser(String username) {
		User user = userDAO.findByUserName(username);
		System.out.println(user);
        if (user==null){
            return null;
        }
        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        Set<User_Role> roles = user.getUserRoles();
        for (User_Role account_Role : roles) {
        	grantedAuthoritySet.add(new SimpleGrantedAuthority(account_Role.getRole().getName()));
		}       
        return new CustomUserDetails(grantedAuthoritySet, user.getEmail(), user.getFullName(), user.getPassWord(), user.getUserName(), user.getGender(), user.getAddress(), user.getTelephone(), user.getEnabled(),true,true,true);
	}
	

}



package com.didispace.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.didispace.domain.User;
import com.didispace.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

	  @Autowired
      private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        //SysUser user = userDao.findByUserName(username);
        
    	User user = userRepository.findByName(username);
        
        if(user == null){
        	
        System.out.println("不存在");
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
//        for(Integer role:user.getAge())
//        {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            System.out.println(role.getName());
//        }
        
        
        if(user.getName().equals("corey")){
        	
        	 authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
       
        	   System.out.println("this is corey");
        }
        
        else{
        	
        	authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        	     System.out.println("this is others");
        }
       
        
        
        return new org.springframework.security.core.userdetails.User(user.getName(),
                user.getPassword(), authorities);

    }

}

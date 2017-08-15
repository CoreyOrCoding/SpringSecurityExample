package com.didispace.web;


import com.didispace.domain.User;
import com.didispace.domain.UserRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    //static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
    
    @Autowired
	private UserRepository userRepository;
    

    


    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        //List<User> r = new ArrayList<User>(users.values());
        
    	//userRepository.findById((long) 1).setCourses(courseRepository.findAll());
    	
        List<User> r = userRepository.findAll();
        return r;
    }
    @RequestMapping(value="/more", method=RequestMethod.POST)
    public String postUser(@RequestBody  List<User> users) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
       
    	// users.put(user.getId(), user);
       userRepository.save(users);
       // userRepository.save(new User( user.getName(),  user.getAge()));
       
        return "success";
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@RequestBody  User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
       
    	// users.put(user.getId(), user);
       User a = new User( user.getName(),  user.getAge(), user.getPassword());
       userRepository.save(a);
 
       /*
       List<Course> r = new ArrayList<Course>();
       r.add(c);
       r.add(c2); 
       a.setCourses(r);
       userRepository.save(a);
      */
      
       
        return "success";
    }
    
    @RequestMapping(value="/", method=RequestMethod.PUT)
    public String pputUser(@RequestBody  User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
       
    	// users.put(user.getId(), user);
       
        userRepository.save(user);
       
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
    	//System.out.println(userRepository.findById(id).getAge().longValue()); 
        //return users.get(id);
    	//CurrentUser = userRepository.findById(id);
    	
    
    	//return userRepository.findById(id).getAddress();
    	return userRepository.findById(id);
    }
    
//    @RequestMapping(value="/bycity/{address}", method=RequestMethod.GET)
//    public User getUserAddress(@PathVariable String address) {
//        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
//        // url中的id可通过@PathVariable绑定到函数的参数中
//    	//System.out.println(userRepository.findById(id).getAge().longValue()); 
//        //return users.get(id);
//    	//CurrentUser = userRepository.findById(id);
//    
//       return userRepository.findByAddress_City(address);
//    	//return userRepository.findById(id).getAddress();
//    	//return userRepository.findById(id);
//    }
//
//    




//    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
//    public String putUser(@PathVariable Long id, @RequestBody User user) {
//        // 处理"/users/{id}"的PUT请求，用来更新User信息
//    	
////        User u = users.get(id);
////        u.setName(user.getName());
////        u.setAge(user.getAge());
////        users.put(id, u);
//        
//        userRepository.findById(id).setAge(user.getAge());
//        userRepository.findById(id).setName(user.getName());
//        userRepository.save(userRepository.findById(id));
//        return "success";
//    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        //users.remove(id);
        //userRepository.     
    	userRepository.delete(userRepository.findById(id));
        return "success";
    }

}
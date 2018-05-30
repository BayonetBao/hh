package com.gem.shop.control;

import com.gem.shop.entity.User;
import com.gem.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/user")
@Controller
public class UserControl {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/findUname.action",method = RequestMethod.POST)
//    @ResponseBody将返回值变成Jason
    public @ResponseBody boolean findName(String uname){
    User user=userService.findUserByName(uname);
    if(user!=null){
        //用户存在
        //通过返回值给ajax传递值
        return true;

    }else{
//        用户不存在
        return false;
    }
    }
}

package com.gem.shop.control;

import com.gem.shop.entity.Goods;
import com.gem.shop.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RequestMapping("/goods")
@Controller
public class Goodcontrol {
    @Autowired
    private GoodService goodService;
    //首页
    @RequestMapping("/main.action")
    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clist",goodService.selectAllCatory());
        request.setAttribute("glist",goodService.selectAllGoods());
        request.getRequestDispatcher("/jsp/list.jsp").forward(request,response);
    }
    @RequestMapping("/delete.action")
    public void delete(int id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(goodService.deleteGood(id)){
            request.getRequestDispatcher("/main.action").forward(request,response);
        }else {

        }
    }
    @RequestMapping("/update.action")
    public void update(int id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Goods good=goodService.selectGoodById(id);
        if(good!=null){
            request.setAttribute("good",good);
            request.getRequestDispatcher("/jsp/update.jsp").forward(request,response);
        }
    }
    @RequestMapping(value = "/updateTrue.action")
    public void updateTrue(MultipartFile imgFileUp,Goods goods, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取问件名字
        String filename=imgFileUp.getOriginalFilename();
        //将文件上传服务器（images文件夹的绝对路径）
        String imageFile=request.getServletContext().getRealPath("images");
        String image=imageFile+"/"+filename;
        //创建

        File file=new File(image);

        if(!file.exists()){
            file.mkdirs();
        }else {
            file.delete();
            file.mkdirs();
        }
        //通过io流技术将自己电脑上的内容读取到服务器上新创建的文件上
        imgFileUp.transferTo(file);//图片的复制
        //修改图片路径
        goods.setPic("images/"+filename);
        if(goodService.updateGood(goods)){
            request.getRequestDispatcher("/goods/main.action").forward(request,response);
        }
    }
}

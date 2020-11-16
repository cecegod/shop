package com.service;

import com.mapper.StoryMapper;
import com.mapper.StoryProductMapper;
import com.po.Product;
import com.po.Story;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Service
public class StoryService {
    @Resource
    StoryMapper storyMapper;
    @Resource
    StoryProductMapper storyProductMapper;




    public Story getStroy(Integer userid) {
        return storyMapper.getEntity(new Story(null,null,userid,null));
    }

    public Map getStoryProducts(Integer userid,Integer pageNow) {

        RestTemplate restTemplate=new RestTemplate();
       Map map = restTemplate.getForObject("http://localhost:8081/getStoryProducts?userid="+userid+"&pageNow="+pageNow, Map.class);
        return map;
    }

    public Boolean addproduct(Product product, MultipartFile file, HttpServletRequest request) {

        String contextPath = request.getContextPath();
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String basepath=scheme+"://"+serverName+":"+serverPort+contextPath+"/";

        String fileName = file.getOriginalFilename();
        String pnamesufix=fileName.substring(fileName.lastIndexOf("."));
        long time = new Date().getTime();
        String pnameprefix=product.getUserid()+"_"+time;
        String pname=pnameprefix+pnamesufix;

        String photoname=basepath+pname;
        product.setProductphotoname(photoname);
        String filePath = this.getClass().getResource("/").getPath();
        new File(filePath + "static").mkdirs();

        File dest = new File(filePath + "static/"+pname);
        try {
            file.transferTo(dest);
            System.out.println("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return storyProductMapper.addEntity(product);

    }

    public Boolean deleeteProduct(Integer productid) {
        Product product = new Product();
        product.setId(productid);
      return   storyProductMapper.deleteEntity(product);

    }

    public Product getStoryProduct(Integer id) {

        RestTemplate restTemplate=new RestTemplate();
        Product p = restTemplate.getForObject("http://localhost:8081/getProduct?id=" + id, Product.class);
        return p;
    }

    public Boolean updateStoryProduct(Product product) {
        Product product1 = new Product();
        product1.setId(product.getId());
        return storyProductMapper.updateEntity(product,product1);
    }


}

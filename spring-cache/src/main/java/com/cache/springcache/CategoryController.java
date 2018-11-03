package com.cache.springcache;

import com.cache.springcache.dto.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/**
 * @author zhuzhenke
 * @date 2018/10/29
 */
@RestController
@RequestMapping("/catelog")
public class CategoryController {

    @RequestMapping("/add")
    public BaseResponse addCatalogName() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(100);
        baseResponse.setResult("getName...");
        return baseResponse;
    }

    @RequestMapping("/delete")
    public BaseResponse deleteCatalogName() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(100);
        baseResponse.setResult("getName...");
        return baseResponse;
    }

    @RequestMapping("/update")
    public BaseResponse updateCatalogName() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(100);
        baseResponse.setResult("getName...");
        return baseResponse;
    }

    @RequestMapping("/get")
    public BaseResponse getCatalogName() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(100);
        baseResponse.setResult("getName...");
        return baseResponse;
    }

    @RequestMapping("/list")
    public List<String> getList() {
        List<String> result = new ArrayList<String>();
        result.add("name1");
        result.add("name2");
        result.add("name3");
        return result;
    }
}

package com.cache.springcache;

import com.cache.springcache.dto.BaseResponse;
import com.cache.springcache.dto.Category;
import com.cache.springcache.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuzhenke
 * @date 2018/10/29
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/add")
    public BaseResponse addCategory(Long cateId,
                                    String cateName,
                                    Long parentId) {
        Category category = new Category(cateId, cateName, parentId);
        int effectRows = categoryService.add(category);
        if (effectRows == 0) {
            return BaseResponse.fail("insert db fail");
        } else {
            return BaseResponse.success(null);
        }
    }

    @RequestMapping("/delete")
    public BaseResponse deleteCategory(Long cateId) {
        int effectRows = categoryService.delete(new Category(cateId, null, null));
        if (effectRows == 0) {
            return BaseResponse.fail("delete fail");
        } else {
            return BaseResponse.success(null);
        }
    }

    @RequestMapping("/update")
    public BaseResponse updateCategory(Long cateId,
                                       String cateName,
                                       Long parentId) {
        Category category = new Category(cateId, cateName, parentId);
        int effectRows = categoryService.update(category);
        if (effectRows == 0) {
            return BaseResponse.fail("update db fail");
        } else {
            return BaseResponse.success(null);
        }
    }

    @RequestMapping("/get")
    public BaseResponse getCategory(Long cateId) {
        Category category = new Category();
        category.setCateId(cateId);
        return BaseResponse.success(categoryService.get(category));
    }
}

package org.chikoo.rest.resources.asm;

import org.chikoo.core.service.util.BlogList;
import org.chikoo.rest.resources.BlogListResource;
import org.chikoo.rest.web.controller.BlogController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogListResourceAsm extends ResourceAssemblerSupport<BlogList, BlogListResource> {

    public BlogListResourceAsm()
    {
        super(BlogController.class, BlogListResource.class);
    }

    @Override
    public BlogListResource toResource(BlogList blogList) {
        BlogListResource res = new BlogListResource();
        res.setBlogs(new BlogResourceAsm().toResources(blogList.getBlogs()));
        return res;
    }
}

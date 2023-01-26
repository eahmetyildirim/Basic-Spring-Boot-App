package net.finalproject.service;

import com.nimbusds.oauth2.sdk.util.CollectionUtils;
import net.finalproject.models.Page;
import net.finalproject.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PageService {
    @Autowired
    private PageRepository repo;

    public void save(Page page) {
        String url=urlBuild(page.getTitle());
        page.setUrl(url);
        repo.save(page);
    }
    public String urlBuild(String title){
        String clearTitle = title;
        char[] turkishChars = new char[] {0x131, 0x130, 0xFC, 0xDC, 0xF6, 0xD6, 0x15F, 0x15E, 0xE7, 0xC7, 0x11F, 0x11E,' '};
        char[] englishChars = new char[] {'i', 'I', 'u', 'U', 'o', 'O', 's', 'S', 'c', 'C', 'g', 'G','-'};
        for (int i = 0; i < turkishChars.length; i++) {
            clearTitle = clearTitle.replaceAll(new String(new char[]{turkishChars[i]}), new String(new char[]{englishChars[i]}));
        }
        StringBuilder urlBuild=new StringBuilder(clearTitle.toLowerCase());

        List<Page> pageList=repo.getPageListUrlPathLike(clearTitle);
        if(CollectionUtils.isNotEmpty(pageList)){
            int urlCount=pageList.size();
            urlBuild.append("-");
            urlBuild.append(urlCount);
        }

        return urlBuild.toString();
    }
    public List<Page> search(String searchKey){
        List<Page> pageList=repo.searchPage(searchKey);
        return pageList;
    }
    public List<Page> getAllPageList(){
        return repo.findAll();
    }

    public Page getPageByUrlAndCategoryUrl(String pageUrl,String categoryUrl){
        return repo.getPageByUrlAndCategoryUrl(pageUrl,categoryUrl);
    }
}

package zebra.manager;

import zebra.json.Search;

/**
 * Created by multimedia on 2016-05-25.
 */
public class SearchManager {
    private static SearchManager instance;
    public static SearchManager getInstance(){
        if(instance == null){
            instance = new SearchManager();
        }
        return instance;
    }

    Search search;

    public void setSearch(Search search){
        this.search = search;
    }

    public void setSearchNull(){
        this.search = null;
    }

    public Search getSearch(){
        return search;
    }
}

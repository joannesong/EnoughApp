package nyc.c4q.enough.model;

import java.util.List;

/**
 * Created by joannesong on 3/3/18.
 */

public class NYTResults {

    private List<Results> results;
    private int num_results;
    private String last_updated;
    private String section;
    private String copyright;
    private String status;

    public List<Results> getResults() {
        return results;
    }

    public int getNum_results() {
        return num_results;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public String getSection() {
        return section;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getStatus() {
        return status;
    }
}

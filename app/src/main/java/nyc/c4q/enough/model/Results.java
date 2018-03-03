package nyc.c4q.enough.model;

import java.util.List;

public class Results {
    private String short_url;
    private List<Multimedia> multimedia;
    private List<String> geo_facet;
    private List<String> per_facet;
    private List<String> org_facet;
    private List<String> des_facet;
    private String kicker;
    private String material_type_facet;
    private String published_date;
    private String created_date;
    private String updated_date;
    private String item_type;
    private String byline;
    private String url;
    private String title;
    private String subsection;
    private String section;

    public String getShort_url() {
        return short_url;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public List<String> getGeo_facet() {
        return geo_facet;
    }

    public List<String> getPer_facet() {
        return per_facet;
    }

    public List<String> getOrg_facet() {
        return org_facet;
    }

    public List<String> getDes_facet() {
        return des_facet;
    }

    public String getKicker() {
        return kicker;
    }

    public String getMaterial_type_facet() {
        return material_type_facet;
    }

    public String getPublished_date() {
        return published_date;
    }

    public String getCreated_date() {
        return created_date;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public String getItem_type() {
        return item_type;
    }

    public String getByline() {
        return byline;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getSubsection() {
        return subsection;
    }

    public String getSection() {
        return section;
    }
}

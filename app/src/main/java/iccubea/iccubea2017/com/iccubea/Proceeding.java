package iccubea.iccubea2017.com.iccubea;

import java.io.Serializable;

/**
 * Created by Ankush on 26-07-2017.
 */

public class Proceeding implements Serializable {
    String author, paperTitle, domain, link;

    public Proceeding(String author, String paperTitle, String domain, String link) {
        this.author = author;
        this.paperTitle = paperTitle;
        this.domain = domain;
        this.link = link;
    }

    public Proceeding() {
        this.author = "NA";
        this.paperTitle = "NA";
        this.domain = "NA";
        this.link = "NA";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

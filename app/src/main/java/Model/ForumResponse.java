package Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ramola on 7/31/2016.
 */
public class ForumResponse {

    @SerializedName("total")
    private String total_count;

    @SerializedName("")
    private List<ForumModel> forum;

    public ForumResponse(String total_count, List<ForumModel> forum) {
        this.total_count = total_count;
        this.forum = forum;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public List<ForumModel> getForum() {
        return forum;
    }

    public void setForum(List<ForumModel> forum) {
        this.forum = forum;
    }
}

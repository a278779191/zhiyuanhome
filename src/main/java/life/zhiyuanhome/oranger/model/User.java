package life.zhiyuanhome.oranger.model;

/**
 * @author yzy
 * @create 2019-07-18 21:28
 */
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String Token;
    private  Long gmtCreate;
    private  Long gmtModified;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }


    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}

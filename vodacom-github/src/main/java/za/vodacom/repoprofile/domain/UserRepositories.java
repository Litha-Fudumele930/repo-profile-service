package za.vodacom.repoprofile.domain;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "user_repositories")
public class UserRepositories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "repo_name")
    private String repoName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "language")
    private String language;

    @Column(name = "stargazers_count")
    private int stargazersCount;

    @Column(name = "html_url")
    private String htmlUrl;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserRepositories{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", repoName='" + repoName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", language='" + language + '\'' +
                ", stargazersCount=" + stargazersCount +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

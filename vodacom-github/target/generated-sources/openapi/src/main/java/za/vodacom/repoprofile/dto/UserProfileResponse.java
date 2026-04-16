package za.vodacom.repoprofile.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import za.vodacom.repoprofile.dto.Repository;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UserProfileResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-16T17:49:49.951314600+02:00[Africa/Johannesburg]")
public class UserProfileResponse {

  private String username;

  private String bio;

  private String avatarUrl;

  private Integer publicRepos;

  private Integer followers;

  @Valid
  private List<@Valid Repository> repositories;

  public UserProfileResponse username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  
  @Schema(name = "username", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserProfileResponse bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * Get bio
   * @return bio
  */
  
  @Schema(name = "bio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public UserProfileResponse avatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
    return this;
  }

  /**
   * Get avatarUrl
   * @return avatarUrl
  */
  
  @Schema(name = "avatar_url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avatar_url")
  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public UserProfileResponse publicRepos(Integer publicRepos) {
    this.publicRepos = publicRepos;
    return this;
  }

  /**
   * Get publicRepos
   * @return publicRepos
  */
  
  @Schema(name = "publicRepos", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("publicRepos")
  public Integer getPublicRepos() {
    return publicRepos;
  }

  public void setPublicRepos(Integer publicRepos) {
    this.publicRepos = publicRepos;
  }

  public UserProfileResponse followers(Integer followers) {
    this.followers = followers;
    return this;
  }

  /**
   * Get followers
   * @return followers
  */
  
  @Schema(name = "followers", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("followers")
  public Integer getFollowers() {
    return followers;
  }

  public void setFollowers(Integer followers) {
    this.followers = followers;
  }

  public UserProfileResponse repositories(List<@Valid Repository> repositories) {
    this.repositories = repositories;
    return this;
  }

  public UserProfileResponse addRepositoriesItem(Repository repositoriesItem) {
    if (this.repositories == null) {
      this.repositories = new ArrayList<>();
    }
    this.repositories.add(repositoriesItem);
    return this;
  }

  /**
   * Get repositories
   * @return repositories
  */
  @Valid 
  @Schema(name = "repositories", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("repositories")
  public List<@Valid Repository> getRepositories() {
    return repositories;
  }

  public void setRepositories(List<@Valid Repository> repositories) {
    this.repositories = repositories;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserProfileResponse userProfileResponse = (UserProfileResponse) o;
    return Objects.equals(this.username, userProfileResponse.username) &&
        Objects.equals(this.bio, userProfileResponse.bio) &&
        Objects.equals(this.avatarUrl, userProfileResponse.avatarUrl) &&
        Objects.equals(this.publicRepos, userProfileResponse.publicRepos) &&
        Objects.equals(this.followers, userProfileResponse.followers) &&
        Objects.equals(this.repositories, userProfileResponse.repositories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, bio, avatarUrl, publicRepos, followers, repositories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserProfileResponse {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    avatarUrl: ").append(toIndentedString(avatarUrl)).append("\n");
    sb.append("    publicRepos: ").append(toIndentedString(publicRepos)).append("\n");
    sb.append("    followers: ").append(toIndentedString(followers)).append("\n");
    sb.append("    repositories: ").append(toIndentedString(repositories)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


package za.vodacom.repoprofile.dto.github;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UserProfileDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-16T17:49:50.494083200+02:00[Africa/Johannesburg]")
public class UserProfileDTO {

  private String login;

  private String name;

  private String bio;

  private String avatarUrl;

  private Integer publicRepos;

  private Integer followers;

  public UserProfileDTO login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Get login
   * @return login
  */
  
  @Schema(name = "login", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public UserProfileDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserProfileDTO bio(String bio) {
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

  public UserProfileDTO avatarUrl(String avatarUrl) {
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

  public UserProfileDTO publicRepos(Integer publicRepos) {
    this.publicRepos = publicRepos;
    return this;
  }

  /**
   * Get publicRepos
   * @return publicRepos
  */
  
  @Schema(name = "public_repos", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("public_repos")
  public Integer getPublicRepos() {
    return publicRepos;
  }

  public void setPublicRepos(Integer publicRepos) {
    this.publicRepos = publicRepos;
  }

  public UserProfileDTO followers(Integer followers) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserProfileDTO userProfileDTO = (UserProfileDTO) o;
    return Objects.equals(this.login, userProfileDTO.login) &&
        Objects.equals(this.name, userProfileDTO.name) &&
        Objects.equals(this.bio, userProfileDTO.bio) &&
        Objects.equals(this.avatarUrl, userProfileDTO.avatarUrl) &&
        Objects.equals(this.publicRepos, userProfileDTO.publicRepos) &&
        Objects.equals(this.followers, userProfileDTO.followers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(login, name, bio, avatarUrl, publicRepos, followers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserProfileDTO {\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    avatarUrl: ").append(toIndentedString(avatarUrl)).append("\n");
    sb.append("    publicRepos: ").append(toIndentedString(publicRepos)).append("\n");
    sb.append("    followers: ").append(toIndentedString(followers)).append("\n");
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


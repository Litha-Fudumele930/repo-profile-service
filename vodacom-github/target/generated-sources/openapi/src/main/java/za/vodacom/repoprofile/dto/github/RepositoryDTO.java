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
 * RepositoryDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-16T17:49:50.494083200+02:00[Africa/Johannesburg]")
public class RepositoryDTO {

  private Integer id;

  private String name;

  private String fullName;

  private String language;

  private Integer stargazersCount;

  private String htmlUrl;

  public RepositoryDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RepositoryDTO name(String name) {
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

  public RepositoryDTO fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Get fullName
   * @return fullName
  */
  
  @Schema(name = "full_name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("full_name")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public RepositoryDTO language(String language) {
    this.language = language;
    return this;
  }

  /**
   * Get language
   * @return language
  */
  
  @Schema(name = "language", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("language")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public RepositoryDTO stargazersCount(Integer stargazersCount) {
    this.stargazersCount = stargazersCount;
    return this;
  }

  /**
   * Get stargazersCount
   * @return stargazersCount
  */
  
  @Schema(name = "stargazers_count", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("stargazers_count")
  public Integer getStargazersCount() {
    return stargazersCount;
  }

  public void setStargazersCount(Integer stargazersCount) {
    this.stargazersCount = stargazersCount;
  }

  public RepositoryDTO htmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
    return this;
  }

  /**
   * Get htmlUrl
   * @return htmlUrl
  */
  
  @Schema(name = "html_url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("html_url")
  public String getHtmlUrl() {
    return htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepositoryDTO repositoryDTO = (RepositoryDTO) o;
    return Objects.equals(this.id, repositoryDTO.id) &&
        Objects.equals(this.name, repositoryDTO.name) &&
        Objects.equals(this.fullName, repositoryDTO.fullName) &&
        Objects.equals(this.language, repositoryDTO.language) &&
        Objects.equals(this.stargazersCount, repositoryDTO.stargazersCount) &&
        Objects.equals(this.htmlUrl, repositoryDTO.htmlUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, fullName, language, stargazersCount, htmlUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepositoryDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    stargazersCount: ").append(toIndentedString(stargazersCount)).append("\n");
    sb.append("    htmlUrl: ").append(toIndentedString(htmlUrl)).append("\n");
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


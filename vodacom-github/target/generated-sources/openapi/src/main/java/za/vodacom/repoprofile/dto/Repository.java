package za.vodacom.repoprofile.dto;

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
 * Repository
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-16T17:49:49.951314600+02:00[Africa/Johannesburg]")
public class Repository {

  private Integer id;

  private String name;

  private String fullName;

  private String language;

  private Integer stargazersCount;

  private String htmlUrl;

  private String frequentLanguage;

  public Repository id(Integer id) {
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

  public Repository name(String name) {
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

  public Repository fullName(String fullName) {
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

  public Repository language(String language) {
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

  public Repository stargazersCount(Integer stargazersCount) {
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

  public Repository htmlUrl(String htmlUrl) {
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

  public Repository frequentLanguage(String frequentLanguage) {
    this.frequentLanguage = frequentLanguage;
    return this;
  }

  /**
   * Get frequentLanguage
   * @return frequentLanguage
  */
  
  @Schema(name = "frequent_language", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("frequent_language")
  public String getFrequentLanguage() {
    return frequentLanguage;
  }

  public void setFrequentLanguage(String frequentLanguage) {
    this.frequentLanguage = frequentLanguage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Repository repository = (Repository) o;
    return Objects.equals(this.id, repository.id) &&
        Objects.equals(this.name, repository.name) &&
        Objects.equals(this.fullName, repository.fullName) &&
        Objects.equals(this.language, repository.language) &&
        Objects.equals(this.stargazersCount, repository.stargazersCount) &&
        Objects.equals(this.htmlUrl, repository.htmlUrl) &&
        Objects.equals(this.frequentLanguage, repository.frequentLanguage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, fullName, language, stargazersCount, htmlUrl, frequentLanguage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Repository {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    stargazersCount: ").append(toIndentedString(stargazersCount)).append("\n");
    sb.append("    htmlUrl: ").append(toIndentedString(htmlUrl)).append("\n");
    sb.append("    frequentLanguage: ").append(toIndentedString(frequentLanguage)).append("\n");
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


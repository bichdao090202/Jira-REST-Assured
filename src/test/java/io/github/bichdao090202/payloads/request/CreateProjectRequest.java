package io.github.bichdao090202.payloads.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectRequest {
    private String key;
    private String name;
    private String projectTypeKey;
    private String leadAccountId;


    private String projectTemplateKey;
    private String description;
    private String url;
    private String assigneeType;


}

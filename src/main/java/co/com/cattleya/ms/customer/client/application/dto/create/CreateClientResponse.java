package co.com.cattleya.client.application.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientResponse {
    private String name;
    private int age;
    private String description;
    private String photo;
}

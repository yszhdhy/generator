package cloud.makeronbean.generate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PomAttribute {

    private String SpringbootVersion;

    private String artifactId;

    private String packaging;
}

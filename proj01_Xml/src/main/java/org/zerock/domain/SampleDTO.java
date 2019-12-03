package org.zerock.domain;
//129
import lombok.Data;
//@Data: getter()&setter(),생성자,toString등을 자동으로 내부적으로 생성
@Data
public class SampleDTO {
	private String name;
	private int age;
}

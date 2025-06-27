package com.itzixi.pojo.bo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.bridge.MessageWriter;
import org.hibernate.validator.constraints.Length;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VerifySMSBO {

    @NotBlank(message = "手机号不能为空")
    @Length(message = "手机号长度不正确", min = 11, max = 11)
    private String mobile;

    @NotBlank(message = "验证码不能为空")
    private String smsCode;

}

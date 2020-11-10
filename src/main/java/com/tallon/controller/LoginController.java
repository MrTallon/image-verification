package com.tallon.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.tallon.util.CaceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-11-10 11:21
 */
@Controller
public class LoginController {
    @Resource
    private Producer producer;

    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store,no-cache");
        response.setContentType("img/jpeg");

        String text = producer.createText();
        BufferedImage image = producer.createImage(text);

        CaceUtil.addMap(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    @ResponseBody
    @PostMapping("/sys/login")
    public String login(String username, String password, String captcha) {
        String kaptch = CaceUtil.getVal(Constants.KAPTCHA_SESSION_KEY);
        //cdcy6
        if (!captcha.equalsIgnoreCase(kaptch)) {
            return "验证码错误";
        }
        return "验证码正确";
    }
}

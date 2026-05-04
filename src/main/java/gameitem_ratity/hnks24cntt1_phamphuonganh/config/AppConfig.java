package gameitem_ratity.hnks24cntt1_phamphuonganh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = "D:\\JavaWeb App\\PTIT_CNTT1_IT210_Sessions\\HN-KS24-CNTT1_PhamPhuongAnh\\src\\main\\resources\\static\\images\\";
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + path);
    }
}

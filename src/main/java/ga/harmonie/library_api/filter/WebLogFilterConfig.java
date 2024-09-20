package ga.harmonie.library_api.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebLogFilterConfig  implements WebMvcConfigurer {

    @Autowired
    private LogHttpRequestInterceptor logHttpRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logHttpRequestInterceptor);
    }
}

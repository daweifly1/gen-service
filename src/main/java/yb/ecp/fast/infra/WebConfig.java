package yb.ecp.fast.infra;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig
  extends WebMvcConfigurerAdapter
{
  public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer)
  {
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    antPathMatcher.setCaseSensitive(false);
    pathMatchConfigurer.setPathMatcher(antPathMatcher);
  }
}

package com.ezticket.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ezticket.common.interceptor.CheckLoginSessionInterceptor;


@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addInterceptor(new CheckLoginSessionInterceptor()) //LoginCheckInterceptor 등록
//		.order(2)
		.addPathPatterns("/**")
		.excludePathPatterns(
				"/usr/**"
				,"/xdm/**"
				,"/login"
				,"/signup"
				,"/portfolio"
				,"/loginchek"
				,"/useLogin"
				,"/useIndex"
				,"/usePerformanceList"
				,"/usePerformanceArea"
				,"/usePerformanceRanking"
				,"/usePerformancepage"
				,"/kakaologin"
				,"/useSession"
				,"/test"
				,"/test3"
				,"/test4"
				,"/restlist"
				,"/restone/{mbSeq}"
				,"/restinst"
				,"/restupdate/{mbSeq}"
				,"/restdelete/{mbSeq}"
				,"/codeXdmListAjax"
				);
		//WebMvcConfigurer.super.addInterceptors(registry);
	}

	

	
}
